package by.it.loktev.Calculator;

public class Oper1Pref extends ExpressionPart {

    static public String oper1PrefRE=" *[-+] *";

    public String operation;

    public Oper1Pref(String operation) {
        this.operation=operation;
    }

    @Override
    PartType getPartType() {
        return PartType.partOper1Pref;
    }

    @Override
    boolean isSubExprStart() {
        return true;
    }

    @Override
    boolean isSubExprEnd() {
        return false;
    }

    @Override
    public String toString() {
        return operation;
    }

}
