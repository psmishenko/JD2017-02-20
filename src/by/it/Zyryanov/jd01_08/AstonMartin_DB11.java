package by.it.Zyryanov.jd01_08;


public class AstonMartin_DB11 extends CoupeCar {


    public AstonMartin_DB11(String color) {
        super.color = color;
    }

    @Override
    void showState() {
        String engine;
        String lock;
        String move;
        String con;
        String sport;

        if (isEngineWorking()) {
             engine = "Работает двигатель";
        } else {
             engine = "Двигатель выключен";
        }

        if (isDoorsClosed()) {
            lock = "Двери закрыты";
        } else {
            lock = "Двери открыты";
        }

        if (isMoving()) {
            move = "Машина едет";
        } else {
            move = "Машина стоит";
        }

        if (isACWorking()) {
            con = "Кондиционер включен, прохладно.";
        } else {
            con = "Кондиционер выключен, жарко.";
        }

        if (isSportModeOn()) {
            sport = "Коробку в спорт переключил";
        } else {
            sport = "Коробку в спорт забыл переключить";
        }

        System.out.printf(" %s \n %s \n %s \n %s \n %s ", engine, lock, move, con, sport);

    }




}


