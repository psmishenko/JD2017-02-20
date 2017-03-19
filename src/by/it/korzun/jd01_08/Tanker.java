package by.it.korzun.jd01_08;


public class Tanker extends CargoShip{
    private boolean oilFulled;

    void setOilFulled() {
        this.oilFulled = true;
    }

    private boolean isOilFulled(){
        return oilFulled;
    }

    Tanker(String name) {
        super(name);
    }

    @Override
    public String[] formatShowState() {
        String []mass = super.formatShowState();
        if(this.isOilFulled())
            mass[4] = "Заполнен нефтью";
        else
            mass[4] = "Не заполнен нефтью";
        return mass;
    }

    @Override
    public void showState() {
        System.out.println(this);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        String sSwimming;
        if (this.isInThePort())
            sSwimming = "В порту";
        else
            sSwimming = "В пути";

        String sStanding;
        if(this.isStanding())
            sStanding = "Остановился";
        else
            sStanding = "В движении";

        String sFueled;
        if(this.isFueled())
            sFueled = "Заправлен";
        else
            sFueled = "Не заправлен";

        String sFullOfCargo;
        if(this.isFullOfCargo())
            sFullOfCargo = "Полностью загружен";
        else {
            if(isEmpty())
                sFullOfCargo = "Абсолютно пуст";
            else
                sFullOfCargo = "Не полностью загружен";
        }

        String sOilFueled;
        if(this.isOilFulled())
            sOilFueled = "Заполнен нефтью";
        else
            sOilFueled = "Не заполнен нефтью";

        return sSwimming + ", " + sStanding + ", " + sFueled + ", " + sOilFueled + ", " + sFullOfCargo;
    }
}
