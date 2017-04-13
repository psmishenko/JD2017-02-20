package by.it.prigozhanov.my_matlab;

/**
 * Created by v-omf on 4/13/2017!
 */
public interface Expressions {

    String VALUE = "(-?)([0-9]+)(\\.?[0-9]+)?";
    String VECTOR = "(\\{(" + VALUE + ",?){2,}})";
    String MATRIX = "\\{(" + VECTOR + ",?){2,}}";
    String ANY = "("+VALUE+")|("+MATRIX+")|("+VECTOR+")";
    String OPERATION = "[-+/*=]";
    String EXPRESSION = "("+ANY+")"+"("+OPERATION+")"+"("+ANY+")";

}
