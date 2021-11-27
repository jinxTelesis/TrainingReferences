import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableLambda {

    public static void main(String args[]){
        ExecutorService es = Executors.newFixedThreadPool(4);
        getLength(es, "executor");
        getLength(es, "executor service");
        getLength(es,"Scheduled exector service");
        getLength(es,"executors");
        getLength(es,"fork join");
        getLength(es,"callable");

    }
    // Unchecked Exceptions are not verified at compile time
    // thus unchecked.

    // Executors, ExecutorService, Scheduled Exectuors

    // Thread pools ThreadPoolExecutor, ScheduledThreadPoolExecutor

    // Fork/join A framework from JDK 7



    public static void getLength(ExecutorService es, String str){
        Future<String> f = es.submit(() -> {return str + str.length();});
        try {
            System.out.println("" + f.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
