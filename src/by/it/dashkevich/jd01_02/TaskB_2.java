package by.it.dashkevich.jd01_02;

/**
 * Created by дёня on 02.03.2017.
 */
public class TaskB_2 {
    //вывести числа от 1-k в виде матрицы NxN слева направо и сверху вниз(k - квадрат целого числа)
    public static void main(String[] args) {
        int rows, span;  //ряды, столбцы
        int i=0;
        int k = 9;  // квадрат целого числа
        int [] [] array = new int[(int)Math.sqrt(k)][(int)Math.sqrt(k)];
        for( rows = 0; rows<array.length; rows++) {
            for (span = 0; span<array.length; span++) {
                array [rows][span] = ++i;     // заполняем матрицу

            }
        }
        for(int r =0; r<array.length; r++){
            for(int y=0; y<array.length; y++){
                System.out.print(array[r][y]);  //выводим
            }
            System.out.println("");
        }
    }
}
