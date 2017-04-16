package by.it.kolenda.jd02_01;

class Buyer extends Thread implements IBuyer, IUseBasket {

    int num;
    public Buyer(int num){
        this.num = num;
        this.setName("Покупатель № "+ num +" ");
        start();
    }

    @Override
    public void run(){
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        goToOut();
    }
    public String toString() {return this.getName();}

    @Override
    public void enterToMarket() {
        System.out.println(this + "вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        try {
            int pause=Randoming.fromTo(510, 2000);
            Thread.sleep(pause);
        } catch (InterruptedException e){
            System.out.println(this+" //некорректное завершение ожидания");
        }
        System.out.println(this + "выбрал товар");
    }

    @Override
    public void goToOut() {
        System.out.println(this + "вышел из магазина");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + "положил товар в корзину");
    }
}

