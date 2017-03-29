package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 13.03.2017.
 */
public interface IVariable {
    void fromString(String str) throws ParseException;
    String toString();
    void loadFromFile() throws ParseException ;
    void saveToFile() throws ParseException ;
}
