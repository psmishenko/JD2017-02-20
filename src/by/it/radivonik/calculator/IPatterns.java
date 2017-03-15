package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 15.03.2017.
 */
public interface IPatterns {
    //возможные примеры регулярных выражений (конечно лучше составить свои).
    String exVal = "((-?)([0-9.])+)";                       // числа
    String exVec = "\\{((-?([0-9.])+),?)+}";                // вектора
    String exMat = "\\{((\\{((-?([0-9.])+),?)+}),?)+}";     // матрицы
    String exAny = "(" + exMat + ")|(" + exVec + ")|(" + exVal + ")";   // одно из...
    String exOper = "[-+*/]";                               // операция
    String exFull = "(" + exAny + ")" + "(" + exOper + ")" + "(" + exAny +")"; // выражение целиком
}
