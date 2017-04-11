package by.it.loktev.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {

        if (args.length==2) {
            Locale locale = new Locale(args[0], args[1]);
            Language.changeLocale(locale);
        }

        printTestStrings();

        // Язык можно было переключать с клавиатуры командами ru be en.
        System.out.println("\ntry commands: ru be en exit");
        listenCommands();
    }

    public static void printTestStrings(){

        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
        System.out.println(Language.getString(Messages.MYNAME));

        DateFormat df=Language.getDateFormat();
        System.out.println(df.format(new Date()));

    }

    public static void listenCommands(){

        Scanner scanner=new Scanner(System.in);

        while ( true ){
            System.out.print("> ");
            String command = scanner.nextLine();

            if ( command.equals("exit") )
                break;
            else if ( command.equals("ru") ){
                Locale locale = new Locale("ru","RU");
                Language.changeLocale(locale);
                printTestStrings();
            }
            else if ( command.equals("be") ){
                Locale locale = new Locale("be","BY");
                Language.changeLocale(locale);
                printTestStrings();
            }
            else if ( command.equals("en") ){
                Locale locale = new Locale("en","US");
                Language.changeLocale(locale);
                printTestStrings();
            }
            else
                System.out.println("Unknown command");
        }

        System.out.println("Bye-bye!");
    }


}
