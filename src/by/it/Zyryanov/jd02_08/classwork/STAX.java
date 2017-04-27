package by.it.Zyryanov.jd02_08.classwork;


import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class STAX {
    private XMLStreamReader reader;

    public STAX(XMLStreamReader reader){
        this.reader =reader;
    }

    void run() throws XMLStreamException {

        while (reader.hasNext()){
            int operation = reader.next();
            switch (operation){
                case XMLStreamConstants.START_ELEMENT:
                    System.out.println("START_ELEMENT");
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    System.out.println("END_ELEMENT");
                    break;
                case XMLStreamConstants.END_DOCUMENT:
                    System.out.println("END_DOCUMENT");
                    break;
                case XMLStreamConstants.CHARACTERS:
                    System.out.println("CHARACTERS");
                    break;
            }
        }
    }

}
