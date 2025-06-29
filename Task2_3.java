import java.time.LocalDateTime;
import java.util.HashSet;

public class Task2_3 {

    public static void main(String[] args) {
        HashSet<Car> cars = new HashSet<>();
        cars.add(new Car("s123ad", "T1", "T", LocalDateTime.of(2000, 05, 01, 12, 0), 100f, 1000));
        cars.add(new Car("m123ad", "T2", "T", LocalDateTime.of(2000, 05, 02, 12, 0), 90f, 1010));
        cars.add(new Car("d123ad", "T2", "T", LocalDateTime.of(2000, 04, 01, 12, 0), 120f, 1020));
        cars.add(new Car("m123ad", "T2", "T", LocalDateTime.of(2000, 05, 02, 12, 0), 90f, 1010));
        System.out.println(cars.size());
    }
}
