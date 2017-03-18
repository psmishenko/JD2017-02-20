package by.it.ikavalenka.jd_11.Math_Lab;

/**
 * Created by USER on 13.03.2017.
 */
public class ConsoleRunner {
    private static void oneRes(Var var){
    if (var != null) {
        System.out.println(var);
    }
}
    public static void main(String[] args) {

        Var vec1 = new VarV("{1.1,2.1,3.1,4.1,5.1}");
        Var vec2 = new VarV("{1.1,2.1,3.1,4.1,5.1}");

//        oneRes(Parser.cals("1+-2"));        //изменить  регулярку
//        oneRes(Parser.cals("{1,2,3,4,5}+4"));
//        oneRes(Parser.cals("{1,2,3,4,5}*4"));
//        oneRes(Parser.cals("{1,2,3,4,5}/4"));
//        oneRes(Parser.cals("{1,2,3,4,5}-4"));
//        oneRes(Parser.cals("A=3"));
//
//        oneRes(Parser.cals("A=3"));
//        oneRes(Parser.cals("B={1,2,3,4}"));
//        oneRes(Parser.cals("C=5"));
//        oneRes(Parser.cals("A=7"));
//        System.out.println(Var.vars);

        System.out.println(vec1);
        Var vec3 = vec1.add(vec2);
        oneRes(vec1.add(vec2));
        oneRes(vec1.sub(vec2));
        oneRes(vec1.mul(vec2));
        oneRes(vec1.div(vec2));
        //System.out.println(vec3);
        //3.8+26.2 87.4-23.1 1.04*5.9 12.7*5 -6+12 -7*3.1 -4/8 -9-0.9
        //Var res = new VarF("3.8").add(new VarF("26.2"));
        //Var res = new VarF("3.8").add(new VarV("26.2"));
        //oneRes(res);
       // oneRes(new VarF("3.8").add(new VarF("26.2")));
       // oneRes(new VarF("87.4").sub(new VarF("23.1")));
       // oneRes(new VarF("1.04").mul(new VarF("5.9")));
       // oneRes(new VarF("12.7").div(new VarF("5")));
        //oneRes(new VarF("3.8").add(new VarV()));

    }
}
