package by.it.psmishenko.jd02_10.converter;

import java.io.*;

/**
 * Created by GN on 23.04.2017.
 */
public abstract class AbstractConverter<T> {
    T bean;
    private Class beanClass;

    public AbstractConverter(T bean) {
        this.bean = bean;
        this.beanClass = bean.getClass();
    }

    public AbstractConverter(Class beanClass) {
        this.beanClass = beanClass;
        bean = null;
    }

    public T getBean() {
        return bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }
    abstract public void convert(String str); // конвертир. из строки
    abstract public String getStringResults(); // получить результат конверт. в строку


     public void saveResultsToFile(File newFile){ // сохранить результат в файл (полученный из getStringResults)
         try (BufferedWriter bufferedWriter =
                      new BufferedWriter(
                              new FileWriter(newFile))) {
             bufferedWriter.write(getStringResults());
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

    public void convert(File file){ //  чтение файла и convert(String str)
        String fileData = "";
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileData = fileData.concat(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        convert(fileData);
    }

}
