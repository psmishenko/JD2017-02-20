package by.it.Zyryanov.my_MatLab;


public class VarFactory {


    private static VarFactory instance;

    private VarFactory() {

    }

    static VarFactory getInstance(){
        if (instance == null){
            instance = new VarFactory();
        }
        return instance;
    }


    Var createVar(String part){
        Var res;
        if (part.matches(Expressions.MATRIX)) {
            res = new VarMatrix(part);
        } else if (part.matches(Expressions.VECTOR)) {
            res = new VarVector(part);
        } else if (part.matches(Expressions.VALUE)) {
            res = new VarValue(part);
        } else
            res = Var.varMap.get(part);
        return res;
    }
}
