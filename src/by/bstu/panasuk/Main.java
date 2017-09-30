package by.bstu.panasuk;

import staff.Staff;
import units.Listener;
import units.Person;
import units.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

       /* String path = new File("").getAbsolutePath();
        System.out.println(path);
        File file = new File(path+ "//units.json");
        file.createNewFile();*/
	// write your code here
        ArrayList<Person> persons = new ArrayList<>();

        Student stud1 = new Student("Igor", 21, "BSU", 15, 7);
        Student stud2 = new Student("Oleg", 20, "BSU", 18, 7);
        Student stud3 = new Student("Olya", 20, "BSU", 24, 7);
        Listener listener = new Listener("Bill", 34, "ITclub");
        persons.add(stud1);
        persons.add(stud2);
        persons.add(listener);
        persons.add(stud3);

        Staff staff = new Staff(persons);
        staff.PrintList();
    }
}
