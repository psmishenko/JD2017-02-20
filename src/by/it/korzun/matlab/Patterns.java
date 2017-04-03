package by.it.korzun.matlab;

public interface Patterns {
    //возможные примеры регулярных выражений (конечно лучше составить свои).
    String exVal="((-?)([0-9.])+)";                                     //числа
    String exVec="[{\\[]((-?([0-9.])+),?\\s?)+[}\\]]";                              //вектора
    String exMat="[\\{\\[](([\\{\\[]((-?([0-9.])+),?\\s?)+[}\\]]),?\\s?)+[}\\]]";                   //матрицы
    String exName = "([A-Za-zА-Яа-я]+)";                                //имена
    String exAny="("+exMat+")|("+exVec+")|("+exVal+")|("+exName+")";    //одно из...
    String exOper="[-+*/]";                                             //операция
    String exFull= "("+exAny+")"+"(" +exOper+")"+"(" +exAny +")";       //выражение целиком

}
