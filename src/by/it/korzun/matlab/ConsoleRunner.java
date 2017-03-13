package by.it.korzun.matlab;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        System.out.println("Введите выражение(или 0 чтобы выйти): ");
        while (true){
            String str = scanner.nextLine();
            if(str.equals("0")){
                scanner.close();
                break;
            }
            parser.parseString(str);

        }

    }
}
