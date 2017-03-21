package by.it.zeynalov.jd01_07.LevelA;

public class VideoPlayer extends Player {

    public VideoPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        System.out.println(this.toString());
    }

    public void newShow() {
        System.out.println("newshow");
    }

    @Override
    public String toString() {
        String sPlay;
        if (this.isPlay()) {
            sPlay = "Воспроизведение включено";
        } else {
            sPlay = "Пауза включена";
        }

        String sPause;
        if (this.isPause()) {
            sPause = "Пауза включена";
        }else {
            sPause = "Пауза выключена";
        }

        String res = String.format("%s: %s, %s", this.getName(), sPlay, sPause);
        return res;
    }
}
