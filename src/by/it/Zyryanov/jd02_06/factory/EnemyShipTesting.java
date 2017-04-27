package by.it.Zyryanov.jd02_06.factory;


import java.util.Scanner;

public class EnemyShipTesting {
    public static void main(String[] args) {

        EnemyShipFactory shipFactory = new EnemyShipFactory();
        EnemyShip theEnemy = null;
        Scanner scanner = new Scanner(System.in);

        System.out.println("What type of ship? (U / R / B)");

        if (scanner.hasNextLine()){

            String typeOfShip = scanner.nextLine();

            theEnemy = shipFactory.makeEnemyShip(typeOfShip);

        }

        if (theEnemy != null){
            doStuffEnemy(theEnemy);
        }
    }

    public static void doStuffEnemy(EnemyShip anEnemyShip){

        anEnemyShip.displayEnemyShip();
        anEnemyShip.followHeroShip();
        anEnemyShip.enemyShipShoots();
    }
}
