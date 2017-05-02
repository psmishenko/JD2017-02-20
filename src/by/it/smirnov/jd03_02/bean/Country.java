package by.it.smirnov.jd03_02.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Country extends AbstractBeanSP{

    public Country(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Country() {
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                "}";
    }


}

