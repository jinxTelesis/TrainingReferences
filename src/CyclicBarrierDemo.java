import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args){
        // CyclicBarrier won't block the main thread by default
        CyclicBarrier cb = new CyclicBarrier(3, new AfterAction());

        Thread t1 = new Thread(new TxtReader("thread-1", "file-1", cb));
        Thread t2 = new Thread(new TxtReader("thread-2", "file-2", cb));
        Thread t3 = new Thread(new TxtReader("thread-3", "file-3", cb));
        t1.start();
        t2.start();
        t3.start();

        System.out.println("Done ");
    }

}

class TxtReader implements Runnable{
    private String threadName;
    private String fileName;
    private CyclicBarrier cb;
    TxtReader(String threadName, String fileName, CyclicBarrier cb){
        this.threadName = threadName;
        this.fileName = fileName;
        this.cb = cb;
    }

    @Override
    public void run() {
        System.out.println("Reading file " + fileName + " thread " + threadName);
        try{
            // calling await so the current thread suspends
            cb.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        }
    }
}


class AfterAction implements Runnable{

    @Override
    public void run(){
        System.out.println("In after action class");
    }
}
