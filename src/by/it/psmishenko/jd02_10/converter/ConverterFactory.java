package by.it.psmishenko.jd02_10.converter;

/**
 * Created by GN on 23.04.2017.
 */
public class ConverterFactory {
    private enum Direction {
        XML_To_JSON,JSON_To_XML
    }
    public AbstractConverter createConverter (String type,Class beanClass){
        Direction direction = Direction.valueOf(type);
        switch (direction){
           case JSON_To_XML: return new ConverterJSONToXML(beanClass);
            case XML_To_JSON: return new ConverterXMLToJSON(beanClass);
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(),direction.name()
            );
        }
    }
}
