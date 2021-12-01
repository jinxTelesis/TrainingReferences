class LoopValues implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " Priority is " + Thread.currentThread().getPriority());
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

public class ThreadPriorityDemo {

    public static void main(String[] args){
        Thread thread1 = new Thread(new LoopValues(), "Thread-1");
        Thread thread2 = new Thread(new LoopValues(), "Thread-2");

        thread1.start();
        thread2.start();
        try{
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with looping values");
    }

}
