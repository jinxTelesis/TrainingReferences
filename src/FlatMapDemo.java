import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMapDemo {


    public static void main(String[] args){

        List<Order> orderList = getOrderList();
        System.out.println("Item count with Map " + orderList.stream().map(
                order -> order.getItems().stream().count()
        ));

        System.out.println("Item count with FlatMap " + orderList.stream()
        .flatMap(order -> order.getItems().stream()).count());


        int[][] numArray = {{1,2},{3,4},{5,6}};
        Stream<int[]> numStream = Stream.of(numArray);
        IntStream iStream = Stream.of(numArray).flatMapToInt(n -> Arrays.stream(n));


    }

    private static List<Order> getOrderList(){
        List<Order> orderList = new ArrayList<Order>();
        Order order = new Order();
        order.setOrderId("1");
        order.setItems(Arrays.asList("Item1", "Item2", "Item3"));
        orderList.add(order);
        order = new Order();
        order.setOrderId("2");
        order.setItems(Arrays.asList("Item3", "Item5"));
        orderList.add(order);
        return orderList;
    }

}
