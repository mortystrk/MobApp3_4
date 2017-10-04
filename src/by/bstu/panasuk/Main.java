package by.bstu.panasuk;

import java.io.IOException;

import exception.EduException;
import manager.IAction;
import manager.Manager;
import org.json.simple.parser.ParseException;
import staff.Staff;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        try {
            IAction mng = new Manager();
            Staff staff = mng.generateCourse(2, 2); // test for MyException
            System.out.println(staff.toString());
            System.out.println("Total money: " + mng.calculationAmountPayments(staff));
            System.out.println("Guys: " + mng.getCountListeners(staff));
            staff = mng.sortStudentsByYaer(staff);
            System.out.println("After sorting by year:");
            System.out.println(staff.toString());
            String filename = "students.json";
            staff = mng.createGroup(filename);
            System.out.println("\nParsed in objects: ");
            System.out.println(staff.toString());
        } catch (EduException exp) {
            System.out.println("Exception cathced: " + exp.getNumber() + " " + exp.getMessage());
        }
    }
}
