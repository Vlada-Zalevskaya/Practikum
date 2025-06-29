public class Task2_1 {
    public static void main(String[] args) {
        int[] years = new int[50];
        for (int i = 0; i < 50; i++) {
            years[i] = (int)(Math.random() * 26) + 2000;
        }

        for (int i = 0; i < 50; i++) {
            if (years[i] > 2015) {
                System.out.println(years[i]);
            }
        }
    }
}
