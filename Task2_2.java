import java.util.*;

public class Task2_2 {
    public static void main(String[] args) {
        List<String> models = new ArrayList<>(List.of("Toyota Camry",  "BMW X5", "Porsche 911", "BMW M5",
                "Lada Vesta", "Hyundai Solaris", "Kia Rio", "Niva", "UAZ-452", "Hyundai Solaris", "Tesla Model X",
                "Niva", "Kia K5", "Hyundai Solaris", "BMW X5", "Geely Monjaro", "Lada Iskra", "Toyota Camry",
                "Tesla Model X", "Tesla Model 3"));

        List<String> newModels = new ArrayList<>();
        for (Iterator<String> i = models.iterator(); i.hasNext();) {
            String s = i.next();
            if (s.contains("Tesla")) {
                s = "ELECTRO_CAR";
            }
            if (!newModels.contains(s)) {
                newModels.add(s);
            }
        }
        models = newModels;
        models.sort(Comparator.reverseOrder());
        Set<String> modelSet = new HashSet<>();
        for (String s : models) {
            System.out.println(s);
            modelSet.add(s);
        }
    }
}
