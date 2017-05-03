package by.it.smirnov.jd03_03.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Bank  extends AbstractBaseClass {
    private String name;
    private int idcountry;
    private String bic;
    private int idgroupbank;
    private int idsysoper;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdcountry() {
        return idcountry;
    }

    public void setIdcountry(int idcountry) {
        this.idcountry = idcountry;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public int getIdgroupbank() {
        return idgroupbank;
    }

    public void setIdgroupbank(int idgroupbank) {
        this.idgroupbank = idgroupbank;
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
        if (idcountry != bank.idcountry) return false;
        if (idgroupbank != bank.idgroupbank) return false;
        if (idsysoper != bank.idsysoper) return false;
        if (name != null ? !name.equals(bank.name) : bank.name != null) return false;
        return bic != null ? bic.equals(bank.bic) : bank.bic == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idcountry;
        result = 31 * result + (bic != null ? bic.hashCode() : 0);
        result = 31 * result + idgroupbank;
        result = 31 * result + idsysoper;
        return result;
    }

    public Bank(int id, String name, int idcountry, String bic, int idgroupbank, int idsysoper) {
        setId(id);
        this.name = name;
        this.idcountry = idcountry;
        this.bic = bic;
        this.idgroupbank = idgroupbank;
        this.idsysoper = idsysoper;
    }

    public Bank() {
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + getId() +
                ", name='" + name + "'" +
                ", idcountry=" + idcountry +
                ", bic='" + bic + "'" +
                ", idgroupbank=" + idgroupbank +
                ", idsysoper=" + idsysoper +
                "}";
    }
}
