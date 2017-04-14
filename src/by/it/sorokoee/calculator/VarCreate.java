package by.it.sorokoee.calculator;

public class VarCreate {
    private static VarCreate instance;

    private VarCreate() {
    }

    static VarCreate getInstance(){
        if (instance==null){
            instance=new VarCreate();
        }
        return  instance;
    }
    static Var createVar(String part){
        Var res;
        if (part.matches(Patterns.exMat)){
            res=new VarM(part);
        }
        else if (part.matches(Patterns.exVec)){
            res=new VarV(part);
        }
        else if (part.matches(Patterns.exVal)){
            res=new VarF(part);
        }
        else
            res = Var.vars.get(part);
        return res;
    }
}
