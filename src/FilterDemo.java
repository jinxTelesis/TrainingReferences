import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {

    public static void main(String[] args){
        List<String> nameList = Arrays.asList("Ram","Amit","Ashok","Manish");
        List<String> filteredList = nameList.stream()
                .filter(n -> !n.startsWith("A"))
                .collect(Collectors.toList());


    }

}
