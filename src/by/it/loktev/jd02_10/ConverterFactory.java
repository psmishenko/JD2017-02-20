package by.it.loktev.jd02_10;

public class ConverterFactory<T> {
/*
    static private ConverterFactory<T> instance;

    private SingleLogger(){
    }

    public static SingleLogger getInstance(){
        if (instance==null){
            instance=new SingleLogger();
        }
        return instance;
    }
  */
    public Converter createConverter(Object obj, String sourceFormatStr, String destFormatStr){
        Converter<T> conv=new Converter<T>();
        conv.set(obj.getClass(),sourceFormatStr,destFormatStr);
        return conv;
    }

}
