package by.it.Zyryanov.jd01_02;




public class TaskA {




       //Задача номер 1

    public static void maxValueAndMin(int[] intMas) {
        int MaxValue = 0;
        for (int i = 0; i < intMas.length; i++) {
            if (MaxValue < intMas[i]) {
                MaxValue = intMas[i];
            }
        }
        System.out.println(MaxValue);
    }
//        //Задача номер 1


        //Задача номер 2

        public static void numberSmallerThenAvg(int[] intMas) {
            int sum = 0;
            int arithmetic_avg = intMas.length;
            for (int i = 0; i < intMas.length; i++) {
                sum = sum + intMas[i];
            }
            System.out.println(sum);
            System.out.println("Среднее арифметическое: " + sum / arithmetic_avg);
        }
        //Задача номер 2




        //Задача номер 3

        static boolean uniqueDigits(Integer value) {

             char ch[] = value.toString().toCharArray();
        for (int i = 0; i < ch.length; i++)
            for (int j = i + 1; j < ch.length; j++)
            if (ch[i] == ch[j]){
                System.out.println("Нет одинаковых цифр в числе");
                return false;}
            System.out.println(value);
        return true;
    }
        //Задача номер 3





    }


