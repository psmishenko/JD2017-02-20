package by.it.smirnov.jd01_09.Parser;

/**
 * Created by aleksey.smirnov on 15.03.2017.
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
