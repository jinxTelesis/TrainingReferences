import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorDemo {

    public static void main(String args[]){
        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.execute(new Task());
        ex.execute(new Task());
        ex.execute(new Task());
        ex.execute(new Task());

        ex.shutdown();
    }

}

class Task implements Runnable{
    @Override
    public void run() {
        System.out.println("in run task for thread - " + Thread.currentThread().getName());
        // Introducing some delay for switching
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}