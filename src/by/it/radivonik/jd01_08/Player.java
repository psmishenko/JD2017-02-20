package by.it.radivonik.jd01_08;

/**
 * Created by Radivonik on 10.03.2017.
 */
public abstract class Player implements ITech {
    private boolean isPlay;
    private boolean isPause;
    private String name;

    public Player(String name) {
        this.name = name;
        isPlay = false;
        isPause = false;
    }

    @Override
    public void play() {
        isPlay = true;
        isPause = false;
    }

    @Override
    public void pause() {
        isPause = ! isPause;
    }

    @Override
    public void stop() {
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

    public String getName() {
        return name;
    }

    public abstract void showState ();

    public void showState (String prefix) {
        System.out.println(prefix);
    };
}
