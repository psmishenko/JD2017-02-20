package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 15.03.2017.
 */
public interface IPatterns {
    String ExNumber = "\\-?\\d+\\.?\\d*";                        // Числа
    String ExVector = "\\{((" + ExNumber + "){1},?)+\\}";        // Вектора
    String ExMatrix = "\\{((" + ExVector + "){1},?)+\\}";        // Матрицы
}
