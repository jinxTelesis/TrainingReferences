import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastModification {

    public static void main(String[] args){
        Map<String,String> cityMap = new HashMap<String,String>();
        cityMap.put("1","New York City");
        cityMap.put("2","New Delhi");
        cityMap.put("3","Newark");

        Iterator<String> itr =cityMap.keySet().iterator();

        while(itr.hasNext()){
            System.out.println(cityMap.get(itr.next()));
            cityMap.put("3","New City");
        }

    }

}
