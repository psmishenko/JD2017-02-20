package by.it.radivonik.jd01_08;

/**
 * Created by Radivonik on 10.03.2017.
 */
public class VideoPlayer extends Player {
    public VideoPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        String sPlay = this.isPlay() ? "Воспроизведение включено" : "Воспроизведение выключено";
        String sPаuse = this.isPause() ? "Пауза включена" : "Пауза выключена";
        System.out.printf("%s: %s %s\n",getName(),sPlay,sPаuse);
    }

    @Override
    public String toString() {
        String sPlay = this.isPlay() ? "Воспроизведение включено" : "Воспроизведение выключено";
        String sPаuse = this.isPause() ? "Пауза включена" : "Пауза выключена";
        return String.format("%s: %s %s",getName(),sPlay,sPаuse);
    }
}
