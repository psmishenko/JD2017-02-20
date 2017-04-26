package by.it.Zyryanov.jd01_15_matlab_demo;

public interface Patterns {
    //возможные примеры регулярных выражений (конечно лучше составить свои).
    String exVal="((-?)([0-9])+(\\.[0-9]+)?)";                       //наша регулярка
    String exVec="\\{((-?([0-9.])+),?)+}";                //вектора
    String exMat="\\{((\\{((-?([0-9.])+),?)+}),?)+}";     //матрицы
    String exAny="("+exMat+")|("+exVec+")|("+exVal+")";   //одно из...
    String exOper="[-+*/=]";                               //операция
    String exFull= "("+exAny+")"+
                   "(" +exOper+")"+
                   "(" +exAny +")"; //выражение целиком

}
