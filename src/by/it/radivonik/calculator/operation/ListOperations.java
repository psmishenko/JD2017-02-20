package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.variable.Var;
import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;
import by.it.radivonik.calculator.variable.VarCreator;

import java.text.StringCharacterIterator;
import java.util.*;

/**
 * Created by Radivonik on 08.04.2017.
 */
public class ListOperations {
    private static Map<String, IOperation> opList = new HashMap<>();

    static {
        add(new Operation("+", "((?<=[^{,+\\-*/])[+])", 2, OperationMath.getOperation()));
        add(new Operation("-", "((?<=[^{,+\\-*/])[\\-])", 2, OperationMath.getOperation()));
        add(new Operation("*", "((?<=[^{,+\\-*/])[*])", 4, OperationMath.getOperation()));
        add(new Operation("/", "((?<=[^{,+\\-*/])[/])", 4, OperationMath.getOperation()));
        add(new Operation("=", "((?<=[\\w]+)=)", 1, OperationStore.getOperation()));
        add(new Operation("printvar", "printvar", 0, OperationStore.getOperation()));
        add(new Operation("sortvar", "sortvar", 0, OperationStore.getOperation()));
    }

    private static void add(IOperation op) {
        opList.put(op.getOperator(), op);
    }

    public static IOperation getOperation(String operator) {
        return opList.get(operator);
    }

    public static int getPriority(String operator) {
        int res = 0;
        IOperation op = getOperation(operator);
        if (op != null)
            res = op.getPriority();
        return res;
    }

    public static String getPattern() {
        String delim = "";
        StringBuilder pattern = new StringBuilder("");
        for (IOperation op : opList.values()) {
            pattern.append(delim).append(op.getPattern());
            delim = "|";
        }
        return pattern.toString();
    }

    public static String getPatternBrackets() {
        return "\\([^()]*\\)";
    }
}

