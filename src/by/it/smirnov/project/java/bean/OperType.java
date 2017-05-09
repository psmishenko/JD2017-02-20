package by.it.smirnov.project.java.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class OperType  extends AbstractBeanSP {
    public OperType(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public OperType() {
    }

    @Override
    public String toString() {
        return "OperType{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                "}";
    }
}
