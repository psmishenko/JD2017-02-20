package by.it.zeynalov.jd01_07.LevelA;

import static sun.audio.AudioPlayer.player;

public class Runner {
    public static void main(String[] args) {
        Player player = new VideoPlayer("Cometa");
        player.play();
        player.showState();
        player.pause();
        player.showState();
        player.stop();
        player.showState();
        System.out.println("\n"+player);
    }
}
