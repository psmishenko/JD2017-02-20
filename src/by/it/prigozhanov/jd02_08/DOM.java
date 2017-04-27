package by.it.prigozhanov.jd02_08;

import org.w3c.dom.*;

/**
 * Created by v-omf on 4/17/2017!
 */
public class DOM {

    private static StringBuilder text = new StringBuilder();
    private static String tab;
    private static Document document;

    public DOM(Document document) {
        this.document = document;
    }

    public void run() {

        Element root = document.getDocumentElement();
        NodeList nList = root.getChildNodes();
        text.append("<" + root.getTagName() + ">\n");
        tab = "\t";
        Node typeOfCars = nList.item(1);
        text.append(tab).append("<").append(typeOfCars.getNodeName()).append(">\n");
        NodeList carList = typeOfCars.getChildNodes();
        for (int i = 1; i < carList.getLength(); i += 2) {
            text.append(tab + "\t").append("<").append(carList.item(i).getNodeName()).append(">\n");
            NodeList car = carList.item(i).getChildNodes();
            for (int j = 1; j < car.getLength(); j += 2) {
                Element element = (Element) car.item(j);
                text.append(tab + "\t\t").append("<").append(element.getTagName());
                if (((Element) car.item(j)).hasAttributes()) {
                    text.append(" " + car.item(j).getAttributes().item(0));
                }
                text.append(">");
                if (car.item(j).getChildNodes().getLength() == 1) text.append(car.item(j).getTextContent());
                if (car.item(j).getChildNodes().getLength() > 1) {
                    NodeList carStats = car.item(j).getChildNodes();
                    text.append("\n");
                    for (int k = 1; k < carStats.getLength(); k += 2) {
                        text.append(tab + "\t\t\t").append("<").append(carStats.item(k).getNodeName()).append(">");
                        text.append(carStats.item(k).getTextContent());
                        text.append("</").append(carStats.item(k).getNodeName()).append(">\n");
                    }

                    text.append(tab + "\t\t").append("</").append(element.getTagName()).append(">\n");
                } else
                    text.append("</").append(element.getTagName()).append(">\n");
            }
            text.append(tab + "\t").append("</").append(carList.item(i).getNodeName()).append(">\n");
        }
        text.append(tab).append("</").append(typeOfCars.getNodeName()).append(">\n");
        text.append("<" + root.getTagName() + ">\n");

        System.out.println(text.toString());
    }

    protected void checkPriceList() {
        System.out.println("Pricelist");
        System.out.println("Currency   "+"Price" + "            " + "Car");
        NodeList car = document.getElementsByTagName("Car");
        for (int i = 0; i < car.getLength(); i++) {
            Element el = (Element) car.item(i);
            System.out.print(el.getElementsByTagName("Price").item(0).getAttributes().item(0).getNodeName()+"        ");

            System.out.print(el.getElementsByTagName("Price").item(0).getAttributes().item(0).getNodeValue() + "      ");
            NodeList carStats = el.getElementsByTagName("Model");
            for (int j = 0; j < carStats.getLength(); j++) {
                Element statElement = (Element) carStats.item(j);
                System.out.println(statElement.getElementsByTagName("Name").item(0).getTextContent());
            }

        }
    }

}

