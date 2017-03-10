package by.it.loktev.jd01_08;

public interface ICharge {

    void chargeStart();
    void chargeEnd();

    int getBatteryLevel();
    void setBatteryLevel(int level);

}
