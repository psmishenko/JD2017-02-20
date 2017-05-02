package by.it.smirnov.jd03_02.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Role extends AbstractBeanSP{
    public Role(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                "}";
    }
}
