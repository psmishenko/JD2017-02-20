package by.it.prigozhanov.jd02_10.Converter;

import java.io.*;

/**
 * Created by v-omf on 4/26/2017.
 *
 * @author v-omf
 */
public abstract class AbstractConverter<T> {

    T bean;

    private Class beanClass;

    public AbstractConverter(Class beanClass) {
        this.bean = null;
        this.beanClass = beanClass;
    }

    public AbstractConverter(T bean) {
        this.bean = bean;
        this.beanClass = bean.getClass();
    }

    T getBean() {
        return bean;
    }

    Class getBeanClass() {
        return beanClass;
    }


    abstract public void buildConverter(String text);

    abstract public String getConverterResult();

    void buildConverter(File file) {
        String txtData = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = reader.readLine()) !=null) {
                txtData = txtData.concat(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        buildConverter(txtData);
    }

    void saveConverterResultToFile(File endFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(endFile))){

            bufferedWriter.write(getConverterResult());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
