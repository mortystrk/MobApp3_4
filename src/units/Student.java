package units;

import university.University;

public class Student extends Person {

    University university;
    double rating;

    public Student(String name, int age, String university,
                   double rating) {
        super(name, age);
        this.university = University.valueOf(university);
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "class Student";
    }
}
