package by.it.radivonik.jd02_08;

/**
 * Created by Radivonik on 17.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        String filexml = System.getProperty("user.dir") + "/src/by/it/radivonik/jd02_08/naklads.xml";

        System.out.println("Вариант A (SAX)");
        SAX parserSAX = new SAX();
        System.out.println(parserSAX.parse(filexml));

        System.out.println("\nВариант B (StAX)");
        StAX parserStAX = new StAX();
        System.out.println(parserStAX.parse(filexml));

        System.out.println("\nВариант C (DOM)");
        DOM parserDOM = new DOM();
        System.out.println(parserDOM.parse(filexml));
    }
}
