package by.it.psmishenko.jd01_5;


public class Task1 {
static double optionA (double x){
    System.out.println("#1-------------------");
    double elem1 = Math.pow((Math.sin(Math.PI/6)-1),2);
    double elem2 = Math.pow(3+Math.pow(x,2),0.25);
    double elem3 = Math.pow(Math.log10(Math.pow(x,3)-1),3);
    double elem4 = Math.asin(x/2)-1.756*Math.pow(10,-2);
    double y = (elem1+elem2-elem3)/elem4;
    return y;
}
static double optionB (double x){
    double y = (Math.pow((Math.sin(Math.PI/6)-1),2)+Math.pow(3+Math.pow(x,2),0.25)-Math.pow(Math.log10(Math.pow(x,3)-1),3))/(Math.asin(x/2)-1.756*Math.pow(10,-2));
    return y;
}
}
