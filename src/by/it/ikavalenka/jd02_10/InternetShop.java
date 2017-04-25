//package by.it.ikavalenka.jd02_09;
//
///**
// * Created by USER on 23.04.2017.
// */
//import java.util.ArrayList;
//import java.util.List;
//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import javax.xml.bind.annotation.XmlType;
//@XmlRootElement
//public class InternetShop {
//    @XmlElement(name = "InternetShop")
//    private  ArrayList<InternetShop> internetShopArrayList = new ArrayList<>();
//
//    public InternetShop() {
//        super();
//    }
//
//    public InternetShop(ArrayList<InternetShop> internetShopArrayList) {
//        this.internetShopArrayList = internetShopArrayList;
//    }
//
//    /**
//     * Returns a string representation of the object. In general, the
//     * {@code toString} method returns a string that
//     * "textually represents" this object. The result should
//     * be a concise but informative representation that is easy for a
//     * person to read.
//     * It is recommended that all subclasses override this method.
//     * <p>
//     * The {@code toString} method for class {@code Object}
//     * returns a string consisting of the name of the class of which the
//     * object is an instance, the at-sign character `{@code @}', and
//     * the unsigned hexadecimal representation of the hash code of the
//     * object. In other words, this method returns a string equal to the
//     * value of:
//     * <blockquote>
//     * <pre>
//     * getClass().getName() + '@' + Integer.toHexString(hashCode())
//     * </pre></blockquote>
//     *
//     * @return a string representation of the object.
//     */
//    @Override
//    public String toString() {
//        return "InternetShop" + "array:" + internetShopArrayList + "!";
//    }
//    public boolean add (Administrator
//}
package by.it.ikavalenka.jd02_10;

/**
 * Created by USER on 23.04.2017.
 */

import by.it.ikavalenka.jd02_09.B.Administrator;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class InternetShop {
    @XmlElement(name = "InternetShop")
    private ArrayList<by.it.ikavalenka.jd02_09.B.Administrator> administrators = new ArrayList<>();
    public InternetShop(){
        super();
    }
    public void setList(ArrayList<by.it.ikavalenka.jd02_09.B.Administrator> list) {
        this.administrators = list;
    }
    public boolean add (Administrator adm){
        return administrators.add(adm);
    }

    @Override
    public String toString() {
            return "InternetShop" + "array:" +
                    administrators + "!";
        }

}


