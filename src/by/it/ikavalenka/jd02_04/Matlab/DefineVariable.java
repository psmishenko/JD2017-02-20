package by.it.ikavalenka.jd02_04.Matlab;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefineVariable {

    public static Var defineVar (String s) throws NumberFormatException{

        Map<String, Var> map = MapVariables.getMap();
        for (Map.Entry<String, Var> entry : map.entrySet()) {
            if (s.equalsIgnoreCase(entry.getKey())) return entry.getValue();
        }

        Pattern pat = Pattern.compile(Patterns.vector);
        Matcher mat = pat.matcher(s);
        int lineQuantity = 0;
        while (mat.find()) {
            lineQuantity++;
        }

        mat.reset();

        Creator c;

        if(lineQuantity==0) {
            c = new FloatCreator();
        }
        else{
            if (lineQuantity==1){
                c = new VectorCreator();
            }
            else {
                c = new MatrixCreator();
            }
        }
        return c.create(s, lineQuantity);

    }
}
