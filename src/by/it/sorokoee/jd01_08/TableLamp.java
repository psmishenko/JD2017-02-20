package by.it.sorokoee.jd01_08;



public class TableLamp extends Lamp {
    private int brightness = 0;

    public TableLamp(int brightness) {
        this.brightness = brightness;
    }

    public TableLamp() {
    }

    public void setBrightness(int value){
        brightness = value;
    }
    public int getBrightness(){
        return brightness;
    }

    @Override
    public String showState() {
        return super.showState();


    }
    public String showState(TableLamp tableLamp) {

            String state = null;
            if (this.getState()) {
                state = "Лампа включена c яркостью " + brightness;
            } else if (!this.getState()) {
                state = "Лампа выключена";
            }

            return state;
        }


}
