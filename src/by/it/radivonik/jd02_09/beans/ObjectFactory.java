package by.it.radivonik.jd02_09.beans;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the by.it.radivonik.jd02_09.beans.generate package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: by.it.radivonik.jd02_09.beans.generate
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Naklads }
     *
     */
    public Naklads createNaklads() {
        return new Naklads();
    }

    /**
     * Create an instance of {@link Naklad }
     *
     */
    public Naklad createNaklad() {
        return new Naklad();
    }

    /**
     * Create an instance of {@link Klient }
     *
     */
    public Klient createKlient() {
        return new Klient();
    }

    /**
     * Create an instance of {@link Tovars }
     *
     */
    public Tovars createTovars() {
        return new Tovars();
    }

    /**
     * Create an instance of {@link Avto }
     *
     */
    public Avto createAvto() {
        return new Avto();
    }

    /**
     * Create an instance of {@link Tovar }
     *
     */
    public Tovar createTovar() {
        return new Tovar();
    }

}
