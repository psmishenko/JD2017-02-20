package by.it.smirnov.jd01_15_matlab.Parser;

/**
 * Модуль с регулярными выражениями
 */
public interface Patterns {
    String exVal="(-?\\d+\\.?\\d*)";                        //числа
    String exVec="\\{("+exVal+",?)+}";                      //вектора
    String exMat="\\{("+exVec+",?)+}";                      //матрицы
    String exAny="("+exMat+")|("+exVec+")|("+exVal+")";     //одно из...
    String exOper="[-+*/]";                                 //операция
    String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")"; //выражение целиком
    String exAssign="\\w+\\=(("+exFull+")|("+exAny+"))";                   //присвоение
    String exPrintVar="^(printvar)";                   //печать списка
    String exSortVar="^(sortvar)";                   //печать отсортированного списка
}
