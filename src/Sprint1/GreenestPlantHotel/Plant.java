package Sprint1_OOP.GreenestPlantHotel;

public abstract class Plant implements PrintMe { //interface
    private String name;

    public Plant(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}