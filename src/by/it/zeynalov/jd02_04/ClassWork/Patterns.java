package by.it.zeynalov.jd02_04.ClassWork;

public interface Patterns {
    String exVal="((-?)([0-9.])+)";                       //числа
    String exVec="\\{((-?([0-9.])+),?)+}";                //вектора
    String exMat="\\{((\\{((-?([0-9.])+),?)+}),?)+}";     //матрицы
    String exAny="("+exMat+")|("+exVec+")|("+exVal+")";   //одно из...
    String exOper="(?<=[^{,=+*/-])[=+*/-]";               //операция
    String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")"; //выражение целиком
}
