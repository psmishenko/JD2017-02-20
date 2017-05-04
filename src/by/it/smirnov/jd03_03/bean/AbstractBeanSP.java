package by.it.smirnov.jd03_03.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public abstract class AbstractBeanSP extends AbstractBaseClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public AbstractBeanSP(int id, String name) {
        this.setId(id);
        this.setName(name);
    }

    public AbstractBeanSP() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractBeanSP abc = (AbstractBeanSP) o;

        if (getId() != abc.getId()) return false;
        return getName() != null ? getName().equals(abc.getName()) : abc.getName() == null;
    }

}
