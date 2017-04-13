package by.it.korzun.matlab;

public class VarCreator {
    private static VarCreator instance;

    public VarCreator(){
    }

    VarCreator getInstance(){
        if(instance == null){
            instance = new VarCreator();
        }
        return instance;
    }

    Var createVar(String str){
        Var v;
        if (str.matches(Patterns.exVal)) {
            v = new VarF(str);
        } else if (str.matches(Patterns.exVec)) {
            v = new VarV(str);
        } else if (str.matches(Patterns.exMat)) {
            v = new VarM(str);
        } else {
            v = Var.getVars().get(str);
        }
        return v;
    }


}
