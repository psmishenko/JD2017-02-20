package by.it.tereshko.jd01_08.LevelA;

public class VideoPlayer extends Player {
    public VideoPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        System.out.println(this.toString());
    }

    public void newShow() {
        System.out.println("newShow");
    }

    @Override
    public String toString() {
        String sPlay;
        if (this.isPlay()) {
            sPlay = "Play is on";
        } else {
            sPlay = "Play is off";
        }

        String sPause;
        if (this.isPause()) {
            sPause = "Pause is on";
        } else {
            sPause = "Pause is off";
        }

        String res = String.format("%s: %s, %s", this.getName(), sPlay, sPause);
        return res;
    }
}
