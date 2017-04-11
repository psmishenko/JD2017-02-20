package by.it.ikavalenka.jd02_03;



import java.util.Map;

/**
 * Created by USER on 03.04.2017.
 */
public class Backet  {

    private Map<String, Integer> goods;
    private int num;

    public Backet(Map<String, Integer> goods,int num) {
        this.goods = goods;
        this.num = num;
    }
    public Map<String, Integer> getProduct() {
        return goods;
    }
    public void putProduct(Map<String, Integer> goods) {
        this.goods=goods;
    }
    public int getNum(){
        return num;
    }

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
        StringBuilder sb = new StringBuilder("Product in the basket: ");
        for (String sb1 : goods.keySet()){
            sb.append(sb1);
            sb.append(" ");
        }

        return sb.toString();
    }
}

