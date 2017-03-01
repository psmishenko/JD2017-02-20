package by.it.psmishenko.jd01_2;


public class TaskB {

   static boolean checkNumber (int[] arr) {
        if (arr[1]<=arr[0] && arr[2]>=arr[0]) return true;
        else return false;
   }
    static void printNewMatrix (int param) {
        double coef =  Math.sqrt(param);
        int matrix[][] = new int [(int) coef][ (int) coef];
        int z = 0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix.length ; j++) {
                matrix[i][j]= 1+z;
                System.out.print(matrix[i][j]+" ");
                z++;
            }
            System.out.print("\n");
        }
    }

    static void determQuadr (int[] index) {
       int a = index[0];
       int b = index[1];
       int c = index[2];
       double d = Math.pow(b,2)- 4*a*c;
       if(d>=0){
           System.out.println("Первый корень уравнения - "+( ((-b)+ Math.sqrt(d))/(2*a)));
           System.out.println("Второй корень уравнения - "+( ((-b) - Math.sqrt(d))/(2*a)));
       }
       if(d<0) {System.out.println("Квадратное уравнение не имеет корней");}
    }

    static void printMonth (int number){
       String month;
       switch (number){
           case 1: month = "Январь";
           break;
           case 2: month = "Февраль";
               break;
           case 3: month = "Март";
               break;
           case 4: month = "Апрель";
               break;
           case 5: month = "Май";
               break;
           case 6: month = "Июнь";
               break;
           case 7: month = "Июль";
               break;
           case 8: month = "Август";
               break;
           case 9: month = "Сентябрь";
               break;
           case 10: month = "Октябрь";
               break;
           case 11: month = "Ноябрь";
               break;
           case 12: month = "Декабрь";
               break;
               default: month = "Квактябрь. Ты думал, что я не замечу?";
               break;
       }
       System.out.println("Текущий месяц - "+month);
    }

}
