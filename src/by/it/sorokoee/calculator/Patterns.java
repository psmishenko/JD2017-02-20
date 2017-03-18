package by.it.sorokoee.calculator;

/**
 * Created by DELL_PC on 17.03.2017.
 */
public interface Patterns {

    String exVal="((-?)([0-9.])+)";
    String exVec="\\{((-?([0-9.])+),?)+}";
    String exMat="\\{((\\{((-?([0-9.])+),?)+}),?)+}";
    String exAny="("+exMat+")|("+exVec+")|("+exVal+")";
    String exOper="[-+*/]";
    String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")";

}