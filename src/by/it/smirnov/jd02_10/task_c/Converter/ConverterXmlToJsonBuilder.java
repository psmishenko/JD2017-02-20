package by.it.smirnov.jd02_10.task_c.Converter;

class ConverterXmlToJsonBuilder extends AbstractConverter {

    ConverterXmlToJsonBuilder(Class beanClass) {
        super(beanClass);
    }

    public ConverterXmlToJsonBuilder(Object bean) {
        super(bean);
    }

    @Override
    public void buildConverter(String txtData) {
        bean = JAXBHelper.Unmarshal(getBeanClass(),txtData);
    }

    @Override
    public String getConverterResult() {
        return JSONHelper.toJSON(getBean());
    }

}
