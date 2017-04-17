package by.it.loktev.jd02_08;

public class Runner {

    public static void main(String[] args) {

        String XMLFileName=System.getProperty("user.dir")+"/src/by/it/loktev/jd02_08/picture.xml";

        SAXTest.run(XMLFileName);

        StAXTest.run(XMLFileName);

    }


}
