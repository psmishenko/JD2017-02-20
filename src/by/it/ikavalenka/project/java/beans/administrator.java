package by.it.ikavalenka.project.java.beans;

/**
 * Created by USER on 09.05.2017.
 */
public class administrator extends by.it.ikavalenka.jd03_03.beans.administrator {
    private int Adm_id;
    private int Login;
    private int Password;
    private String Catalog;
    private int FullOrder_id;
    private int BlackList_id_fk;

    public int getAdm_id() {
        return Adm_id;
    }

    public void setAdm_id(int adm_id) {
        this.Adm_id = adm_id;
    }

    public int getLogin() {
        return Login;
    }

    public void setLogin(int login) {
        this.Login = login;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        this.Password = password;
    }

    public String getCatalog() {
        return Catalog;
    }

    public void setCatalog(String catalog) {
        this.Catalog = catalog;
    }

    public int getFullOrder_id() {
        return FullOrder_id;
    }

    public void setFullOrder_id(int fullOrder_id) {
        this.FullOrder_id = fullOrder_id;
    }

    public int getBlackList_id_fk() {
        return BlackList_id_fk;
    }

    public void setBlackList_id_fk(int blackList_id_fk) {
        this.BlackList_id_fk = blackList_id_fk;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        administrator adm = (administrator) obj;
        if (Adm_id !=adm.Adm_id) return false;
        if (Login !=adm.Login) return false;
        if (Password !=adm.Password) return false;
        if (Catalog != null ? !Catalog.equals(adm.Catalog):adm.Catalog == null) return false;
        if (FullOrder_id !=adm.FullOrder_id) return false;
        if (BlackList_id_fk !=adm.BlackList_id_fk) return false;
        return true;
    }

    @Override
    public int hashCode() {
    int result;
    result = Adm_id;
    result = 31* result + Login;
    result = 31*result + Password;
    result = 31*result + (Catalog !=null ? Catalog.hashCode():0);
    result = 31*result + FullOrder_id;
    result = 31*result + BlackList_id_fk;
    return result;
    }

    public administrator(int Adm_id, int Login , int Password, String Catalog, int FullOrder_id, int BlackList_id_fk){
        this.Adm_id = Adm_id;
        this.Login = Login;
        this.Password = Password;
        this.Catalog = Catalog;
        this.FullOrder_id = FullOrder_id;
        this.BlackList_id_fk = BlackList_id_fk;
    }
    public administrator(){}

    @Override
    public String toString() {
        return "administrator{" + "Adm_id "+ Adm_id + ", Login " +Login +", Password " + Password +", Catalog " + Catalog +", FullOrder_id " + FullOrder_id+", BlackList_id_fk " +BlackList_id_fk+ "}";
    }
}
