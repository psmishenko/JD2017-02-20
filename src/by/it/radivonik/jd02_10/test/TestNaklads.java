package by.it.radivonik.jd02_10.test;

import by.it.radivonik.jd02_10.beans.*;
import sun.util.calendar.CalendarDate;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class TestNaklads {
    public static Naklads getTest() {
        Naklads naklads = null;
        Naklad naklad;
        Klient klient;
        Avto avto;
        Tovars tovars;
        Tovar tovar;

        naklads = new Naklads();

        // 1-я накладная
        naklad = new Naklad();
        klient = new Klient();
        avto = new Avto();
        naklad.setType(NakladType.TTN_OUT);
        naklad.setDate(new GregorianCalendar(2017,2,1));
        naklad.setNum("1");
        naklad.setSeria("AA");
        klient.setName("Клиент1");
        klient.setUnp("100123456");
        klient.setAdres("г.Минск");
        naklad.setKlient(klient);
        avto.setNumGos("1234 AA-7");
        avto.setVoditel("Иванов А.А.");
        naklad.setAvto(avto);

        tovars = new Tovars();
        tovar = new Tovar();
        tovar.setName("Молоко");
        tovar.setEdIzm("пак.");
        tovar.setCount(BigDecimal.valueOf(50));
        tovar.setCena(BigDecimal.valueOf(0.85));
        tovar.setStoim(BigDecimal.valueOf(40));
        tovar.setPrNds(BigDecimal.valueOf(20));
        tovar.setNds(BigDecimal.valueOf(8));
        tovar.setStoimPoln(BigDecimal.valueOf(48));
        tovars.getTovar().add(tovar);
        tovar = new Tovar();
        tovar.setName("Хлеб Майский");
        tovar.setEdIzm("бух.");
        tovar.setCount(BigDecimal.valueOf(100));
        tovar.setCena(BigDecimal.valueOf(0.25));
        tovar.setStoim(BigDecimal.valueOf(25));
        tovar.setPrNds(BigDecimal.valueOf(20));
        tovar.setNds(BigDecimal.valueOf(5));
        tovar.setStoimPoln(BigDecimal.valueOf(30));
        tovars.getTovar().add(tovar);
        naklad.setTovars(tovars);

        naklads.getNaklad().add(naklad);

        // 2-я накладная
        naklad = new Naklad();
        klient = new Klient();
        avto = new Avto();
        naklad.setType(NakladType.TTN_OUT);
        naklad.setDate(new GregorianCalendar(2017,3,1));
//            naklad.setDate(dateFormat.parse("2017-03-01"));
        naklad.setNum("2");
        naklad.setSeria("BB");
        klient.setName("Клиент2");
        klient.setUnp("100654321");
        klient.setAdres("г.Брест");
        naklad.setKlient(klient);
        avto.setNumGos("4321 BB-7");
        avto.setVoditel("Петров А.А.");
        naklad.setAvto(avto);

        tovars = new Tovars();
        tovar = new Tovar();
        tovar.setName("Сахар");
        tovar.setEdIzm("пак.");
        tovar.setCount(BigDecimal.valueOf(100));
        tovar.setCena(BigDecimal.valueOf(1.6));
        tovar.setStoim(BigDecimal.valueOf(160));
        tovar.setPrNds(BigDecimal.valueOf(20));
        tovar.setNds(BigDecimal.valueOf(32));
        tovar.setStoimPoln(BigDecimal.valueOf(192));
        tovars.getTovar().add(tovar);
        tovar = new Tovar();
        tovar.setName("Соль");
        tovar.setEdIzm("пак.");
        tovar.setCount(BigDecimal.valueOf(100));
        tovar.setCena(BigDecimal.valueOf(0.92));
        tovar.setStoim(BigDecimal.valueOf(92));
        tovar.setPrNds(BigDecimal.valueOf(20));
        tovar.setNds(BigDecimal.valueOf(18.4));
        tovar.setStoimPoln(BigDecimal.valueOf(110.4));
        tovars.getTovar().add(tovar);
        naklad.setTovars(tovars);

        naklads.getNaklad().add(naklad);

        return naklads;
    }
}
