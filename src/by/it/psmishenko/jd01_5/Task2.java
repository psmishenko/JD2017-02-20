package by.it.psmishenko.jd01_5;


public class Task2 {
    static double calcY (double a, double b){
        double y = Math.pow((1/Math.tan(Math.PI/4-1)),4)+Math.pow(a+1.5,1/3)-(b/Math.asin(Math.pow(Math.abs(a),2)));
        return y;
    }
}
