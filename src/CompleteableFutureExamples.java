import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class CompleteableFutureExamples {

    public static void main(String... args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(
                () -> {
                    return "Hello";
                }
        ).thenApply(value-> value.toUpperCase(Locale.ROOT));

        System.out.println("Value- " + cf.get());


    }

}
