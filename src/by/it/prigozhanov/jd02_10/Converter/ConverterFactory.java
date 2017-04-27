package by.it.prigozhanov.jd02_10.Converter;

/**
 * Created by v-omf on 4/26/2017.
 *
 * @author v-omf
 */
public class ConverterFactory {
    private enum Direction {
        XML_TO_JSON, JSON_TO_XML
    }



    AbstractConverter createConverterBuilder(String typeParser, Class beanClass) {
    Direction direction = Direction.valueOf(typeParser.toUpperCase());
    switch (direction) {
        case JSON_TO_XML: return new ConverterXmltoJsonBuilder(beanClass);
        case XML_TO_JSON: return new ConverterJsonToXmlBuilder(beanClass);
        default: throw new EnumConstantNotPresentException(direction.getDeclaringClass(), direction.name());
    }
    }

}
