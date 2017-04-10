package by.it.kolenda.jd02_01;

public class TaskA {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(this.getName() + "Cycle №" + i);
                try {
                    sleep((int) (Math.random() * 1000));
                    yield();
                } catch (InterruptedException e) {
                    System.err.print(e);
                }
            }
        }

        public MyThread(String name) {
            super(name);
        }
    }
}