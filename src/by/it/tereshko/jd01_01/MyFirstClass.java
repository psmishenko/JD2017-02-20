package by.it.tereshko.jd01_01;

public class MyFirstClass {

    private String slogan = "Hello, world!";

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    void printSlogan() {
        System.out.println(this.slogan);
    }

}
