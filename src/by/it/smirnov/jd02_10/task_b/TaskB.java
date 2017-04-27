package by.it.smirnov.jd02_10.task_b;

import by.it.smirnov.jd02_10.task_b.pojo_class.BankLimits;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Класс Варианта B
 */
public class TaskB {
    private final static String path = System.getProperty("user.dir") + "/src/by/it/smirnov/jd02_10/task_b/";
    private final static String fileNameXML = path + "BankLimits.xml";
    private final static String fileNameJSON = path + "BankLimits.json";
    private final static String fileNameNewXML = path + "BankLimitsNew.xml";

    private static String readFromFile(String fileName) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e);
        }
        return sb.toString();
    }

    private static void writeToFile(String fileName, String txtData) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
            bw.write(txtData);
        } catch (IOException e) {
            System.err.println("Файл не может быть создан: " + e);
        }
    }

    public static void xmlToJSON() {
        String xmlData = readFromFile(fileNameXML);
        BankLimits bl=null;
        try {
            JAXBContext jc = JAXBContext.newInstance(BankLimits.class);
            bl = (BankLimits) jc.createUnmarshaller().unmarshal(new StringReader(xmlData));
        } catch (JAXBException e) {
            System.err.println("Ошибка преобразования XML -> JSON: " + e);
        }
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        writeToFile(fileNameJSON, gson.toJson(bl));
        System.out.println("JSON-файл создан!");
    }

    public static void jsonToXML() {
        String jsonData = readFromFile(fileNameJSON);
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        BankLimits bl = gson.fromJson(jsonData, BankLimits.class);

        try {
            JAXBContext jc = JAXBContext.newInstance(BankLimits.class);
            Marshaller m = jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://task_b.jd02_10.smirnov.it.by/");
            m.marshal(bl, new FileOutputStream(fileNameNewXML));
        } catch (JAXBException|FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Новый XML-файл создан!");
    }


}
