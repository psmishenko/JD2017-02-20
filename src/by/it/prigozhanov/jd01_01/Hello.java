package by.it.prigozhanov.jd01_01;

/**
 * Created by v-omf on 3/4/2017.
 */
public class Hello {
    void setSlogan(String slogan) {
        this.slogan = slogan;
    }
    void printSlogan(){
        System.out.println(slogan);
    }
    private String slogan="Hello World!";
}
