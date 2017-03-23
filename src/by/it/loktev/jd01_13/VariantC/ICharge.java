package by.it.loktev.jd01_13.VariantC;

public interface ICharge {

    void chargeStart();
    void chargeEnd();

    int getBatteryLevel();
    void setBatteryLevel(int level);
    void changeBatteryLevel(int delta);

}
