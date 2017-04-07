package by.it.smirnov.jd02_04_matlab.Parser;

/**
 * Класс нахождения скобок и их содержимого
 */
public class Brackets {
    /**
     * Функция возвражает позицию )
     * @param expression строка
     * @return номер позиции (-1, если не найдена)
     */
    private static int getRightPos(String expression) {
        return expression.indexOf(')');
    }

    /**
     * Функция возвражает позицию (
     * @param expression строка
     * @return номер позиции (-1, если не найдена)
     */
    private static int getLeftPos(String expression) {
        int i = -1;
        for (int k = getRightPos(expression)-1; k >= 0; k--) {
            if (expression.charAt(k)=='(') {
                i = k;
                break;
            }
        }
        return i;
    }
    /**
     * Функция возвражает класс Bracket (позиция и содержимое скобки)
     * @param expression строка
     * @return класс Bracket
     */
    public static Bracket getPart(String expression){
        Bracket result = new Bracket();
        result.setPart("");
        result.setLeftPos(getLeftPos(expression));
        result.setRightPos(getRightPos(expression));
        if (result.getLeftPos()!=-1 && result.getRightPos()!=-1)
            result.setPart(expression.substring(result.getLeftPos()+1,result.getRightPos()));
        return result;
    }

}
