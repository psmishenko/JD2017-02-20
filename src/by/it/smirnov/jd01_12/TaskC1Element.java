package by.it.smirnov.jd01_12;

/**
 * Класс элемента списка (String, Integer)
 * @version 1.0.0
 */
public class TaskC1Element {
    private String name;
    private Integer barcode;

    TaskC1Element(String name, Integer barcode) {
        this.name = name;
        this.barcode = barcode;
    }
    String getName() {
        return this.name;
    }
    Integer getBarcode() {
        return this.barcode;
    }

    @Override
    public String toString() {
        return "Наименование='" + name + '\'' +
                ", Шифр=" + barcode + '\n';
    }
}
