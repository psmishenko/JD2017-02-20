package by.it.smirnov.jd02_08;

/**
 * Класс запуска
 */
public class Runner {

    private static String fileNameXML = System.getProperty("user.dir")+"/src/by/it/smirnov/jd02_08/BankLimits.xml";
    public static void main(String[] args) {
        // A
        System.out.println("SAX :");
        SAX.run(fileNameXML);

        //B
        System.out.println("StAX :");
        StAX.run(fileNameXML);

        //C
        System.out.println("DOM :");
        DOM.run(fileNameXML);
    }
}
