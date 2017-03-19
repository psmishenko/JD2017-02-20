package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 15.03.2017.
 */
public interface IPatterns {
    String RegexBr = "\\(([1234567890\\.\\+\\-\\*\\/^%]*)\\)";    // Скобки
    String ExNumber = "\\-?\\d+\\.?\\d*";                         // Числа
    String ExVector = "\\{((" + ExNumber + "){1},?)+\\}";         // Вектора
    String ExVar = "(" + ExNumber + ")|(" + ExVector + ")";       // Числа или вектора или матрицы
    String ExOper = "[\\+\\-\\*\\/\\=]";                                    // Операции
    String ExExp = "(" + ExVar + ")|(" + ExOper + ")"; // Выражение
    //String ExExp = "(" + ExVar + ")" + "(" + ExOper + ")" + "(" + ExVar +")"; // Выражение

    String RegexMulOp = "[\\*\\/^%]";                             // Первоприоритетные числа
    String RegexAddOp = "[\\+\\-]";
    //возможные примеры регулярных выражений (конечно лучше составить свои).
//    String exNumber = "((-?)([0-9.])+)";                          // числа
//    String ExVector = "\\{((-?([0-9.])+),?)+}";                   // вектора
    String exMatrix = "\\{((\\{((-?([0-9.])+),?)+}),?)+}";        // матрицы
    String exAny = "(" + ExNumber + ")|(" + ExVector + ")|(" + exMatrix + ")";   // одно из...
//    String exOper = "[-+*/=]";                                    // операция
}
