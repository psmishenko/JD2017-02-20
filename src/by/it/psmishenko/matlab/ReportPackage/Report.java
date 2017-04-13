package by.it.psmishenko.matlab.ReportPackage;

/**
 * Created by GN on 13.04.2017.
 */
public class Report {
    private String header;
    private String runtime;
    private String results;
    private String footer;

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setResults(String results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return header+"\n"+runtime+"\n"+results+"\n"+footer+"\n";
    }
}
