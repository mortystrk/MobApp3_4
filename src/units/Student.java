package units;

import university.University;

public class Student extends Person {

    University university;
    double rating;
    int group;

    public Student(String name, int age, String university,
                   double rating, int group) {
        super(name, age);
        this.university = University.valueOf(university);
        this.rating = rating;
        this.group = group;
    }

    @Override
    public String toString(){
        return "class Student";
    }
}
