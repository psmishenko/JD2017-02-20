package by.it.zagursky.jd02_03.src.buyer;

import Rnd.helper;
import interfaces.IBuyer;
import interfaces.IUseBasket;

/**
 * Created by dzenyaa on 29.03.2017.
 */
public class Buyer extends Thread implements IBuyer, IUseBasket {
    Boolean chek_lvl=false;
    private int num;
        private Backet backet;
     public Buyer(int num,boolean chek_lvl)
         {
             super("покупатель №"+num+String.valueOf(chek_lvl));
         this.num=num;
         this.chek_lvl=chek_lvl;


    }

    public Backet getBacket() {
        return backet;
    }

    @Override
    public void run()
    {
        enterToMarket();
        chooseGoods();
        go_to_que();
        goToOut();
    }



    @Override
    public void enterToMarket() {

         System.out.println(this+"вошел в магазин");
    }

    @Override
    public String toString() {
        return getName()+" ";
    }

    @Override
    public void chooseGoods() {
        try {
            Dispetcher.semaphore.acquire();

        this.takeBacket();
        System.out.println(this+"начал выбирать товары");
            this.putGoodsToBacket();
        System.out.println(this+"выбрал товары");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            Dispetcher.semaphore.release();
        }
    }

    @Override
    public void goToOut() {
        System.out.println(this+"вышел из магазина");
        Dispetcher.countcompleateBuyers.getAndAdd(1);
    }

    @Override
    public void go_to_que() {
         System.out.println(this+"встал в очередь");
        que_Buyer.add(this);
        synchronized (this)
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } System.out.println(this+"завершил обслуживание");

     }

    @Override
    public void takeBacket() {
           backet=new Backet(1);
           System.out.println(this+"взял корзинку");
        try {
             if (chek_lvl){sleep(1,5*helper.getRandom(100,200));}else { sleep(helper.getRandom(100,200));}
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }



    @Override
    public int hashCode() {
        return chek_lvl != null ? chek_lvl.hashCode() : 0;
    }

    @Override
    public void putGoodsToBacket() {
        for (int i=0;i<helper.getRandom(1,3);i++)
        {
            try {
                if (chek_lvl){sleep(1,5*helper.getRandom(100,200));}else { sleep(helper.getRandom(100,200));}
            } catch (InterruptedException e) {
                e.printStackTrace();
           }
            Good good=Goods.getRandomGoods();
            backet.put_g(good);

        }


    }
}
