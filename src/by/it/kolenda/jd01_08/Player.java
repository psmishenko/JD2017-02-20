package by.it.kolenda.jd01_08;


public abstract class Player implements ITech {
    private boolean isPlay;
    private boolean isPause;
    private boolean isStop;

    public String getName() {
        return name;
    }

    private String name;

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


        String sStop;
        if (this.isStop()) {
            sStop = "Playback is off";
        }
        else {
            sStop = "Playback is possible";
        }
        return sPlay+" "+sPause+" "+sStop;

    }


    public Player(String name) {
        this.name = name;
        isPlay = false;
        isPause = false;
    }

    public boolean isPlay() {
        return isPlay;
    }

    public void setPlay(boolean play) {
        isPlay = play;
    }

    public boolean isPause() {
        return isPause;
    }

    public void setPause(boolean pause) {
        isPause = pause;
    }

    public boolean isStop() {return isStop;}

    public void setStop(boolean stop) {isStop = stop;}

//    public abstract void showState();

    @Override
    public void play() {
        isPlay = true;
        isPause = false;
        isStop = false;
    }

    @Override
    public void pause() {
        isPause=!isPause;

    }

    @Override
    public void stop() {
        isPlay = false;
        isPause = false;
        isStop = true;
    }

    public void showState(){
        System.out.println(this.toString());
    }

    public void showState(String prefix) {
        System.out.println(prefix+this);
    }


    }

