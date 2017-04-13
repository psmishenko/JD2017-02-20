package by.it.korzun.matlab;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

class MathException extends Exception{
    MathException(String message) {
        System.out.println(message);
        Date date = new Date();
        String timeOut = String.format("%-2d:%-2d:%-2d",date.getHours(),date.getMinutes(),date.getSeconds());
        ConsoleRunner.allAndFullOperations.add(timeOut + " : " + message);
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(Var.path + "log.txt", true))){
            bw.write(message + "\n");
        }catch (IOException ignored){

        }
    }
}
