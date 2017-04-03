package by.it.korzun.matlab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private String []parseStringToMass(String str){
        String []mass = new String[3];
        Pattern patternExAny = Pattern.compile(Patterns.exAny);
        Matcher matcherExAny = patternExAny.matcher(str);
        if(matcherExAny.find() && matcherExAny.start() == 0){
            mass[0] = str.substring(0, matcherExAny.end());
            mass[1] = str.substring(matcherExAny.end(), matcherExAny.end() + 1);
            mass[2] = str.substring(matcherExAny.end() + 1, str.length());
        }
        return mass;
    }

    private Var compileToVar(String str) {
        Var v;
        if (str.matches(Patterns.exVal)) {
            v = new VarF(str);
        } else if (str.matches(Patterns.exVec)) {
            v = new VarV(str);
        } else if (str.matches(Patterns.exMat)) {
            v = new VarM(str);
        } else
            return null;
        return v;
    }

    void parseString(String str){
        String []mass = parseStringToMass(str);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Var.path + "log.txt", true))) {
            Var a;
            Var b;
            a = compileToVar(mass[0]);
            b = compileToVar(mass[2]);


            switch (mass[1]) {
                case "+": {
                    Var res = a.add(b);
                    System.out.println(res);
                    bw.write(str + " = " + res.toString() + "\n");
                    break;
                }
                case "-": {
                    Var res = a.sub(b);
                    System.out.println(res);
                    bw.write(str + " = " + res.toString() + "\n");
                    break;
                }
                case "*": {
                    Var res = a.mul(b);
                    System.out.println(res);
                    bw.write(str + " = " + res.toString() + "\n");
                    break;
                }
                case "/": {
                    Var res = a.div(b);
                    System.out.println(res);
                    bw.write(str + " = " + res.toString() + "\n");
                    break;
                }
                case "=": {
                    String name = mass[0];
                    b.save(name);
                    break;
                }
            }
        }catch (MathException e){
            new MathException(str + " - неверное выражение");
        }catch (IOException io){

        }

    }
}
