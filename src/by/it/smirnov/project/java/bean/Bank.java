package by.it.smirnov.project.java.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Bank  extends AbstractBaseClass {
    private String name;
    private Country country;
    private String bic;
    private GroupBank groupBank;
    private int idsysoper;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public GroupBank getGroupBank() {
        return groupBank;
    }

    public void setGroupBank(GroupBank groupBank) {
        this.groupBank = groupBank;
    }

    public int getIdsysoper() {
        return idsysoper;
    }

    public void setIdsysoper(int idsysoper) {
        this.idsysoper = idsysoper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (getId() != bank.getId()) return false;
        if (country.getId() != bank.country.getId()) return false;
        if (groupBank.getId() != bank.groupBank.getId()) return false;
        if (idsysoper != bank.idsysoper) return false;
        if (name != null ? !name.equals(bank.name) : bank.name != null) return false;
        return bic != null ? bic.equals(bank.bic) : bank.bic == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + country.getId();
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        result = 31 * result + groupBank.getId();
        result = 31 * result + idsysoper;
        return result;
    }

    public Bank(int id, String name, Country country, String bic, GroupBank groupBank, int idsysoper) {
        setId(id);
        this.name = name;
        this.country = country;
        this.bic = bic;
        this.groupBank = groupBank;
        this.idsysoper = idsysoper;
    }

    public Bank() {
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + getId() +
                ", name='" + name + "'" +
                ", country=" + country.getName() +
                ", bic='" + bic + "'" +
                ", groupbank=" + groupBank.getName() +
                ", idsysoper=" + idsysoper +
                "}";
    }
}
