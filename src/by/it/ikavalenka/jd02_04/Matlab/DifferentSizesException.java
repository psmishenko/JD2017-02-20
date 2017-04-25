package by.it.ikavalenka.jd02_04.Matlab;


public class DifferentSizesException extends Exception {

    String message;

    public DifferentSizesException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
