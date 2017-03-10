package by.it.prigozhanov.jd01_08.levelA;

/**
 * Created by v-omf on 3/10/2017!
 */
public class VideoPlayer extends Player {
    public VideoPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        String sPlay;
        if (this.isPlay())
            sPlay = "Воспроизведение включено";
        else
            sPlay = "Воспроизведение выключено";
        String sPause;
        if (this.isPause())
            sPause = "Пауза включена";
        else
            sPause = "Пауза выключена";

        System.out.printf("%s: %s, %s\n", this.getName(),sPlay, sPause);
    }

}
