package by.it.vedom.jd01_08.Example;

public class Runner {
    public static void main(String[] args) {
        Player player = new CDPlayer("Cometa"); //задание С, динамическое наследование
        player.play();
        player.showState();
        player.showState("Test");
        player.pause();
        player.showState();
        player.stop();
        player.showState();
    }
}
