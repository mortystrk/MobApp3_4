package exception;

/**
 * Создание собственного класса исключений
 */

public class EduException extends Exception {

    private int number;

    public int getNumber(){
        return number;
    }

    public EduException(String message, int number){
        super(message);
        this.number = number;
    }


}
