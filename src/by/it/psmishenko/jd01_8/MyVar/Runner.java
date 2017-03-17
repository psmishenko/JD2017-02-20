package by.it.psmishenko.jd01_8.MyVar;

/**
 * Var5: interface Mobile <-- abstract class Siemens Mobile <-- class Model.
 */
public class Runner {
    public static void main(String[] args) {
        Model model = new Model("Siemens A25");
        model.turnOff();
        model.call(); model.sendTextMessage(); model.setRington();
        model.showState();
        model.turnOn();  model.showState();
        model.call();  model.sendTextMessage(); model.setRington();
        SiemensMobile mobile = new Model("Siemens K12345");
        mobile.showState(); mobile.turnOn();
        mobile.call();mobile.setRington();mobile.sendTextMessage();

    }
}
