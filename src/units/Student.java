package units;

public class Student extends Person {

    double rating;

    public Student(String name, int age, double rating) {
        super(name, age);
        this.rating = rating;
    }

    @Override
    public String toString(){
        return "class Student";
    }
}
