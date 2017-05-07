package by.it.sorokoee.jd03_02.beans;

public class Good {
    private  int id;
    private String modelCar;
    private int yearOfIssue;
    private String spare;
    private  String typeEngine;
    private int capacityEngine;
    private  int fk_users;

    public String getModelCar() {
        return modelCar;
    }

    public void setModelCar(String modelCar) {
        this.modelCar = modelCar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }

    public int getCapacityEngine() {
        return capacityEngine;
    }

    public void setCapacityEngine(int capacityEngine) {
        this.capacityEngine = capacityEngine;
    }

    public int getFk_users() {
        return fk_users;
    }

    public void setFk_users(int fk_users) {
        this.fk_users = fk_users;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj== null || getClass() != obj.getClass()) return false;

        Good good = (Good) obj;

        if (id != good.id) return false;
        if (modelCar != null ? !modelCar.equals(good.modelCar) : good.modelCar != null) return false;
        if (yearOfIssue != good.yearOfIssue) return false;
        if (capacityEngine != good.capacityEngine) return false;
        if (fk_users != good.fk_users) return false;
        if (spare != null ? !spare.equals(good.spare) : good.spare != null) return false;
        return typeEngine != null ? typeEngine.equals(good.typeEngine) : good.typeEngine == null;

    }

    @Override
    public int hashCode() {
        int result;
        result = id;
        result = 31 * result +(modelCar != null ? modelCar.hashCode() : 0) ;
        result = 31 * result + yearOfIssue;
        result = 31 * result + (spare != null ? spare.hashCode() : 0);
        result = 31 * result + (typeEngine != null ? typeEngine.hashCode() : 0);
        result = 31 * result +capacityEngine;
        result = 31 * result + fk_users;
        return result;

    }

    public Good(int id, String modelCar, int yearOfIssue, String spare, String typeEngine, int capacityEngine, int fk_users) {
        this.id = id;
        this.modelCar = modelCar;
        this.yearOfIssue = yearOfIssue;
        this.spare = spare;
        this.typeEngine = typeEngine;
        this.capacityEngine = capacityEngine;
        this.fk_users = fk_users;
    }

    public Good() {
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", modelCar='" + modelCar + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", spare='" + spare + '\'' +
                ", typeEngine='" + typeEngine + '\'' +
                ", capacityEngine=" + capacityEngine +
                ", fk_users=" + fk_users +
                "}";
    }
}
