package organization;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Organization {
    MegaTech(1000), UltraLine(850), ITclub(1200);

    private int price;
    private static final List<Organization> ORGANIZATIONS =
            Collections.unmodifiableList(Arrays.asList(values()));

    Organization(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
    public static List<Organization> getORGANIZATIONS(){
        return ORGANIZATIONS;
    }
}
