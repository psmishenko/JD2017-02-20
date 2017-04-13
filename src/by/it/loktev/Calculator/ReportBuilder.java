package by.it.loktev.Calculator;

public class ReportBuilder {

    StringBuffer sb;

    void start(){
        sb=new StringBuffer();
    }

    void buildHeaderLine(String s){
        sb.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
        sb.append(s+"\n");
        sb.append("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
    }

    void buildFooterLine(String s){
        sb.append("------------------------------------------------------------------------\n");
        sb.append(s+"\n");
        sb.append("------------------------------------------------------------------------\n");
    }

    void buildTextLine(String s){
        sb.append(s+"\n");
    }

    String getResult() {
      return sb.toString();
    }

}
