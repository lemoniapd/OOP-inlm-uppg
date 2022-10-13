package Sprint1_OOP.GreenestPlantHotel;

import javax.swing.*;

public class Cactus extends Plant { //interface och arv

    public final double mineralWaterPerDay = 2;

    private NutritionalType nutritionalType = NutritionalType.MINERALWATER;

    public Cactus(String namn) {
        super(namn);
    }

    public NutritionalType getNutritionalType() {
        return nutritionalType;
    }

    @Override
    public void printMe() { //polymorfism
        JOptionPane.showMessageDialog(null, "Kaktusen " + getName() + " ska ha " +
                mineralWaterPerDay + " cl " + getNutritionalType().nutritionalType + "/dag. ");
    }
}
