package by.it.ikavalenka.jd_08;

/**
 * Created by USER on 10.03.2017.
 */
public abstract class AbstractGun implements Weapon {
     public abstract void  hand();
     public  void  lock(){
         System.out.println("autolock");
     }

    protected int model;

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }
}
