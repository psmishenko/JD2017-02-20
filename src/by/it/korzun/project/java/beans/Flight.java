package by.it.korzun.project.java.beans;

public class Flight {
    private int id;
    private int brigadeID;
    private String destination;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrigadeID() {
        return brigadeID;
    }

    public void setBrigadeID(int brigadeID) {
        this.brigadeID = brigadeID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (id != flight.id) return false;
        if (brigadeID != flight.brigadeID) return false;
        return destination != null ? destination.equals(flight.destination) : flight.destination == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + brigadeID;
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", brigadeID=" + brigadeID +
                ", destination='" + destination + '\'' +
                '}';
    }
}
