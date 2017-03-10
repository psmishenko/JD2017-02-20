package by.it.kolenda.jd01_08;


public class Runner {


    public static void main (String[] args) {
        Player player = new VideoPlayer("Cometa");
        player.play();
        player.showState();
        player.showState("Test");
        player.pause();
        player.showState();
        player.stop();
        player.showState();
        System.out.println("\n"+player);
    }
}
