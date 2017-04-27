package by.it.Zyryanov.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        sb.append(Data.lukomor);

        Pattern spaceFinder = Pattern.compile("[\\s]");
        Matcher matcher = spaceFinder.matcher(sb);


        for (int i = 0; i < sb.length(); i++) {
        }

    }
}
