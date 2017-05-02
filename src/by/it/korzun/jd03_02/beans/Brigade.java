package by.it.korzun.jd03_02.beans;

public class Brigade {
    private int id;
    private int firstPilotID;
    private int secondPilotID;
    private int navigatorID;
    private int radio_operatorID;
    private int stewardessID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFirstPilotID() {
        return firstPilotID;
    }

    public void setFirstPilotID(int firstPilotID) {
        this.firstPilotID = firstPilotID;
    }

    public int getSecondPilotID() {
        return secondPilotID;
    }

    public void setSecondPilotID(int secondPilotID) {
        this.secondPilotID = secondPilotID;
    }

    public int getNavigatorID() {
        return navigatorID;
    }

    public void setNavigatorID(int navigatorID) {
        this.navigatorID = navigatorID;
    }

    public int getRadio_operatorID() {
        return radio_operatorID;
    }

    public void setRadio_operatorID(int radio_operatorID) {
        this.radio_operatorID = radio_operatorID;
    }

    public int getStewardessID() {
        return stewardessID;
    }

    public void setStewardessID(int stewardessID) {
        this.stewardessID = stewardessID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brigade brigade = (Brigade) o;

        if (id != brigade.id) return false;
        if (firstPilotID != brigade.firstPilotID) return false;
        if (secondPilotID != brigade.secondPilotID) return false;
        if (navigatorID != brigade.navigatorID) return false;
        if (radio_operatorID != brigade.radio_operatorID) return false;
        return stewardessID == brigade.stewardessID;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstPilotID;
        result = 31 * result + secondPilotID;
        result = 31 * result + navigatorID;
        result = 31 * result + radio_operatorID;
        result = 31 * result + stewardessID;
        return result;
    }

    @Override
    public String toString() {
        return "Brigade{" +
                "id=" + id +
                ", firstPilotID=" + firstPilotID +
                ", secondPilotID=" + secondPilotID +
                ", navigatorID=" + navigatorID +
                ", radio_operatorID=" + radio_operatorID +
                ", stewardessID=" + stewardessID +
                '}';
    }

    public Brigade(int id, int firstPilotID, int secondPilotID, int navigatorID, int radio_operatorID, int stewardessID) {
        this.id = id;
        this.firstPilotID = firstPilotID;
        this.secondPilotID = secondPilotID;
        this.navigatorID = navigatorID;
        this.radio_operatorID = radio_operatorID;
        this.stewardessID = stewardessID;
    }

    public Brigade() {
    }
}
