package by.it.psmishenko.jd01_8.MyVar;

/**
 * Var5: interface Mobile <-- abstract class Siemens Mobile <-- class Model.
 */
public class Runner {
    public static void main(String[] args) {
        SiemensMobile model = new Model("Siemens A25");
        model.call(); // пытаемся позвонить по выкл. мобильному
        model.showState(); // проверяем, вкл или вкл
        model.turnOn(); // включаем
        model.setDateAndTime();
        model.call();  model.sendTextMessage(); model.setRington();
        model.turnOff();  model.showState();
        System.out.println("---------------------------------------\nПокупаем смартфон\n---------------------------------------");
        SiemensMobile smartModel = new NewSmartModel("Siemens SmartD");
        smartModel.sendTextMessage(); // выключен
        smartModel.turnOn(); smartModel.showState(); // включаем
        smartModel.setRington();
        smartModel.call(); smartModel.setDateAndTime();smartModel.sendTextMessage();
        smartModel.turnOff(); smartModel.showState();
    }
}
