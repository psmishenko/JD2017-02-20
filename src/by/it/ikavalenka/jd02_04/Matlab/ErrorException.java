package by.it.ikavalenka.jd02_04.Matlab;


public class ErrorException extends Exception {

    String message;

    public ErrorException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
