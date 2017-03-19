package by.it.sorokoee.jd01_08;

public abstract class Lamp implements ILightSource {
    private boolean state=false;

    @Override
    public void on() {
        state = true;
    }
    @Override
    public void off() {
        state = false;
    }
    public boolean getState() {
        return state;
    }

    @Override
    public String showState() {
        String state=null;
        if (this.getState()){
            state="Лампа включена";}
        else if (!this.getState()){
            state="Лампа выключена";
        }

        return state;
    }
}
