package by.it.psmishenko.jd01_6;


import java.io.IOException;


public class Runner {
    public static void main(String[] args) throws IOException {
        StringBuilder sb1 = new StringBuilder(Data.lukomor);
        // Task A
        TaskA.replaceSymbols(sb1);//#1
        TaskA.numberOfRep();//#2
        // Task B
        StringBuilder sb2 = new StringBuilder(Data.lukomor);
        TaskB.firstAndLastVowel(sb2);// #3
        TaskB.newPosition(sb2);//#4
        // Task C
        StringBuilder sb3 = new StringBuilder(Data.lukomor);
        TaskC.alignmentLines(sb3);//#5
    }
}