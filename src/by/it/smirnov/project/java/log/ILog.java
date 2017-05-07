package by.it.smirnov.project.java.log;

/**
 * Интерфейс механизма логирования
 */
public interface ILog {
    /**
     * Сохранение ошибки
     * @param message сообщение
     */
    void error(String message);
    /**
     * Сохранение предупреждение
     * @param message сообщение
     */
    void warn(String message);
    /**
     * Сохранение информации
     * @param message сообщение
     */
    void info(String message);
    /**
     * Сохранение информации для DEBUG
     * @param message сообщение
     */
    void debug(String message);
}
