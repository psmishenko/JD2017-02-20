package by.it.korzun.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Hello{
    private static void messageOut(){
        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
        System.out.println(Language.getString(Messages.MYNAME));
    }

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        if(args.length == 2) {
            Locale locale = new Locale(args[0], args[1]);
            Language.changeLocale(locale);
        }

        messageOut();

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, Language.getLocale());
        String sDate = dateFormat.format(date);

        System.out.println(sDate);

        Scanner scanner = new Scanner(System.in);
        String command;
        while (true){
            System.out.println("Введите en | ru | be:");
            command = scanner.nextLine();
            switch (command){
                case "en":{
                    Language.changeLocale(Locale.ENGLISH);
                    messageOut();
                    break;
                }case "ru":{
                    Language.changeLocale(new Locale(command, "RU"));
                    messageOut();
                    break;
                }case "be":{
                    Language.changeLocale(new Locale(command, "BY"));
                    messageOut();
                    break;
                }
            }
        }

    }
}
