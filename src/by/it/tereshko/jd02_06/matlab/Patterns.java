package by.it.tereshko.jd02_06.matlab;

public interface Patterns {

    //possible examples of regular expressions
    String exVal = "((-?)([0-9.])+)";                                   //numbers
    String exVec = "\\{((-?([0-9.])+),?)+}";                            //vectors
    String exMat = "\\{((\\{((-?([0-9.])+),?)+}),?)+}";                 //matrices
    String exAny = "(" + exMat + ")|(" + exVec + ")|(" + exVal + ")";   //one of...
    //String exOper = "(-?([0-9]+)(\\.[0-9]+)*)";                         //operations
    String exOper = "(?<=[^{,=+*/-])[=+*/-]";                           //operations
    String exFull = "(" + exAny + ")" + "(" + exOper + ")" + "(" + exAny + ")";//complete expression

}