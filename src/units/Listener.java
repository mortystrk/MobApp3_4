package units;

import organization.Organization;

public class Listener extends Person {

    private Organization organization;

    public Listener(String name, int age, String organization) {
        super(name, age);
        this.organization = Organization.valueOf(organization);
    }

    public void getInfo(){
        System.out.println("Name: " + this.name + "\nOrganization: " + this.organization
                            + "\nPrice: " + this.organization.getPrice());
    }

    @Override
    public String toString(){
        return "class Listener";
    }
}
