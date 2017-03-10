package by.it.psmishenko.jd01_8;


public class VideoPlayer extends Player {

    public VideoPlayer(String name) {
        super(name);
    }

    @Override
    public void showState() {
        System.out.println(this.toString());
    }
public void newShow(){
    System.out.println("blabla");
}

    @Override
    public String toString() {
        return "VideoPlayer{}";
    }

}
