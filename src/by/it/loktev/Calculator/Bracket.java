package by.it.loktev.Calculator;

public class Bracket extends ExpressionPart {

    static public String bracketRE=" *([()]) *";

    public String bracket;

    public Bracket(String bracket) {
        this.bracket=bracket;
    }

    @Override
    PartType getPartType() {
        return PartType.partBracket;
    }

    @Override
    boolean isSubExprStart() {
        return bracket.equals("(");
    }

    @Override
    boolean isSubExprEnd() {
        return bracket.equals(")");
    }

    @Override
    public String toString() {
        return bracket;
    }

}
