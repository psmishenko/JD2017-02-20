package by.it.psmishenko.jd01_8;


public class CDPlayer extends Player{
    public CDPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        String sPlay;
        if (this.isPlay()) sPlay = " Music Воспроизведение включено";
        else sPlay = "Music Воспроизведение выключено";
        String sPause;
        if (this.isPause()) sPause = " Music Pause включено";
        else sPause = "Music Pause выключено";
        System.out.printf("%s: %s, %s %s\n",this.getName()," ",sPlay,sPause);
    }
}
