package by.it.zeynalov.jd01_02;

public class TaskB {

    public static void matrica(int k) {
        int n = (int) Math.sqrt(k);
        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%3d ", x + 1);
                x++;
            }
            System.out.println();
        }
    }
}
