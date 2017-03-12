package by.it.zeynalov.jd01_07.LevelA;

public class CDPlayer extends Player {
    public CDPlayer(String name) {
        super(name);
    }

    public void showState() {
        String sPlay;
        if (this.isPlay()){
            sPlay= "Музыка включена";
        }else {
            sPlay = "Музыка включена";
        }

        String sPause;
        if (this.isPause()) {
            sPause = "Муызка на паузе";
        }else {
            sPause = "Муызка играет";
        }

        System.out.printf("%s: %s, %s", this.getName(), sPlay, sPause);
    }

}
