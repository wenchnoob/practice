public class ParallelPractice {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Runnable sayHey10 = new MyRunnable();

//                () -> {
//            for (int i = 0; i < 10; i++) System.out.println("hey " + Thread.currentThread().getName());
//        };

        Thread t = new Thread(sayHey10);
        Thread b = new Thread(sayHey10);
        t.start();
        int n = 0;
        while (n < 100) n++;
        b.start();
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) System.out.println("hey " + Thread.currentThread().getName());
        }
    }



}
