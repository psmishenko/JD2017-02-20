package by.it.dashkevich.jd01_06;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  TaskA_2{
    public static void main(String[] args) {
        String text = "У лукоморья дуб зеленый;\n" +
                "Златая цепь на дубе том:\n" +
                "И днем и ночью кот ученый\n" +
                "Всё ходит по цепи кругом;\n" +
                "Идет направо — песнь заводит,\n" +
                "Налево — сказку говорит.\n" +
                "Там чудеса: там леший бродит,\n" +
                "Русалка на ветвях сидит;\n" +
                "Там на неведомых дорожках\n" +
                "Следы невиданных зверей;\n" +
                "Избушка там на курьих ножках\n" +
                "Стоит без окон, без дверей;\n" +
                "Там лес и дол видений полны;\n" +
                "Там о заре прихлынут волны\n" +
                "На брег песчаный и пустой,\n" +
                "И тридцать витязей прекрасных\n" +
                "Чредой из вод выходят ясных,\n" +
                "И с ними дядька их морской;\n" +
                "Там королевич мимоходом\n" +
                "Пленяет грозного царя;\n" +
                "Там в облаках перед народом\n" +
                "Через леса, через моря\n" +
                "Колдун несет богатыря;\n" +
                "В темнице там царевна тужит,\n" +
                "А бурый волк ей верно служит;\n" +
                "Там ступа с Бабою Ягой\n" +
                "Идет, бредет сама собой;\n" +
                "Там царь Кащей над златом чахнет;\n" +
                "Там русской дух... там Русью пахнет!\n" +
                "И там я был, и мед я пил;\n" +
                "У моря видел дуб зеленый;\n" +
                "Под ним сидел, и кот ученый\n" +
                "Свои мне сказки говорил.\n" +
                "Одну я помню: сказку эту\n" +
                "Поведаю теперь я свету...";

        Pattern p1 = Pattern.compile("[А-Яа-яёЁ]+");  // instruction for regEx
        ArrayList<String> array = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        Matcher m1 = p1.matcher(text);
        while(m1.find()) {
            array.add(m1.group());  // add words to array
        }

        for(int i = 0; i<array.size(); i++) {  // через мапу считаем повторения и заносим
            Integer e=map.get(array.get(i));
            map.put(array.get(i), e==null? 1: e+1);
        }

        for(Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + " - встречается " + entry.getValue() + " раз");
        }


    }


}
