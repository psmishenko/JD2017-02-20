package by.it.smirnov.jd01_13.VariantC;

/**
 * Базовый интерфейс взлетно-посадочной полосы
 */
public interface IRunWay {
    /**
     * Возвращает длину взлетно-посадочной полосы
     */
    public double getRunwayLength();
    /**
     * Возвращает ширину взлетно-посадочной полосы
     */
    public double getRunwayWidth();

    /**
     * Включает освещение взлетно-посадочной полосы
     */
    public void runwayLightingOn();
    /**
     * Выключает освещение взлетно-посадочной полосы
     */
    public void runwayLightingOff();
    /**
     * Отчет о состоянии освещения взлетно-посадочной полосы
     */
    public String getRunwayLighting();
}
