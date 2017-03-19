package by.it.ikavalenka.jd_09.Math_Lab;

/**
 * Created by USER on 15.03.2017.
 */
public interface Patterns {


        //возможные примеры регулярных выражений (конечно лучше составить свои).
        String exVal="((-?)([0-9.])+)";                       //числа
        String exVec="\\{((-?([0-9.])+),?)+}";                //вектора  \{((-?([0-9.])+),?)+}
        String exMat="\\{((\\{((-?([0-9.])+),?)+}),?)+}";     //матрицы
        String exAny="("+exMat+")|("+exVec+")|("+exVal+")";   //одно из...
        String exOper="[-+*/=]";                               //операция
        String exFull= "("+exAny+")"+
                "(" +exOper+")"+
                "(" +exAny +")"; //выражение целиком
    }


