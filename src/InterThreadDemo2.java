import java.util.ArrayList;
import java.util.List;

public class InterThreadDemo2 {

    public static void main(String[] args){

        List<Integer> sharedListObj = new ArrayList<Integer>();

        Thread t1 = new Thread(new Producer(sharedListObj),"Producer");
        Thread t2 = new Thread(new Consumer(sharedListObj),"Consumer");
        t1.start();
        t2.start();
    }

}
