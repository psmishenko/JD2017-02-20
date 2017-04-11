package by.it.smirnov.jd02_04_matlab.Vars;

import by.it.smirnov.jd02_04_matlab.Error.MatLabException;

/**
 * Интерфейс математических операций
 */
public interface IOperation {
    /**
     * Сложение
     * @param var второй операнд
     * @return Var результат
     */
    Var add(Var var) throws MatLabException;
    /**
     * Вычитание
     * @param var второй операнд
     * @return Var результат
     */
    Var sub(Var var) throws MatLabException;
    /**
     * Умножение
     * @param var второй операнд
     * @return Var результат
     */
    Var mul(Var var) throws MatLabException;
    /**
     * Деление
     * @param var второй операнд
     * @return Var результат
     */
    Var div(Var var) throws MatLabException;
}
