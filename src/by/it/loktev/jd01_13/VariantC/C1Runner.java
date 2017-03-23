package by.it.loktev.jd01_13.VariantC;

import java.util.ArrayList;

public class C1Runner {

    public static void test() {

        ElectronicDevice dev1=null;
        Notebook note1=null;
        MobilePhone phone1=null;
        Computer comp1=null;

        try {

            System.out.println();
            dev1 = new ElectronicDevice("тостер Samsung", 1000);
            System.out.println(dev1);

            //Computer comp=new Computer();

            System.out.println();
            note1 = new Notebook("ноутбук Самсунг", 2000, 220);
            System.out.println(note1);
            note1.chargeStart();
            note1.run("c:/program/program.exe");
            note1.pause();
            note1.resume();
            note1.chargeEnd();
            note1.repairBroken(); // статический полимфорфизм
            note1.repairBroken(100); // статический полимфорфизм
            note1.runScreenSaver("c:/program/saver.exe"); // позднее связывание - внутри Computer::runScreenSaver вызывается Notebook::run

            System.out.println();
            phone1 = new MobilePhone("смартфон Sony", 100, true, true);
            System.out.println(phone1);
            phone1.chargeStart();
            phone1.run("//dev//sdcard//tetris");
            phone1.pause();
            phone1.resume();
            phone1.chargeEnd();
            phone1.repairBroken(); // статический полимфорфизм
            phone1.repairBroken(500); // статический полимфорфизм
            phone1.runScreenSaver("//dev//sdcard//saver"); // позднее связывание - внутри Computer::runScreenSaver вызывается MobilePhone::run

            // динамический полиморфизм
            System.out.println();
            comp1 = new MobilePhone("смартфон HTC", 120, true, false);
            System.out.println(comp1);
            comp1.run("//dev//sdcard//digger");
            comp1.pause();
            comp1.resume();
            comp1.repairBroken(); // + статический полимфорфизм
            comp1.repairBroken(300); // + статический полимфорфизм
            comp1.runScreenSaver("//dev//sdcard//saver"); // + позднее связывание - внутри Computer::runScreenSaver вызывается MobilePhone::run

        }
        catch(RunException re){
            System.out.println("##### Словлено исключение: "+re.getMessage());
            System.out.println("##### Класс исключения: "+re.getClass().getName());
            StackTraceElement [] st=re.getStackTrace();
            System.out.println("##### Стек:");
            ArrayList<String> stack=new ArrayList<>();
            for ( StackTraceElement el : st ){
                stack.add("Файл: "+el.getFileName()+", метод: "+el.getMethodName()+", строка: "+el.getLineNumber());
                if (el.getMethodName()=="main")
                    break;
            }
            for ( int i=0; i<stack.size(); i++ ){
                System.out.println("Уровень: "+(stack.size()-i)+" "+stack.get(i));
            }
        }
        finally{
            if ( dev1!=null )
                dev1.switchOff();
            if ( note1!=null )
                note1.switchOff();
            if ( phone1!=null )
                phone1.switchOff();
            if ( comp1!=null )
                comp1.switchOff();
        }

    }

}
