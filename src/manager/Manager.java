package manager;

import exception.EduException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import random.RandomPersons;
import staff.Staff;
import units.Listener;
import units.Person;
import units.Student;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Comparator;

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
     * Получение списка слушателей из файла JSON
     * @param staff курс, содержащий участников
     * @param jsonObject объект JSON
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

    /**
     * Получение списка студентов из файла JSON
     * @param staff курс, содержащий участников
     * @param jsonObject объект JSON
     */

    private void getJsonStudents(Staff staff, JSONObject jsonObject) {
        JSONArray students = (JSONArray) jsonObject.get("students");
        for (Object student1 : students) {
            JSONObject student = (JSONObject) student1;
            String name = (String) student.get("name");
            long age = (Long) student.get("age");
            long rating = (Long) student.get("rating");
            System.out.println(name + " " + " " + age + " " + rating);
            staff.add(new Student(name, (int) age, rating));
        }
    }

    /**
     * Генерация курса
     * @param maxStudentsCount максимальное число студентов
     * @param maxListenersCount максимальное число слушателей
     * @return курс участников
     * @throws EduException работа EduException
     */
    @Override
    public Staff generateCourse(int maxStudentsCount, int maxListenersCount) throws EduException {

        if(maxStudentsCount < 0 || maxListenersCount < 0){
            throw new EduException("EduException in generateCourse", 1);
        }

        Staff staff = new Staff();
        for (int i = 0; i < maxStudentsCount; i++) {
            staff.add(RandomPersons.randomStudent());
        }
        for (int i = 0; i < maxListenersCount; i++) {
            staff.add((RandomPersons.randomListener()));
        }

        return staff;
    }

    /**
     * @param someCourse курс, содержащий участников
     * @return количество слушателей курса
     */
    @Override
    public int getCountListeners(Staff someCourse) {
        return someCourse.getStudlist().size();
    }

    @Override
    public Staff sortStudentsByYaer(Staff someCourse) {
        someCourse.getStudlist().sort(Comparator.comparingInt(Person::getAge));
        return someCourse;
    }
}
