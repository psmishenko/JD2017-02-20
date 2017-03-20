package by.it.loktev.Calculator;

// часть выражения -
// значение (класс Var),
// унарная префиксная операция (класс Oper1Pref),
// бинарная операция (класс Oper2),
// функция (класс Function),
// скобка (класс Bracket)
abstract public class ExpressionPart {

    public enum PartType {
        partVar, partOper1Pref, partOper2, partFunction, partBracket
    }

    abstract PartType getPartType();

    /*
    // начало субвыражения - первым, после бинарной операции,
    // после префиксной унарной операции,
    // после любой левой скобки

    // конец субвыражения - после константы,
    // после любой правой скобки
     */

    abstract boolean isSubExprStart(); // должно ли идти после данной части подвыражение - например / или ( или унарный -
    abstract boolean isSubExprEnd(); // закончилось ли после данной части подвыражение - например ) или литерал числа

}
