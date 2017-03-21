package by.it.psmishenko.jd01_8;


public class Runner {
    public static void main (String[] args){
        Player videoPlayer = new VideoPlayer("Cometa");
        videoPlayer.play();
        videoPlayer.showState();
        videoPlayer.pause();
        videoPlayer.showState();
        videoPlayer.stop();
        videoPlayer.showState();
        System.out.println(videoPlayer);
    }
}
