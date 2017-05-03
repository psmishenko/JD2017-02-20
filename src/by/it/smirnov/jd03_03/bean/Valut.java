package by.it.smirnov.jd03_03.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Valut extends AbstractBaseClass {
	private String namesokr;
    private String namefull;

    public String getNamesokr() {
        return namesokr;
    }

    public void setNamesokr(String namesokr) {
        this.namesokr = namesokr;
    }

    public String getNamefull() {
        return namefull;
    }

    public void setNamefull(String namefull) {
        this.namefull = namefull;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Valut valut = (Valut) o;

        if (getId() != valut.getId()) return false;
        if (namesokr != null ? !namesokr.equals(valut.namesokr) : valut.namesokr != null) return false;
        return namefull != null ? namefull.equals(valut.namefull) : valut.namefull == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (namesokr != null ? namesokr.hashCode() : 0);
        result = 31 * result + (namefull != null ? namefull.hashCode() : 0);
        return result;
    }

    public Valut(int id, String namesokr, String namefull) {
        setId(id);
        this.namesokr = namesokr;
        this.namefull = namefull;
    }

    public Valut() {
    }

    @Override
    public String toString() {
        return "Valut{" +
                "id=" + getId() +
                ", namesokr='" + namesokr + "'" +
                ", namefull='" + namefull + "'" +
                "}";
    }
}
