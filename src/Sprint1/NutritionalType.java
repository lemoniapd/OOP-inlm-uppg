package Sprint1;

public enum NutritionalType {
    TAPWATER("kranvatten"),
    MINERALWATER("mineralvatten"),
    PROTEINDRINK("proteindryck");

    public final String nutritionalType;

    NutritionalType(String n) {
        this.nutritionalType = n;
    }
}
