package by.it.smirnov.jd03_03.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class GroupBank  extends AbstractBeanSP {
    public GroupBank(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public GroupBank() {
    }

    @Override
    public String toString() {
        return "GroupBank{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                "}";
    }
}
