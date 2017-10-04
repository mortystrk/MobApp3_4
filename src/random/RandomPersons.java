package random;

import com.sun.istack.internal.NotNull;
import functional.IRandomAge;
import functional.IRandomName;
import functional.IRandomOrganization;
import functional.IRandomRating;
import organization.Organization;
import units.Listener;
import units.Student;

import java.util.Random;

public class RandomPersons {

    private static final Random random = new Random();
    private static String [] names = {"Ivan", "Igor", "Oleg", "Bob", "Nastya", "Maksim", "Dima", "Kristina"};

    public RandomPersons(){}

    @NotNull
    public static Listener randomListener(){
        return new Listener(randName(), randAge(), randOrganization().toString());
    }

    @NotNull
    public static Student randomStudent(){
        return new Student(randName(), randAge(), randRating());
    }

    private static int randAge(){
        IRandomAge rand = () -> random.nextInt(18) + 18;
        return rand.randomAge();
    }

    private static String randName(){
        IRandomName rand = () -> names[random.nextInt(names.length)];
        return rand.randomName();
    }

    private static double randRating(){
        final double[] rating = {0};
        IRandomRating rand = () -> rating[0] = Math.round(((Math.random() * 6) + 4) * 10) / 10;
        return rand.randomRating();
    }

    private static Organization randOrganization(){
        int size = Organization.values().length;
        IRandomOrganization rand = () -> Organization.getORGANIZATIONS().get(random.nextInt(size));
        return rand.randOrganization();

    }
}
