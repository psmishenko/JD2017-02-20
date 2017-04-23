package by.it.radivonik.jd02_10.converter;

import java.io.*;

/**
 * Created by Radivonik on 23.04.2017.
 */
public abstract class AbstractConverter<T> {
    private Class<T> classBean;
    private T bean;

    AbstractConverter(Class<T> classBean) {
        this.classBean = classBean;
        this.bean = null;
    }

    public Class<T> getClassBean() {
        return classBean;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    abstract public void buildConverter(String text);

    public void buildConverter(File file) {
        StringBuilder text = new StringBuilder("");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = fileReader.readLine()) != null)
                text.append(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        buildConverter(text.toString());
    }

    abstract public String convertToString();

    public void convertToFile(File file) {
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file))) {
            fileWriter.write(convertToString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
