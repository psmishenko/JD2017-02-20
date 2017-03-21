package by.it.psmishenko.jd01_8;


public abstract class Player implements Tech{

    private boolean isPlay;
    private boolean isPause;
    private String name ;

    public Player(String name) {
        this.name = name;
        this.isPlay = false;
        this.isPause = false;
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
    public abstract void showState();

    @Override
    public void play() {
        isPlay = true;
        isPause = false;
    }

    @Override
    public void pause() {
        isPause=!isPlay;
    }

    @Override
    public void stop() {
    isPlay =false;
        isPause=false;
    }

    public String getName() {
        return name;
    }

}
