package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 15.03.2017.
 */
public interface IPatterns {
    String RegexBr = "\\(([1234567890\\.\\+\\-\\*\\/^%]*)\\)";    // Скобки
    String ExNumber = "\\-?\\d+\\.?\\d*";                         // Числа
    String ExVector = "\\{((" + ExNumber + "){1},?)+\\}";         // Вектора
    String ExName = "[a-zA-z\\d]+";                                  // Переменные
    String ExOper = "[\\+\\-\\*\\/\\=]";                          // Операции
    String ExExp = "(" + ExVector + ")|(" + ExNumber + ")|(" + ExName + ")|(" + ExOper + ")"; // Выражение

    // возможные примеры регулярных выражений (конечно лучше составить свои).
//    String ExExp = "(" + ExVar + ")" + "(" + ExOper + ")" + "(" + ExVar +")"; // Выражение
//    String RegexMulOp = "[\\*\\/^%]";                             // Первоприоритетные числа
//    String RegexAddOp = "[\\+\\-]";
    String exMatrix = "\\{((\\{((-?([0-9.])+),?)+}),?)+}";        // матрицы
//    String exAny = "(" + ExNumber + ")|(" + ExVector + ")|(" + exMatrix + ")";   // одно из...
}
