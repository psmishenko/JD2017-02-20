package by.it.Zyryanov.my_MatLab;



public interface Expressions {

    String VALUE = "((-?)([0-9]+\\.?[0-9]*))";   // VECTOR, VECTOR
    String OPERATION = "(?<=[^{,=+*/-])[=+*/-]"; //посмотреть как работает
    String VECTOR = "(\\{("+ VALUE + ",?){2,}})";
    String MATRIX = "\\{(" + VECTOR + ",?)+}";


}