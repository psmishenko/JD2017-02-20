package by.it.smirnov.jd02_10.task_a;

import by.it.smirnov.jd02_10.task_a.pojo_class.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

/**
 *  Класс Варианта A
 */
public class TaskA {
    private final static String path = System.getProperty("user.dir") + "/src/by/it/smirnov/jd02_10/task_a/";
    private final static String fileNameJSON = path + "BankLimits.json";

    public static void pojoInJSON() {

        Banks banks = new Banks();

        Address addr = new Address("Беларусь", "Минск", "М.Богдановича", "15-Б", "220039");
        Bank bank = new Bank("ОАО Приорбанк", 333, "159475333", addr, "Первая группа");
        banks.getBank().add(bank);

        addr = new Address("Беларусь", "Минск", "бул.Мулявина", "6", "");
        bank = new Bank("ОАО БПС-Сбербанк", 369, "159000369", addr, "Вторая группа");
        banks.getBank().add(bank);

        addr = new Address("Германия", "Берлин", "Штирлиц штрассе", "666", "");
        bank = new Bank("Deutsche Bank", 50777, "", addr, "Первая группа");
        banks.getBank().add(bank);

        BankLimits bl = new BankLimits();
        bl.getBanks().add(banks);

        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileNameJSON))){
            bw.write(gson.toJson(bl));
        } catch (IOException e) {
            System.err.println("JSON-файл не может быть создан: " + e);
        }
        System.out.println("JSON-файл создан!");
    }

    public static void jsonInPOJO() {

        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileNameJSON))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения JSON-файла: " + e);
        }

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        BankLimits bl = gson.fromJson(sb.toString(), BankLimits.class);
        System.out.println(bl);
    }

}
