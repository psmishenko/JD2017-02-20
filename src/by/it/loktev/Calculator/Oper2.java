package by.it.loktev.Calculator;

public class Oper2 extends ExpressionPart {

    static public String oper2RE=" *[-+*/] *";

    public String operation;

    public Oper2(String operation) {
        this.operation=operation;
    }

    @Override
    PartType getPartType() {
        return PartType.partOper2;
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
