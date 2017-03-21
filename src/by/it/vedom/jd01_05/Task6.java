package by.it.vedom.jd01_05;
import static java.lang.Math.sin;

public class Task6 {

    public static double[] getArray() {
        int sizeOfArray = 35;
        double[] array = new double[sizeOfArray];
        for (double x = 0.0, j = 0; x < 7.0; x += 0.2, j++) {
            array[(int) j] = x + sin(x);
            if (j == sizeOfArray - 1) break;
        }
        return array;
    }

    public static double getSumElementsMoreThanThree(double[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3)
                sum += array[i];
        }
        return sum;
    }

    public void printArray(double[] array, String name) {
        String header = "Array: " + name + ".";
        System.out.println(header);
        for (int index = 0; index < array.length; index++) {
            System.out.println(String.format("%-1s%-1s%-1s%2s%20s", "[", index, "]", "=", array[index]));
        }
    }

    public static double[] getElementsMoreThanThree(double[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3) count++;
        }

        double[] newArray = new double[count];
        int index = 0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > 3) {
                newArray[index] = array[j];
                index++;
            }
        }
        return newArray;
    }


}
