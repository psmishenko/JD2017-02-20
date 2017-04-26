package by.it.Zyryanov.my_MatLab;


public class VarMatrix extends Var{


    public Double[][] matrix;

    public VarMatrix(String s) {

    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void fromString(String var) {
//        Pattern p = Pattern.compile(Expressions.MATRIX);
//        if (p.matcher(var).matches()){
//            p = Pattern.compile(Expressions.VALUE);
//            Matcher m = p.matcher(var);
//            int size = 0;
//            while (m.find()) size++;
//            matrix = new Double[size][size];
//            m.reset();
//            int i = 0;
//            while (m.find()){
//                String oneValue = m.group();
//                matrix[i][i]
//            }
//        }
    }

    @Override
    public Var add(Var var) {
        return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        return super.mul(var);
    }

    @Override
    public Var div(Var var) {
        return super.div(var);
    }
}
