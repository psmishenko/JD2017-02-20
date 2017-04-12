package by.it.psmishenko.matlab;

/**
 * Created by user on 12.04.2017.
 */
public class VarCreator {
   private static VarCreator instance;
    public VarCreator() {
    }
 static VarCreator getInstance(){
    if(instance==null){
        instance = new VarCreator();
    }
     return instance;
}
   public Var createVar(String part) throws MathException {
        Var res;
        if (part.matches(Patterns.exMat)) {
            res = new VarM(part);
        } else if (part.matches(Patterns.exVec)) {
            res = new VarV(part);
        } else if (part.matches(Patterns.exVal)) {
            res = new VarF(part);
        } else
            res = Var.vars.get(part);
        return res;
    }
}
