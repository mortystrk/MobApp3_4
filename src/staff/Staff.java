package staff;

import exception.EduException;
import units.Listener;
import units.Person;
import units.Student;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;

/**
 * Создание класса-контейнера
 * @author Igor
 * @version 1.4
 */

public class Staff {

    private CopyOnWriteArrayList<Person> studlist;

    /**
     * Конструкторы класса Staff
     * @see Staff
     */

    public Staff(){
        studlist = new CopyOnWriteArrayList<>();
    }
    public Staff(CopyOnWriteArrayList<Person> persons){
        studlist = new CopyOnWriteArrayList<>(persons);
    }

    /**
     *
     * @return Возвращает список участников курса
     */

    public List<Person> getStudlist() {
        return studlist;
    }
    
    public List<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        for(Person person : studlist){
            if(person instanceof Student){
                students.add((Student) person);
            }
        }
        return students;
    }

    /**
     * Устанавливает список участников курса
     * @param studlist
     */

    public void setStudlist(CopyOnWriteArrayList<Person> studlist){
        this.studlist = studlist;
    }

    public void add (Person item) {
        studlist.add(item);
    }

    public void add(Staff persons){
        for(Person person : persons.getStudlist()){
            studlist.add(person);
        }
    }

    public void remove (Person item)
    {
        studlist.remove(item);
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        for (Person p : studlist)
        {
            result.append(p.toString()).append("\n");
        }
        return result.toString();
    }
}
