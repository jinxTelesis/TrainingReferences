import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CBExample {

    public static void main(String[] args){

        CyclicBarrier cb = new CyclicBarrier(3);

        Thread t1 = new Thread(new FirstService(cb));
        Thread t2 = new Thread(new SecondService(cb));

        System.out.println("Starting threads ");
        t1.start();
        t2.start();

        try{
            cb.await();
        } catch (InterruptedException e){
            e.printStackTrace();
        } catch (BrokenBarrierException e){
            e.printStackTrace();
        }

        System.out.println("In main thread!");

    }

}

class FirstService implements Runnable{
    CyclicBarrier cb;
    FirstService(CyclicBarrier cb){
        this.cb = cb;
    }
    @Override
    public void run() {
        System.out.println("In First service, thread " + Thread.currentThread().getName());
        try {
            // Calling await for Thread-0
            cb.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class SecondService implements Runnable {
    CyclicBarrier cb;
    SecondService(CyclicBarrier cb){
        this.cb = cb;
    }
    @Override
    public void run() {
        System.out.println("In Second service, thread " + Thread.currentThread().getName());
        try {
            // Calling await for Thread-1
            cb.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
