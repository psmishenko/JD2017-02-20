package by.it.ikavalenka.jd03_04.java.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by USER on 06.05.2017.
 */
public abstract class ActionOne {
    abstract String execute(HttpServletRequest request);


    /**
     * Returns a string representation of the object. In general, the
     * {@code toString} method returns a string that
     * "textually represents" this object. The result should
     * be a concise but informative representation that is easy for a
     * person to read.
     * It is recommended that all subclasses override this method.
     * <p>
     * The {@code toString} method for class {@code Object}
     * returns a string consisting of the name of the class of which the
     * object is an instance, the at-sign character `{@code @}', and
     * the unsigned hexadecimal representation of the hash code of the
     * object. In other words, this method returns a string equal to the
     * value of:
     * <blockquote>
     * <pre>
     * getClass().getName() + '@' + Integer.toHexString(hashCode())
     * </pre></blockquote>
     *
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
       String name = this.getClass().getSimpleName();
       name = name.replace("Command","");
              return name;
    }
    public  String getJsp(){
        return "/"+ this.toString().toLowerCase()+".jsp";
    }
}
