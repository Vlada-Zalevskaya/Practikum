import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CarDealership {
    static class Car implements Comparable<Car> {
        private String VIN;
        private String model;
        private String manufacturer;
        private LocalDateTime made;
        private float mileage;
        private int price;
        private CarType type;

        public Car(String VIN, String model, String manufacturer, LocalDateTime made, float mileage, int price) {
            this.VIN = VIN;
            this.model = model;
            this.manufacturer = manufacturer;
            this.made = made;
            this.mileage = mileage;
            this.price = price;
        }

        public String VIN() {
            return VIN;
        }

        public String manufacturer() {
            return manufacturer;
        }

        public int price() {
            return price;
        }

        public float mileage() {
            return mileage;
        }

        @Override
        public int hashCode() {
            return VIN.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Objects.equals(VIN, car.VIN);
        }

        @Override
        public int compareTo(Car o) {
            return o.made.compareTo(made);
        }
    }

    private List<Car> carList = new ArrayList<>();

    public void create(Car car) {
        if (!carList.contains(car)) {
            carList.add(car);
        }
    }

    public List<Car> getManufacturedBy(String manufacturer) {
        return carList.stream().filter(c -> c.manufacturer.equals(manufacturer)).collect(Collectors.toList());
    }

    public double averageTypePrice(CarType type) {
        return carList.stream().filter(c -> c.type == type).collect(Collectors.averagingDouble(c -> c.price));
    }

    public List<Car> carsByDate() {
        return carList.stream().sorted((c1, c2) -> -c1.made.compareTo(c2.made)).collect(Collectors.toList());
    }

    public int countCarType(CarType type) {
        return (int) carList.stream().filter(c -> c.type == type).count();
    }

    public Car newest() {
        return carList.stream().max(Comparator.comparing(c -> c.made)).orElse(null);
    }

    public Car oldest() {
        return carList.stream().min(Comparator.comparing(c -> c.made)).orElse(null);
    }

    public static void main(String[] args) {
        CarDealership dealership = new CarDealership();

        Scanner scin = new Scanner(System.in);
        while (scin.hasNext()) {
            String cmd = scin.next();
            switch (cmd) {
                case "newest":
                    System.out.println(dealership.newest().VIN);
                    break;
                case "oldest":
                    System.out.println(dealership.oldest().VIN);
                    break;
                case "create":
                    dealership.create(new Car(scin.next(), scin.next(), scin.next(), LocalDateTime.parse(scin.next()),
                            scin.nextFloat(), scin.nextInt()));
                    break;
                case "getManufacturedBy":
                    dealership.getManufacturedBy(scin.next()).forEach(c -> System.out.println(c.VIN));
                    break;
                case "averageTypePrice":
                    System.out.println(dealership.averageTypePrice(CarType.valueOf(scin.next())));
                    break;
                case "countCarType":
                    System.out.println(dealership.countCarType(CarType.valueOf(scin.next())));
                    break;
                case "carsByDate":
                    dealership.carsByDate().forEach(c -> System.out.println(c.VIN));
                    break;
            }
        }
    }

}
