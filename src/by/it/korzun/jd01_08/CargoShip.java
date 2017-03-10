package by.it.korzun.jd01_08;

public abstract class CargoShip implements IShip{
    private boolean isFullOfCargo;
    private boolean isEmpty;
    private boolean fueled;
    private boolean standing;
    private boolean inThePort;
    private String name;

    CargoShip(String name){
        this.name = name;
        this.isEmpty = true;
        this.inThePort = true;
        this.standing = true;
    }

    void setFullOfCargo() {
        isFullOfCargo = true;
    }

    void setEmpty(boolean empty) {
        isFullOfCargo = false;
        isEmpty = empty;
    }

    void setStanding(boolean standing) {
        this.standing = standing;
    }

    void setInThePort(boolean inThePort) {
        this.setStanding(inThePort);
        this.inThePort = inThePort;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public String getName() {
        return name;
    }

    boolean isFullOfCargo() {
        return isFullOfCargo;
    }

    @Override
    public void refuel() {
        fueled = true;
    }

    @Override
    public boolean isFueled() {
        return fueled;
    }

    @Override
    public boolean isStanding() {
        return standing;
    }

    @Override
    public boolean isInThePort() {
        return inThePort;
    }

    public abstract void showState();

    public String[] formatShowState(){
        String []mass = new String[5];
        if (this.isInThePort())
            mass[0] = "В порту";
        else
            mass[0] = "В пути";

        if(this.isStanding())
            mass[1] = "Остановился";
        else
            mass[1] = "В движении";

        if(this.isFueled())
            mass[2] = "Заправлен";
        else
            mass[2] = "Не заправлен";

        if(this.isFullOfCargo())
            mass[3] = "Полностью загружен";
        else {
            if(isEmpty())
                mass[3] = "Абсолютно пуст";
            else
                mass[3] = "Не полностью загружен";
        }

        return mass;

    }
}
