package organization;

public enum Organization {
    MegaTech(1000), UltraLine(850), ITclub(1200);

    private int price;

    Organization(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
