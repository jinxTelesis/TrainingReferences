import java.util.concurrent.*;

public class ExecutorServiceDemo {

    public static void main(String args[]){
        ExecutorService ex = Executors.newFixedThreadPool(2);

        Callable<String> c = () -> "Callable lambda is called";

        Future f1 = ex.submit(c);
        try {
            // getting the future value
            System.out.println("Future f1 " + f1.get());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        ex.shutdown();

//        Future f1 = ex.submit(new Task2());
//        Future f2 = ex.submit(new Task2());
//        try {
//            // getting the future value
//            System.out.println("Future f1 " + f1.get());
//            System.out.println("Future f1 " + f1.get());
//        } catch (InterruptedException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        ex.shutdown();
    }
}

class Task2 implements Runnable{

    @Override
    public void run(){
        System.out.println("in run task for thread - " + Thread.currentThread().getName());
        // Introducing some delay for switching
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
