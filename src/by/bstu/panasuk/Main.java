package by.bstu.panasuk;

import staff.Staff;
import units.Listener;
import units.Person;
import units.Student;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

      
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("students.json");
        Object jsonObj = parser.parse(reader);
        JSONObject jsonObject = (JSONObject) jsonObj;
        JSONArray students = (JSONArray) jsonObject.get("students");
        for (Object student1 : students) {
            JSONObject student = (JSONObject) student1;
            String name = (String) student.get("name");
            Long age = (Long) student.get("age");
            Long rating = (Long) student.get("rating");
            System.out.println(name + " " + " " + age + " " + rating);
        }

    }
}
