package by.it.kolenda.jd01_08;

public class CDPlayer extends Player {
    public CDPlayer (String name) {
        super(name);
    }

    @Override
    public void showState() {
        System.out.println(this.toString());

    }
    @Override
    public String toString() {
        String cPlay;
        if (this.isPlay()) {
            cPlay = "CD Playback is on";
        }
        else {
            cPlay = "CD Playback is off";
        }

        String cPause;
        if (this.isPause()) {
            cPause = "CD Pause is on";
        }
        else {
            cPause = "CD Pause is off";
        }

        String cStop;
        if (this.isStop()) {
            cStop = "CD Play is off and no pause";
        }
        else {
            cStop = "CD Pause is off and stop is off";
        }

        String resCD =String.format("%s: %s, %s, %s.",this.getName(),cPlay,cPause,cStop);
        return resCD;
    }





}
