package by.it.zeynalov.jd01_09_matlab_homework;

public interface Patterns {
    String exVal="((-?)([0-9.])+)";
    String exVec="\\{((-?([0-9.])+),?)+}";
    String exMat="\\{((\\{((-?([0-9.])+),?)+}),?)+}";
    String exAny="("+exMat+")|("+exVec+")|("+exVal+")";
    String exOper="[-+*/=]";
    String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")";
}
