import java.util.ArrayList;
import java.util.List;

public class LambdaDemo2 {

    public static void main(String[] args){
        List<Person> personList = createList();
        System.out.println("Name - " + personList.get(0).getLastName());
    }

    private static List<Person> createList(){
        List<Person> tempList = new ArrayList<Person>();
        IMyFunc createObj = Person::new;
        Person person = createObj.getRef("Ram","Tiwari", 50, 'M');
        tempList.add(person);
        person = createObj.getRef("Prem", "Chopra", 13, 'M');
        tempList.add(person);
        person = createObj.getRef("Tanuja", "Trivedi", 30, 'F');
        tempList.add(person);
        person = createObj.getRef("Manoj", "Sharma", 40, 'M');
        tempList.add(person);
        person = createObj.getRef("John", "Trevor", 70, 'M');
        tempList.add(person);
        person = createObj.getRef("Alicia", "Sliver", 17, 'F');
        tempList.add(person);
        System.out.println("List elements are - ");
        System.out.println(tempList);
        return tempList;
    }
}
