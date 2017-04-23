package by.it.radivonik.jd02_10.converter;

/**
 * Created by Radivonik on 23.04.2017.
 */
public class ConverterFactory<T> {
    public enum Direction {
        XML_TO_JSON, JSON_TO_XML
    }

    public AbstractConverter<T> createConverter(Direction direction, Class<T> beanClass){
        switch (direction) {
            case XML_TO_JSON:
                return new ConverterXmlToJson<T>(beanClass);
            case JSON_TO_XML:
                return new ConverterJsonToXml<T>(beanClass);
            default:
                throw new EnumConstantNotPresentException(direction.getDeclaringClass(), direction.name());
        }
    }
}
