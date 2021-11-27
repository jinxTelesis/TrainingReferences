import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class STEDemo {

    public static void main(String[] args){
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(
                2
        );

        // Callable implemented as lambda
        Callable<String> c = () ->{
            System.out.println("Time of execution- " + new Date());
            return "Callable lambda is called";
        };

        ScheduledFuture<String> sf = scheduledExecutor.schedule(c,2,TimeUnit.SECONDS);

        try {
            System.out.println("Value- " + sf.get());
        } catch (InterruptedException | ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        scheduledExecutor.shutdown();



    }

}
