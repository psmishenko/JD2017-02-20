package by.it.kolenda.jd01_06;


public class TaskA {
    public static void main(String[] args) {
        String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int counter = 0;
            if (!word.isEmpty())
                for (int j = i + 1; j < words.length; j++) {
                    if (word.equalsIgnoreCase(words[j])) {
                        counter++;
                        words[j] = "";
                    }
                    System.out.printf("Слово %s повторяется %d раз\n", word, counter);
                }
        }
    }
}
