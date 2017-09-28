package units;

import organization.Organization;

public class Listener extends Person {

    private Organization organization;

    public Listener(String name, int age, String organization) {
        super(name, age);
        this.organization = Organization.valueOf(organization);
    }
}
