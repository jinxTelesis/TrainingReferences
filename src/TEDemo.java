import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TEDemo {

    public static void main(String[] args){
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                3,
                3,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
    }

}

class Task3 implements Runnable{
    @Override
    public void run() {
        System.out.println("in run task for thread - " + Thread.currentThread().getName());
        // Introducing some delay for switching
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
