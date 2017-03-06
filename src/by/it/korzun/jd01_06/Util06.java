package by.it.korzun.jd01_06;


public class Util06 {
    static String[] sort(String[] lines){
        int[] massWordsCount = new int[lines.length];
        String[] words;
        for (int i = 0; i < lines.length; i++) {
            words = lines[i].split("[\\s:,(\\s-\\s)]");
            int wordsCount = 0;
            for (int j = 0; j < words.length; j++) {
                if(!words[j].equals("")){
                    wordsCount++;
                }
            }
            massWordsCount[i] = wordsCount;
        }

        boolean swap;
        int last = lines.length - 1;
        do{
            swap = false;
            for (int i = 0; i < last; i++) {
                if(massWordsCount[i] > massWordsCount[i + 1]){
                    int buffCount = massWordsCount[i];
                    String buff = lines[i];
                    massWordsCount[i] = massWordsCount[i + 1];
                    lines[i] = lines[i+1];
                    massWordsCount[i + 1] = buffCount;
                    lines[i+1] = buff;
                    swap = true;
                }
            }
            last--;
        }while (swap);
        return lines;
    }
}
