package by.it.ikavalenka.jd02_04.Matlab;

import java.io.File;

public abstract class ReportBuilder implements Runnable {

    File file;

     public File getFile() {
        return file;
    }

    public abstract void startReport();
    public abstract void setStartTime();
    public abstract void addOperation();
    public abstract void setEndTime();


}
