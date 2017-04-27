package by.it.loktev.jd02_10;

import com.sun.xml.internal.txw2.output.TXWSerializer;

public class Converter<T> {

    public enum Format{
        XML, JSON
    }

    Class cls;
    Convert_From<T> from;
    Convert_To<T> to;

    public void set(Class cls, String sourceFormatStr, String destFormatStr) {

        this.cls=cls;

        Format sourceFormat=Format.valueOf(sourceFormatStr.toUpperCase());
        Format destFormat=Format.valueOf(destFormatStr.toUpperCase());

        switch ( sourceFormat ){
            case XML:
                this.from=new Convert_From_XML<T>();
                break;
            case JSON:
                this.from=new Convert_From_JSON<T>();
                break;
            default:
                throw new EnumConstantNotPresentException(sourceFormat.getDeclaringClass(),sourceFormat.name());
        }

        switch ( destFormat ){
            case XML:
                this.to=new Convert_To_XML<T>();
                break;
            case JSON:
                this.to=new Convert_To_JSON<T>();
                break;
            default:
                throw new EnumConstantNotPresentException(sourceFormat.getDeclaringClass(),sourceFormat.name());
        }

    }

    public String run(String s){
        T obj=from.run(s,cls);
        /*
        System.out.println("+++temp");
        System.out.println(obj);
        System.out.println("---temp");
        */
        return to.run(obj,cls);
    }
}
