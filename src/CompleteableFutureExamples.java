import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class CompleteableFutureExamples {

    public static void main(String... args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(
                () -> {
                    return "Hello";
                }
        ).thenCompose(
                value ->{
                    String str = value.toUpperCase(Locale.ROOT);
                    return CompletableFuture.completedFuture(str);
                }
        );
        System.out.println("value- " + cf.get());

        //thenCombine used to preform logic on
        //two combined completeableFutures

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(
                () -> {
                    return "Combining two CompletableFutures";
                }
        );

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(
                () -> {
                    return "and getting a new CompletableFuture";
                }
        );

        CompletableFuture<String> result = future1.thenCombine(
                future2,(str1,str2) -> str1 + " " + str2
        );
        System.out.println("Value- " + result.get());
    }

}
