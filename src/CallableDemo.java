import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String args[]){
        ExecutorService es = Executors.newFixedThreadPool(4);

        Future<String> f1 = es.submit(new MyCallable("callable"));
        Future<String> f2 = es.submit(new MyCallable("future"));
        Future<String> f3 = es.submit(new MyCallable("executor"));
        Future<String> f4 = es.submit(new MyCallable("executor service"));
        Future<String> f5 = es.submit(new MyCallable("executors"));
        Future<String> f6 = es.submit(new MyCallable("scheduled executor"));
     }

    public static void tempMethod(){
        System.out.println("I am in temp method");
    }


}

class MyCallable implements Callable<String>{
    String str;
    MyCallable(String str){
        this.str = str;
    }

    @Override
    public String call() throws Exception{
        StringBuffer sb = new StringBuffer();
        return (sb.append("Length of string ")
                .append(str)
                .append(" is ")
                .append(str.length())).toString();
    }
}
