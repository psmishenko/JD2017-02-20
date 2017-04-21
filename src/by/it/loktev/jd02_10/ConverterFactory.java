package by.it.loktev.jd02_10;

public class ConverterFactory {

    private enum Format{
        XML, JSON
    }

    AbstractConverter createConverterBuilder(Class beanClass, String sourceFormatStr, String destFormatStr){
        Format sourceFormat=Format.valueOf(sourceFormatStr.toUpperCase());
        Format destFormat=Format.valueOf(destFormatStr.toUpperCase());
        /*
        switch (direction) {
            case XML_TO_JSON:
            {
                return new ConverterXmlToJsonBuilder(beanClass);
            }
            case JSON_TO_XML:
            {
                return new ConverterJsonToXmlBuilder(beanClass);
            }
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(),direction.name()
            );
        }
        */
        return null;
    }

}
