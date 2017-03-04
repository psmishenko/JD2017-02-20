package by.it.prigozhanov.jd01_01;

/**
 * Created by v-omf on 3/4/2017.
 */
public class Args {
    private String[] args;

    Args(String[] args) {
        this.args = args;
    }

    void printArgs() {
        for (String arg : args) {
            System.out.println(arg);
        }
    }
}