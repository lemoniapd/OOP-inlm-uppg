package Sprint1_OOP.GreenestPlantHotel;

import javax.swing.*;

public class CarnivorousPlant extends Plant implements HeightInMeters { //interface och arv
    private double heightInMeters;
    private NutritionalType nutritionalType = NutritionalType.PROTEINDRINK;

    public CarnivorousPlant(String namn, double heightInMeters) {
        super(namn);
        this.heightInMeters = heightInMeters;
    }

    public double getProteindrinkPerDay() {
        double proteindrinkPerDay = 0.1 + (0.2 * heightInMeters);
        return proteindrinkPerDay;
    }

    public NutritionalType getNutritionalType() {
        return nutritionalType;
    }

    @Override
    public double getHeightInMeters() {
        return heightInMeters;
    }

    @Override
    public void setHeightInMeters(double heightInMeters) {
        this.heightInMeters = heightInMeters;
    }

    @Override
    public void printMe() { //polymorfism
        JOptionPane.showMessageDialog(null, "Köttätande växten " + getName() +
                " är " + heightInMeters + " meter hög och ska därför ha " +
                getProteindrinkPerDay() + " liter " + getNutritionalType().nutritionalType + "/dag. ");
    }
}