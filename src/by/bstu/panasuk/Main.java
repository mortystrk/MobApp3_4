package by.bstu.panasuk;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String path = new File("").getAbsolutePath();
        System.out.println(path);
        File file = new File(path+ "//units.json");
        file.createNewFile();
	// write your code here
    }
}
