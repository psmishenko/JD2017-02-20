package by.it.ikavalenka.jd02_04.Matlab;


public class Counting {



    public static Var count (Var a, Var b, String line) throws ErrorException {

        if (line.contains("+")) {
            //System.out.print(a +a.getType()+ " + " + b+b.getType() + " ");
            //UtilsMatlab.print(a.add(b));
            return a.add(b);
        }
        else {
            if (line.contains("-")) {
                //System.out.print(a + " - " + b + " ");
                //UtilsMatlab.print(a.sub(b));
                return a.sub(b);

            }
            else {
                if (line.contains("*")) {
                    //System.out.print(a + " * " + b + " ");
                    //UtilsMatlab.print(a.multi(b));
                    return a.multi(b);

                }
                else {
                    if (line.contains("/")) {
                        //System.out.print(a + " / " + b + " ");
                        // UtilsMatlab.print(a.divide(b));
                        return a.divide(b);

                    }
                    else return null;
                }
            }
        }

    }
}
