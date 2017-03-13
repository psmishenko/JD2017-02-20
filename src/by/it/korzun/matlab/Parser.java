package by.it.korzun.matlab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private Var checkingType(String str){
        Pattern patternArgs = Pattern.compile("[{}]");
        Matcher matcher = patternArgs.matcher(str);
        Var v;
        if(!matcher.find()){
            v = new VarF(str);
        }else if(matcher.find() && matcher.start() == str.length() - 1){
            str = matcher.replaceAll("");
            String []elements = str.split(",");
            v = new VarV(elements);
        }else {
            String []strings = str.split("},\\{");
            for (int i = 0; i < strings.length; i++) {
                matcher = patternArgs.matcher(strings[i]);
                strings[i] = matcher.replaceAll("");
            }
            String [][]matrix = new String[strings.length][];
            for(int i = 0; i < matrix.length; i++){
                String []temp = strings[i].split(",");
                matrix[i] = new String[temp.length];
                System.arraycopy(temp, 0, matrix[i], 0, matrix[0].length);
            }
            v = new VarM(matrix);
        }
        return v;
    }

    void parseString(String str){
        Pattern pattern = Pattern.compile("}[+\\-*/]\\{");
        Matcher matcher = pattern.matcher(str);
        String[] mass;
        if(!matcher.find()) {
            mass = str.split("[+\\-*/]");
            if(str.charAt(0) == '-') {
                mass[0] = mass[1];
                mass[1] = mass[2];
                mass[0] = '-' + mass[0];
            }
        }else {
            mass = str.split("}[+\\-*/]\\{");
        }


        try {
            Var a;
            Var b;
            a = checkingType(mass[0]);
            b = checkingType(mass[1]);

            Pattern patternOperator = Pattern.compile("[+\\-*/]");
            matcher = patternOperator.matcher(str);
            if (matcher.find()) {
                if(matcher.start() == 0) {
                    matcher.find();
                }
                switch (str.charAt(matcher.start())) {
                    case '+': {
                        System.out.println(a.add(b));
                        break;
                    }
                    case '-': {
                        System.out.println(a.sub(b));
                        break;
                    }
                    case '*': {
                        System.out.println(a.mul(b));
                        break;
                    }
                    case '/': {
                        System.out.println(a.div(b));
                        break;
                    }
                }
            }
        }catch (Exception e){
            new Error("Неверное выражение");
        }

    }
}
