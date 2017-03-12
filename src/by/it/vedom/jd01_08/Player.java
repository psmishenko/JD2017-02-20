package by.it.vedom.jd01_08;

public abstract class Player implements iTech {

    private boolean isPlay;
    private boolean isPause;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Player(String name) {
        this.name = name;
        this.isPlay = false; // можно с this, а можно и без, т.к у нас одна переменная с данным названием
        isPause = false;     // в функцию передается только name, к нему обязательно this
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

    //задание B (статическое связывание)
    public void showState(String prefix) {
        System.out.println(prefix);
    }

    @Override
    public void play() {
        isPlay = true;
        isPause = false;
    }

    @Override
    public void pause() {
        isPause = !isPause;
    }

    @Override
    public void stop() {
        isPlay = false;
        isPause = false;
    }
}
