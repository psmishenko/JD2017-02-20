package by.it.loktev.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var {

    public VarV(String str) {
        fromString(str);
    }

    @Override
    public void fromString(String str) {
        // ожидаем строку вида {55.2,8,3.3}

        String doubleRE=" *(\\d+(?:\\.\\d*)?) *";
        String vectorRE=" *\\{(?:"+doubleRE+", *)*"+doubleRE+" *\\} *";
        Pattern p = Pattern.compile("^"+vectorRE+"$");
        Matcher m = p.matcher(str);
        if ( !m.matches() ) {
            new CalculatorError(str + " - недопустимое значение для преобразования в вектор");
            return;
        }
        //m.reset();
        System.out.println(m.groupCount());
        System.out.println(m.group(0));
        System.out.println(m.group(1));
        System.out.println(m.group(2));
        // посчитаем, сколько значений будет
        //while (m.find()) {
        //    System.out.println("e-mail: " + m.group());
        //}
        //this.value=Double.parseDouble(m.group());


        /*
// проверка на соответствие строки шаблону
            Pattern p1 = Pattern.compile("a+y");
            Matcher m1 = p1.matcher("aaay");
            boolean b = m1.matches();
            System.out.println(b);
// поиск и выбор подстроки, заданной шаблоном
            String regex = "(\\w{6,})@(\\w+\\.)([a-z]{2,4})";
            String s = "адреса эл.почты:anbaran@gmail.com, rowerano@it.by, no@it.by!";
            Pattern p2 = Pattern.compile(regex);
            Matcher m2 = p2.matcher(s);
            while (m2.find()) {
                System.out.println("e-mail: " + m2.group());
            }
// разбиение строки на подстроки с применением шаблона в качестве разделителя
            Pattern p3 = Pattern.compile("\\d+\\s?");
            String[ ] words = p3.split("java5tiger 77 java6mustang");
            System.out.print(Arrays.toString(words));

         */

    }

    @Override
    public String toString() {
        //return value.toString();
        return "";
    }

    @Override
    public Var add(Var arg) {
        System.out.println("сложение вектора с чем-то");
        return null;
    }
}
