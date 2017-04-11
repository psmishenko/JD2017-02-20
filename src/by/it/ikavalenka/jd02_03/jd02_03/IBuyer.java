package by.it.ikavalenka.jd02_03.jd02_03;

interface IBuyer {
    void enterToMarket();
    void chooseGoods();
    void goToQueue() throws InterruptedException;
    void goToOut();
}

