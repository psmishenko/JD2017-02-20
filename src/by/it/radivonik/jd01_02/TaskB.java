package by.it.radivonik.jd01_02;

/**
 * Created by Radivonik on 28.02.2017.
 */
public class TaskB {
    static String getMonthName(int nMonth) {
        String[] aMonth = {
                "январь", "февраль", "март", "апрель", "май", "июнь",
                "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"
        };

        if (nMonth < 1 || nMonth > 12)
            return "Нет такого месяца";
        else
            return aMonth[nMonth-1];
    }
}
