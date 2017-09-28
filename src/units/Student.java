package units;

public class Student extends Person {

    String university;
    double rating;
    int group;

    public Student(String name, int age, String university,
                   double rating, int group) {
        super(name, age);
        this.university = university;
        this.rating = rating;
        this.group = group;
    }
}
