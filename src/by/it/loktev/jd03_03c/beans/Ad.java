package by.it.loktev.jd03_03c.beans;

public class Ad {

    private int id;
    private int floor;
    private int floors;
    private int rooms;
    private String address;
    private String desc;
    private int userId;

    public Ad() {
    }

    public Ad(int id, int floor, int floors, int rooms, String address, String desc, int userId) {
        this.id = id;
        this.floor = floor;
        this.floors = floors;
        this.rooms = rooms;
        this.address = address;
        this.desc = desc;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", floor=" + floor +
                ", floors=" + floors +
                ", rooms=" + rooms +
                ", address='" + address + '\'' +
                ", desc='" + desc + '\'' +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ad ad = (Ad) o;

        if (id != ad.id) return false;
        if (floor != ad.floor) return false;
        if (floors != ad.floors) return false;
        if (rooms != ad.rooms) return false;
        if (userId != ad.userId) return false;
        if (address != null ? !address.equals(ad.address) : ad.address != null) return false;
        return desc != null ? desc.equals(ad.desc) : ad.desc == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + floor;
        result = 31 * result + floors;
        result = 31 * result + rooms;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + userId;
        return result;
    }
}
