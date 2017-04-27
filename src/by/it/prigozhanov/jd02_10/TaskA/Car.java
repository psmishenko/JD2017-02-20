package by.it.prigozhanov.jd02_10.TaskA;

/**
 * Created by v-omf on 4/23/2017.
 *
 * @author v-omf
 */
public class Car {
    private String ModelName;
    private Integer HorsePower;
    private Integer Seats;
    private Integer LuggageCapacity;
    private Integer Doors;

    public Car() {}

    public Car(String modelName, Integer horsePower, Integer seats, Integer luggageCapacity, Integer doors) {
        ModelName = modelName;
        HorsePower = horsePower;
        Seats = seats;
        LuggageCapacity = luggageCapacity;
        Doors = doors;
    }

    public String getModelName() {
        return ModelName;
    }

    public void setModelName(String modelName) {
        ModelName = modelName;
    }

    public Integer getHorsePower() {
        return HorsePower;
    }

    public void setHorsePower(Integer horsePower) {
        HorsePower = horsePower;
    }

    public Integer getSeats() {
        return Seats;
    }

    public void setSeats(Integer seats) {
        Seats = seats;
    }

    public Integer getLuggageCapacity() {
        return LuggageCapacity;
    }

    public void setLuggageCapacity(Integer luggageCapacity) {
        LuggageCapacity = luggageCapacity;
    }

    public Integer getDoors() {
        return Doors;
    }

    public void setDoors(Integer doors) {
        Doors = doors;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "\nModelName='" + ModelName + '\'' +
                ", \nHorsePower=" + HorsePower +
                ", \nSeats=" + Seats +
                ", \nLuggageCapacity=" + LuggageCapacity +
                ", \nDoors=" + Doors +
                "\n}";
    }

}

