package by.it.tereshko.jd01_08.LevelA;

public class Runner {

    public static void main(String[] args) {

        Player player = new CDPlayer("Cometa");
        player.play();
        player.showState();
        player.showState("Test");
        player.pause();
        player.showState();
        player.stop();
        player.showState();
        System.out.println("\n" + player);

    }
}