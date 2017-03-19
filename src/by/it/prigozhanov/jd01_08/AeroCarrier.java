package by.it.prigozhanov.jd01_08;

/**
 * Created by v-omf on 3/12/2017!
 */
public class AeroCarrier extends MilitaryShip {

    private int numberOfAircrafts;

    public AeroCarrier (String name, int numberOfAircrafts) {
        super(name);
        this.numberOfAircrafts = numberOfAircrafts;
    }

    public void takeoffTheAirplane(int amountOfAircrafts) {
        if (amountOfAircrafts > this.numberOfAircrafts) {
            System.out.println("!  ---------------  !");
            System.out.println("Неверное колличество выпущенных самолётов!!!");
        } else {
            numberOfAircrafts -= amountOfAircrafts;
            System.out.println("--------------------");
            if (amountOfAircrafts <= 1) {
                System.out.println("Вылетел " + amountOfAircrafts + " самолёт");
            } else if (amountOfAircrafts > 1 && amountOfAircrafts < 5) {
                System.out.println("Вылетело " + amountOfAircrafts + " самолёта");
            } else
                System.out.println("Вылетело " + amountOfAircrafts + " самолётов");
        }
    }

    @Override
    void showState() {
        String anchor;
        if (this.isAnchorUp()) {
            anchor = "Якорь поднят";
        } else {
            anchor = "Якорь спущен";
        }
        String coolingSystem;
        if (this.isCoolingSystemOn()) {
            coolingSystem = "Система охлаждения включена";
        } else {
            coolingSystem = "Система охлаждения выключена";
        }
        String engine;
        if (this.isEngineOn()) {
            engine = "Двигатель работает";
        } else {
            engine = "Двигатель не работает";
        }
        String moving;
        if (isMoving()) {
            moving = "Корабль начал движение";
        } else {
            moving = "Корабль не двигается";
        }

        System.out.println("----------------------");
        System.out.printf("Авианосец [ %s ]\nСтатус: %s\nСкорость = %d узлов\n%s\n%s\n%s\nКолличество самолётов на борту: %d\n",
                this.getName(), moving, this.getSpeed(), anchor, coolingSystem, engine, numberOfAircrafts);
        System.out.println("----------------------\n");
    }
}
