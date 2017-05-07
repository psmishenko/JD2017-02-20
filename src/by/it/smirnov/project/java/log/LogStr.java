package by.it.smirnov.project.java.log;

/**
 * Структура лога
 */
public class LogStr {
    private long dateTime;
    private String messageType;
    private String message;

    public LogStr(long dateTime, String messageType, String message) {
        this.dateTime = dateTime;
        this.messageType = messageType;
        this.message = message;
    }

    public long getDateTime() {
        return dateTime;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getMessage() {
        return message;
    }
}
