package by.it.loktev.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {

    public static void taskC() {

        StringBuilder sb = new StringBuilder(Data.lukomor);

        // получим строки, посчитаем длину самой длинной
        Pattern linesSplitPattern = Pattern.compile("[\\n]+");
        String [] lines=linesSplitPattern.split(Data.lukomor);

        int maxLength=0;
        for ( int i=0; i<lines.length; i++ ) {
            String line=lines[i];
            //System.out.println("Строка: "+line);
            maxLength=Math.max(maxLength,line.length());
            /*
            String [] phraseWords=phrase.split("[^а-яА-ЯёЁ]+");
            System.out.println("Слов: "+phraseWords.length+", предложение:");
            System.out.println(phrase);
            sortPhrases[i]=String.format("%05d",phraseWords.length)+phrase; // дописываем слева к предложению кол-во слов в нём фиксированной длины - для простоты сортировки, раз уж мы не умеем ничего другого
            */
        }
        System.out.println("Длина самой длинной строки: "+maxLength);

        System.out.println("\n\nТекст, выровненный по ширине:");

        // расставляем пробелы
        Pattern wordsSplitPattern = Pattern.compile(" +");
        for ( int i=0; i<lines.length; i++ ) {
            String line=lines[i];
            //System.out.println("Строка: "+line);
            int leftBlanksToAdd=maxLength-line.length(); // сколько пробелов надо ещё добавить в эту строку
                //System.out.println("Добавляем пробелов: " + leftBlanksToAdd);
                // разобьём строку на слова
                String[] words = wordsSplitPattern.split(line);
                //System.out.println("Слова: " + Arrays.toString(words));
                int leftSpacesToExpand = words.length - 1; // сколько ещё мест для вставки пробелов осталось в этой строке
                String formattedLine = words[0];
                for (int w = 1; w < words.length; w++) {
                    // сколько пробелов надо вставить в это место?
                    int blanksToInsert = (int) Math.round(leftBlanksToAdd / (double) leftSpacesToExpand); // важно именно round, иначе пробелы будут добавляться не так равномерно
                    if ( blanksToInsert>0 ) {
                        formattedLine += String.format("%" + blanksToInsert + "s", "");
                        leftBlanksToAdd -= blanksToInsert;
                    }
                    leftSpacesToExpand--;
                    formattedLine += " " + words[w];
                }
            System.out.println(formattedLine);
        }

        // получаем все слова текста
        Pattern words2SplitPattern = Pattern.compile("[^а-яА-ЯёЁ]+");
        String [] words=words2SplitPattern.split(Data.lukomor);

        System.out.println("\n");
        int lenLimit=1000000;
        int Time1=createRandomStringMethod1(words,lenLimit);
        int Time2=createRandomStringMethod2(words,lenLimit);
        System.out.println("Выигрыш в микросекундах: "+(Time1-Time2)*1000);
        createRandomStringMethod3(words,lenLimit);


    }

    static public int createRandomStringMethod1(String [] words, int lenLimit){
        long methodStart=System.currentTimeMillis();
        String millionS=words[(int)Math.floor(Math.random()*words.length)]; // первое слово сразу впишем, т.к. остальные добавляются иначе - с пробелами перед ними
        while ( true ){
            String word=words[(int)Math.floor(Math.random()*words.length)];
            int newLen=millionS.length()+1+word.length();
            if ( newLen>lenLimit || newLen==lenLimit-1 ) // не допускаем переполнения строки, а также ситуации когда добавить останется только слово длины 0
                continue;
            millionS+=" "+word;
            if ( newLen==lenLimit )
                break;
        }
        long methodEnd=System.currentTimeMillis();
        System.out.println("Длина миллионной строки: "+millionS.length()+" время "+(methodEnd-methodStart)+" мс");
        return (int)(methodEnd-methodStart);
    }

    static public int createRandomStringMethod2(String [] words, int lenLimit){
        long methodStart=System.currentTimeMillis();
        StringBuilder millionSB=new StringBuilder(words[(int)Math.floor(Math.random()*words.length)]);
        while ( true ){
            String word=words[(int)Math.floor(Math.random()*words.length)];
            int newLen=millionSB.length()+1+word.length();
            if ( newLen>lenLimit || newLen==lenLimit-1 ) // не допускаем переполнения строки, а также ситуации когда добавить останется только слово длины 0
                continue;
            millionSB.append(" "+word);
            if ( newLen==lenLimit )
                break;
        }
        long methodEnd=System.currentTimeMillis();
        System.out.println("Длина миллионной строки: "+millionSB.length()+" время "+(methodEnd-methodStart)+" мс");
        return (int)(methodEnd-methodStart);
    }

    static public int createRandomStringMethod3(String [] words, int lenLimit){
        long methodStart=System.currentTimeMillis();
        StringBuilder millionSB=new StringBuilder(words[(int)Math.floor(Math.random()*words.length)]);
        millionSB.ensureCapacity(lenLimit);
        while ( true ){
            String word=words[(int)Math.floor(Math.random()*words.length)];
            int newLen=millionSB.length()+1+word.length();
            if ( newLen>lenLimit || newLen==lenLimit-1 ) // не допускаем переполнения строки, а также ситуации когда добавить останется только слово длины 0
                continue;
            millionSB.append(" "+word);
            if ( newLen==lenLimit )
                break;
        }
        long methodEnd=System.currentTimeMillis();
        System.out.println("Длина миллионной строки: "+millionSB.length()+" время "+(methodEnd-methodStart)+" мс");
        return (int)(methodEnd-methodStart);
    }

}
