package by.it.smirnov.jd01_08;

/**
 * Базовый интерфейс взлетно-посадочной полосы
 */
public interface IRunWay {
    public double getRunwayLength();  // длина взлетно-посадочной полосы
    public double getRunwayWidth();  // ширина взлетно-посадочной полосы

    public void runwayLightingOn(); // включить освещение взлетно-посадочной полосы
    public void runwayLightingOff(); // выключить освещение взлетно-посадочной полосы
    public String getRunwayLighting();  // отчет о состоянии освещения взлетно-посадочной полосы
}
