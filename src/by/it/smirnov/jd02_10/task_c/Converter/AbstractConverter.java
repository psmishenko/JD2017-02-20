package by.it.smirnov.jd02_10.task_c.Converter;

import java.io.*;

abstract public class AbstractConverter<T> {
    T bean;
    private Class beanClass;

    AbstractConverter(Class beanClass) {
        bean = null;
        this.beanClass = beanClass;
    }

    AbstractConverter(T bean) {
        this.bean = bean;
        this.beanClass = bean.getClass();
    }

    T getBean() {
        return bean;
    }
    Class getBeanClass() {
        return beanClass;
    }

    abstract public void buildConverter(String txtData);

    abstract public String getConverterResult();

    public void buildConverter(File file){
        buildConverter(FileHelper.readFromFile(file));
    };

    public void saveToFileConverterResult(File file){
        FileHelper.writeToFile(file, getConverterResult());
    };

}
