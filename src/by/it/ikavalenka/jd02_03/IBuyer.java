package by.it.ikavalenka.jd02_03;

interface IBuyer {
    void enterToMarket();
    void chooseGoods();
    void goToOut();
    void goToQueue() throws InterruptedException;
}

