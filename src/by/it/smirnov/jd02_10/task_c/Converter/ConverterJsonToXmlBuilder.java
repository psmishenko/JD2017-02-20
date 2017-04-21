package by.it.smirnov.jd02_10.task_c.Converter;

class ConverterJsonToXmlBuilder extends AbstractConverter {

    ConverterJsonToXmlBuilder(Class beanClass) {
        super(beanClass);
    }

    public ConverterJsonToXmlBuilder(Object bean) {
        super(bean);
    }

    @Override
    public void buildConverter(String txtData) {
        bean = JSONHelper.fromJSON(getBeanClass(), txtData);
    }

    @Override
    public String getConverterResult() {
        return JAXBHelper.Marshal(getBean());
    }
}
