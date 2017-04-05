package by.it.prigozhanov.jd02_01;

import java.util.List;
import java.util.Map;

/**
 * Created by v-omf on 3/29/2017.
 *
 * @author v-omf
 */
public interface IUseBucket {
    List<Good> takeBucket();
    void putGoodsToBucket(List<Good> bucketGoods, Good good);
    void putBucket();
}
