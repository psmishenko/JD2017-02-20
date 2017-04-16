package by.it.smirnov.jd02_06_matlab.BuilderReport;

/**
 * Класс отчета
 */
public class Report {
    private String header="";
    private String body="";
    private String footer="";

    public void setHeader(String header) {
        this.header = header;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    /**
     * Представление отчета для вывода
     */
    @Override
    public String toString() {
        return header + body + footer;
    }
}
