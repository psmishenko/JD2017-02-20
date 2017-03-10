package by.it.kolenda.jd01_08;

public class VideoPlayer extends Player {
    public VideoPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        System.out.println(this.toString());

    }

    @Override
    public String toString() {
        String sPlay;
        if (this.isPlay()) {
            sPlay = "Playback is on";
        }
        else {
            sPlay = "Playback is off";
        }

        String sPause;
        if (this.isPause()) {
            sPause = "Pause is on";
        }
        else {
            sPause = "Pause is off";
        }

        String res=String.format("%s: %s, %s",this.getName(),sPlay,sPause);
        return res;
    }


}
