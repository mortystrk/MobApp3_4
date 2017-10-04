package manager;

import exception.EduException;
import staff.Staff;
import units.Listener;
import units.Person;

public interface IAction {

    Staff createGroup(String filename);
    Staff generateCourse(int masStudentsCount, int maxListenersCount) throws EduException;

    /**
     * Реализация метода интерфейса по умолчанию
     * @param someCourse курс, содержащи участников
     * @return общая сумма за прослушивание курса
     */

    default int calculationAmountPayments(Staff someCourse) {
        int totalPayment = 0;
        for(Person person : someCourse.getStudlist()){
            if(person instanceof Listener){
                totalPayment += ((Listener) person).getPrice();
            }
        };
        return totalPayment;
    }

    int getCountListeners(Staff someCourse);
    Staff sortStudentsByYaer(Staff someCourse);
}
