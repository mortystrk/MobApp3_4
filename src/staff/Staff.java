package staff;

import units.Listener;
import units.Person;
import units.Student;

import java.util.ArrayList;

public class Staff {

    private ArrayList<Person> studlist;

    public Staff(){
        studlist = new ArrayList<>();
    }
    public Staff(int capacity){
        studlist = new ArrayList<>(capacity);
    }
    public Staff(ArrayList<Person> persons){
        studlist = new ArrayList<>(persons);
    }

    public void Add(Person person){
        studlist.add(person);
    }

    public void PrintList(){
        for(Person person : studlist){
            if(person instanceof Student){
                System.out.println(((Student) person).toString());
            }
            else{
                System.out.println(((Listener)person).toString());
            }
        }
    }

}
