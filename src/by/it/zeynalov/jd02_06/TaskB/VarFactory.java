package by.it.zeynalov.jd02_06.TaskB;

public class VarFactory {
    public Var createVar(Object ot) {
        Var res = null;
        if (ot instanceof Float) {
            res = new VarF((Float)ot);
        }
        if (ot instanceof float[]) {
            res = new VarV(((float[]) ot));
        }
        if (ot instanceof String) {
            String str = (String) ot;
            if (str.matches(Patterns.exVec)) {
                res = new VarV(str);
            } else if (str.matches(Patterns.exVal)) {
                res = new VarF(str);
            }
        }
        if (res != null) {
            History.getInstance().addMesage("Созадна новая переменная типа " + res.getClass().getSimpleName());
            return res;
        }
        throw new RuntimeException("Невозможно создать объект");
    }


}
