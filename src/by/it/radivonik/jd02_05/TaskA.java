package by.it.radivonik.jd02_05;

import java.util.*;

/**
 * Created by Radivonik on 07.04.2017.
 */
public class TaskA {
    public void run(String[] args) {
        if (args.length >= 2)
            Language.changeLocale(new Locale(args[0],args[1]));

        System.out.println(Language.getString(Messages.WELCOME));
        System.out.println(Language.getString(Messages.MYNAME));
        System.out.println(Language.getString(Messages.HOWDOYOUDO));
    }
}
