package by.it.radivonik.jd02_10;

import com.google.gson.*;
import javax.xml.bind.*;
import java.io.*;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class TaskB {
    public <T> void run(Class<T> classBean, String filexml) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").serializeNulls().setPrettyPrinting().create();
        StringBuilder xml = new StringBuilder("");
        String line;

        System.out.println("Исходный XML:");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filexml))) {
            while ((line = fileReader.readLine()) != null)
                System.out.println(line);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(classBean);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T beans = (T) unmarshaller.unmarshal(new FileReader(filexml));

            String json = gson.toJson(beans);
            System.out.println("Промежуточный JSON:\n" + json);

            // Обратное преобразование
            beans = gson.fromJson(json, classBean);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            System.out.println("Преобразованный XML:");
            marshaller.marshal(beans, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

