package exception;

import units.Listener;
import units.Person;
import units.Student;

public class EduException extends Exception {

    boolean flag;

    public EduException(boolean flag){
        this.flag = flag;
    }

    public void getStudent(Student student){
        student.getInfo();
    }

    public void getListener(Listener listener){
        listener.getInfo();
    }

    public boolean isFlag() {
        return flag;
    }

    public String toString(){
        return "Невозможно добавить участника курса";
    }
}
