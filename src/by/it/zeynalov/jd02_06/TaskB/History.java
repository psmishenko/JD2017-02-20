package by.it.zeynalov.jd02_06.TaskB;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class History {
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    private ArrayList<String> al = new ArrayList<>();

    public ArrayList<String> getOperations() {
        return al;
    }

    private static History ourInstance = new History();

    public static History getInstance() {
        return ourInstance;
    }

    private History() {
    }

    public void addMesage(String mesage) {
        al.add(mesage);
    }
}
