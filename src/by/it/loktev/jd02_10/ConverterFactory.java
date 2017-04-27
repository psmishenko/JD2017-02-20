package by.it.loktev.jd02_10;

public class ConverterFactory<T> {

    public Converter createConverter(Class cls, String sourceFormatStr, String destFormatStr){
        Converter<T> conv=new Converter<T>();
        conv.set(cls,sourceFormatStr,destFormatStr);
        return conv;
    }

}
