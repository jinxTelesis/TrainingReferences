import java.io.Serializable;
import java.util.Date;

public class Person2 implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private Date dob;
    // transient
    private transient int age;
    private Address address;
    // Constructor
    Person2(String name, Date dob, int age, Address address){
        System.out.println("In Constructor with args");
        this.name = name;
        this.dob = dob;
        this.age = age;
        this.address = address;
    }
    // no-arg Constructor
    Person2(){
        System.out.println("no-arg constructor");
    }

    public Address getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public Date getDob() {
        return dob;
    }

    public int getAge() {
        return age;
    }
}
