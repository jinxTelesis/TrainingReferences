import java.util.ArrayList;
import java.util.List;

interface IMyStringFunc<T,R>{
    R stringFunc(T t);
}

@FunctionalInterface
interface IMyFunc {
    Person getRef(String firstName, String lastName, int age, char gender);
}


public class MethodRefDemo {

    public static void main(String[] args){
        List<Person> personList = createList();
        List allNames = MethodRefDemo.listAllNames(personList,Person::getFirstName);
        List allNames2 = MethodRefDemo.listAllNames(personList,Person::getLastName);
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

    private static List<String> listAllNames(List<Person> person, IMyStringFunc<Person, String> func){
        List<String> result = new ArrayList<String>();
        person.forEach(x -> result.add(func.stringFunc(x)));
        return result;
    }

}
