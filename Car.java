import java.time.LocalDateTime;
import java.util.Objects;

class Car implements Comparable<Car> {
    private String VIN;
    private String model;
    private String manufacturer;
    private LocalDateTime made;
    private float mileage;
    private int price;

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
