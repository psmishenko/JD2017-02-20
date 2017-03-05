package by.it.sorokoee.jd01_01;

public class Args {
    private String[] args;
    Args(String[] args) {
        this.args=args;
    }

    void printArgs(){
        for (String arg:args) {
            System.out.println(arg);
        }
    }
}
