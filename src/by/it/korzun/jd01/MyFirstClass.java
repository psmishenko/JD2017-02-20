package by.it.korzun.jd01;


class MyFirstClass {
    private String slogan;

    private String getSlogan() {
        return slogan;
    }

    void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    void printSlogan(){
        System.out.println(getSlogan());
    }
}
