package by.it.kolenda.jd01_08;


public abstract class Player implements ITech {
    private boolean isPlay;
    private boolean isPause;

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
        return sPlay+" "+sPause;


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

//    public abstract void showState();

    @Override
    public void play() {
        isPlay = true;
        isPause = false;
    }

    @Override
    public void pause() {
        isPause=!isPause;

    }

    @Override
    public void stop() {
        isPlay = false;
        isPause = false;
    }

    public void showState(){
        System.out.println(this.toString());
    }

    public void showState(String prefix) {
        System.out.println(prefix+this);
    }


    }

