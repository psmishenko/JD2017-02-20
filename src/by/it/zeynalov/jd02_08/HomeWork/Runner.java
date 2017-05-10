package by.it.zeynalov.jd02_08.HomeWork;

public class Runner {
    private static String fileXML = System.getProperty("user.dir")+"/src/by/it/zeynalov/jd02_08/HomeWork/CoffeeHouses.xml";
    public static void main(String[] args) {

        System.out.println("SAX :");
        SAX.run(fileXML);

        System.out.println("StAX :");
        StAX.run(fileXML);

        System.out.println("DOM :");
        DOM.run(fileXML);
    }
}
