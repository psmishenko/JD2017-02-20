package by.it.prigozhanov.jd01_08.levelA;

/**
 * Created by v-omf on 3/10/2017.
 */
public abstract class Player implements ITech {
    private boolean isPlay;
    private boolean isPause;
    private String name;

    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
        isPause=false;
        isPause=false;
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
        isPause =!isPause;
    }

    @Override
    public void stop() {
        isPlay=false;
        isPause=false;
    }

}
