package staff;

import exception.EduException;
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

    public boolean add(Person person) throws EduException{
        try{
            if(!studlist.add(person)){
                if(person instanceof Student){
                    throw new EduException(true);
                }
                else{
                    throw new EduException(false);
                }
            }
            else {
                return true;
            }
        } catch (EduException e){
            if(e.isFlag()){
                e.toString();
                e.getStudent((Student) person);
                return false;
            }
            else {
                e.toString();
                e.getListener((Listener) person);
                return false;
            }
        }
    }

    

    public void printList(){
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
