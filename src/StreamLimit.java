import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLimit {

    public static void main(String[] args){
        StreamLimit s1 = new StreamLimit();
        List<Integer> numList = Arrays.asList(1,2,3,4,5,6);
        List<Integer> subList = numList.stream().limit(5).collect(Collectors.toList());

        Stream.generate(Math::random)
                .map(n -> (int)(n * 100))
                .limit(10)
                .forEach(System.out::println);
    }

}
