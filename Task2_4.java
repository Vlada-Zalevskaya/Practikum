import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.stream.Collectors;

public class Task2_4 {
    public static void main(String[] args) {
        List<Car> cars = List.of(
            new Car("s123ad", "T1", "T", LocalDateTime.of(2000, 05, 01, 12, 0), 50000f, 1000),
            new Car("m123ad", "T2", "T", LocalDateTime.of(2000, 05, 02, 12, 0), 90000f, 1010),
            new Car("d123ad", "T2", "T", LocalDateTime.of(2000, 04, 01, 12, 0), 12000f, 1020),
            new Car("b123ad", "X2", "X", LocalDateTime.of(2020, 01, 01, 12, 0), 82000f, 2000)
        );
        System.out.println("----");
        cars.stream()
                .filter(c -> c.mileage() < 50000f)
                .forEach(c -> System.out.println(c.VIN()));
        System.out.println("----");
        cars.stream()
                .sorted((c1, c2) -> -Float.compare(c1.price(), c2.price()))
                .forEach(c -> System.out.println(c.VIN()));
        System.out.println("----");
        cars.stream()
                .sorted((c1, c2) -> -Float.compare(c1.price(), c2.price()))
                .limit(3)
                .forEach(c -> System.out.println(c.VIN()));
        System.out.println("----");
        System.out.println(cars.stream().collect(Collectors.averagingDouble(c -> (double) c.mileage())));
        System.out.println("----");
        System.out.println(cars.stream().collect(Collectors.groupingBy(Car::manufacturer)));
    }
}
