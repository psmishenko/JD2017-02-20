package by.it.ikavalenka.jd02_09.C;
import javax.xml.bind.annotation.XmlRegistry;
/**
 * Created by USER on 25.04.2017.
 */
@XmlRegistry
public class ObjFact {
    public ObjFact(){}
    public InternetShop createInternetShop(){
        return new InternetShop();
    }
    public Administrator createAdministrator(){
        return new Administrator();
    }
}
