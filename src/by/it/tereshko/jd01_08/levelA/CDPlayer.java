package by.it.tereshko.jd01_08.levelA;

public class CDPlayer extends Player {
    public CDPlayer(String name) {
        super(name);
    }

    public void showState() {
        String sPlay;
        if (this.isPlay()) {
            sPlay = "Music is on";
        } else {
            sPlay = "Music is off";
        }

        String sPause;
        if (this.isPause()) {
            sPause = "Music is paused";
        } else {
            sPause = "Music is being played";
        }

        System.out.printf("%s: %s, %s", this.getName(), sPlay, sPause);
    }

}