package by.it.loktev.jd02_03;

public class Runner {

    public static void main(String[] args)  {

        // работает ровно минуту + обслуживание уже вошедших

        Shop.opened.getAndSet(true);
        Shop.buyersCount.getAndSet(0);
        Shop.totalPrice2=0;
        System.out.println("=== магазин открыт");

        Dispatcher dispatcher=new Dispatcher();
        dispatcher.start();

        //Thread cashierThread=null;

        int buyerNum=0;
        long startTime=System.currentTimeMillis();
        while (true)
        {
            double secondNum=Math.floor((System.currentTimeMillis()-startTime)/1000.0); // номер секунды в минуте
            if ( secondNum>5 ) // работаем только минуту
                break;
            double centerDiff=Math.abs(secondNum-30); // 30...0...30 в течение минуты
            double averInterval=centerDiff*10+100; // 100-400 в зависимости от секунды

            //System.out.println("Покупатель "+buyerNum+" средний интервал "+averInterval); // для отладки интервала

            Helper.sleep(Helper.getRandom((int)(averInterval*0.8),(int)(averInterval*1.2))); // интервал между покупателями

            buyerNum++;
            Buyer b=new Buyer(buyerNum);
            b.start();


            //if (secondNum>=1)
            //    break;
        }

        System.out.println("=== закрываем вход, новых покупателей не впускаем");

        while ( Shop.buyersCount.get()>0 ){
            Helper.sleep(100);
        }

        //dispatcher.interrupt();

        System.out.println("=== магазин закрыт, обслужено "+buyerNum+" покупателей, выручка "+Shop.totalPrice2+" руб");
        Shop.opened.getAndSet(false);

    }

}
