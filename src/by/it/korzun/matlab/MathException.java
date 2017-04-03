package by.it.korzun.matlab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class MathException extends Exception{
    //private List<String> errors = new ArrayList<>();

    MathException(String message) {
        System.out.println(message);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Var.path + "log.txt", true))){
            bw.write(message + "\n");
        }catch (IOException e){

        }
    }
}
