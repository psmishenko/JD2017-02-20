package by.it.loktev.Calculator;

public class CalculatorException extends Exception {

    public CalculatorException(String message) {
        super(message);
        Log.write("Исключение: "+message);
    }
}
