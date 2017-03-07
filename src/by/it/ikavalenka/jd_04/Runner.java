package by.it.ikavalenka.jd_04;

/**
 * Created by USER on 27.02.2017.
 */
public class Runner {
    public static void main(String[] args) {
        double[] [] a ={
                {2,5,4,1},
                {1,3,2,1},
                {2,10,9,7},
                {3,8,9,2}
        };
        double[] y={20,11,40,37};
        double[] x=Util.findRoots(a,y,true);
        InOut.arrayPrint(Util.findRoots(a,y,false),"x",1);
        //InOut.arrayPrint(m,"M",false);
        //InOut.arrayPrint(m,"M",true);
        //InOut.arrayPrint(y,"Y",3);

    }

}
