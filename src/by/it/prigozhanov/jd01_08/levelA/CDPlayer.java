package by.it.prigozhanov.jd01_08.levelA;

/**
 * Created by v-omf on 3/10/2017!
 */
public class CDPlayer extends Player {

    public CDPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        String sPlay;
        if (this.isPlay())
            sPlay = "Музыка включена";
        else
            sPlay = "Музыка выключена";
    }
}
