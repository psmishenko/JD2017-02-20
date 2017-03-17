package by.it.prigozhanov.jd01_08;

/**
 * Created by v-omf on 3/12/2017!
 */
public class Runner {
    public static void main(String[] args) {
        MilitaryShip militaryShip = new AeroCarrier("Carrier01-2017JDK", 40);
        militaryShip.showState();
        System.out.println("Запускаем все системы, поднимаем якорь, начинаем движение и задаём скорость (40)\n");
        militaryShip.anchorUp();
        militaryShip.engineOn();
        militaryShip.coolingSystemOn();
        militaryShip.move();
        militaryShip.setSpeed(40);
        militaryShip.showState();
        System.out.println("Остонавливаем корабль и выпускаем 50 самолётов в небо\n");
        militaryShip.stop();
        militaryShip.takeoffTheAirplane(50);
        militaryShip.showState();
        System.out.println("Выпускаем 30 самолётов в небо\n");
        militaryShip.takeoffTheAirplane(30);
        militaryShip.showState();
        System.out.println("Спускаем якорь\n");
        militaryShip.anchorDown();
        militaryShip.showState();
        System.out.println("Выключаем двигатель и систему охлаждения\n");
        militaryShip.engineOff();
        militaryShip.coolingSystemOff();
        militaryShip.showState();
        System.out.println("Выпускаем ещё 11 самолётов\n");
        militaryShip.takeoffTheAirplane(11);
    }
}
