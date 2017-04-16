package by.it.smirnov.jd02_06_matlab.Parser;

/**
 * Класс позиции и содержимого скобки
 */
public class Bracket {
    private int leftPos; // позиция (
    private int rightPos; // позиция )
    private String part; // содержимое между leftPos и rightPos

    public int getLeftPos() {
        return leftPos;
    }

    public int getRightPos() {
        return rightPos;
    }

    public String getPart() {
        return part;
    }

    public void setLeftPos(int leftPos) {
        this.leftPos = leftPos;
    }

    public void setRightPos(int rightPos) {
        this.rightPos = rightPos;
    }

    public void setPart(String part) {
        this.part = part;
    }
}
