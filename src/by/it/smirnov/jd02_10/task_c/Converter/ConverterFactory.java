package by.it.smirnov.jd02_10.task_c.Converter;


public class ConverterFactory {
    public enum Direction{
        XML_TO_JSON, JSON_TO_XML
    }

    public static AbstractConverter createConverterBuilder(Direction direction, Class beanClass){
        AbstractConverter ac = null;
        switch (direction) {
            case XML_TO_JSON:
            {
                ac = new ConverterXmlToJsonBuilder(beanClass);
                break;
            }
            case JSON_TO_XML:
            {
                ac = new ConverterJsonToXmlBuilder(beanClass);
                break;
            }
        }
        return ac;
    }
}
