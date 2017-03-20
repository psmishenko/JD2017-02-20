package by.it.vedom.jd01_08.Example;

public class CDPlayer extends Player {
    public CDPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        String sPlay;
        if (this.isPlay())
            sPlay = "Музыка включена ";
        else
            sPlay = "Музыка отключена ";

        String sPause;
        if (this.isPause())
            sPause = "Пауза включена ";
        else
            sPause = "Пауза выключена ";

        System.out.printf("%s: %s, %s\n", this.getName(), sPlay, sPause);
    }

}
