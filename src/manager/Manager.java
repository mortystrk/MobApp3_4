package manager;

import exception.EduException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import staff.Staff;
import units.Listener;
import units.Student;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Manager implements IAction {

    /**
     * Создание группы участников из файла JSON
     * @param filename путь к JSON файлу
     * @return возвращает группу участников
     */
    @Override
    public Staff createGroup(String filename) {
        Staff staff = new Staff();
        try {
            JSONParser parser = new JSONParser();
            Reader reader = new FileReader(filename);
            Object jsonObj = parser.parse(reader);
            JSONObject jsonObject = (JSONObject) jsonObj;
            System.out.println(jsonObject);
            System.out.println("\nJSON file: ");
            getJsonStudents(staff, jsonObject);
            getJsonListeners(staff, jsonObject);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return staff;
    }

    /**
     * Получение
     * @param staff
     * @param jsonObject
     */

    private void getJsonListeners(Staff staff, JSONObject jsonObject) {
        JSONArray listeners = (JSONArray) jsonObject.get("listeners");
        for (Object listener1 : listeners) {
            JSONObject listener = (JSONObject) listener1;
            String name = (String) listener.get("name");
            long age = (Long) listener.get("age");
            String organization = (String) listener.get("organization");
            System.out.println(name + " " + " " + age + " " + organization);
            staff.add(new Listener(name, (int) age, organization));
        }
    }

    private void getJsonStudents(Staff staff, JSONObject jsonObject) {
        JSONArray students = (JSONArray) jsonObject.get("students");
        for (Object student1 : students) {
            JSONObject student = (JSONObject) student1;
            String name = (String) student.get("name");
            long age = (Long) student.get("age");
            double rating = (Double) student.get("rating");
            System.out.println(name + " " + " " + age + " " + rating);
            staff.add(new Student(name, (int) age, rating));
        }
    }

    @Override
    public Staff generateCourse(int masStudentsCount, int maxListenersCount) throws EduException {
        return null;
    }

    @Override
    public int getCountListeners(Staff someCourse) {
        return 0;
    }

    @Override
    public Staff sortStudentsByYear(Staff someCourse) {
        return null;
    }
}
