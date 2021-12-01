import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceDemo {

    public static void main(String[] args){
        List<Employee> empList = createList();

        // Using reduce method which returns Optional object
        Optional<Employee> result = empList.stream().reduce(
                (e1,e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2);
        if (result.isPresent()) {
            System.out.println("Employee with max salary - " +
                    result.get().getFirstName()
            + " salary " + result.get().getSalary()
            );
        }


    }

    private static List createList(){
        List<Employee> empList = new ArrayList<Employee>();
        Employee emp = new Employee();
        emp.setEmpId("E001");
        emp.setAge(40);
        emp.setFirstName("Ram");
        emp.setLastName("Chandra");
        emp.setSalary(5000);
        empList.add(emp);
        emp = new Employee();
        emp.setEmpId("E002");
        emp.setAge(35);
        emp.setFirstName("Sheila");
        emp.setLastName("Baijal");
        emp.setSalary(7000);
        empList.add(emp);
        emp = new Employee();
        emp.setEmpId("E003");
        emp.setAge(24);
        emp.setFirstName("Mukesh");
        emp.setLastName("Rishi");
        emp.setSalary(9000);
        empList.add(emp);
        return empList;
    }

}
