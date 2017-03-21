package by.it.Zyryanov.jd01_06;
//В стихотворении найти количество слов, начинающихся и заканчивающихся
// гласной буквой (удобно сделать для этого отдельный метод).
//ауоыиэяюёе



public class TaskB { public static void main(String[] args) {

    int counter = 0;

    String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
    for (int i = 0; i < words.length ; i++) {
        String word = words[i];
        Glasnaya(words[i]);
        if (Glasnaya(words[i]) == true) {
            System.out.println(words[i]);
            counter++;
        }
    }
    System.out.println("количетсво слов: " + counter);

}

    static boolean Glasnaya(String word) {
        String glas = "ауоыиэяюёе";
        glas += glas.toUpperCase();
        char first = word.charAt(0);
        char last = word.charAt(word.length()-1);
        return (glas.indexOf(first)>=0 && glas.indexOf(last)>=0);
    }

}
