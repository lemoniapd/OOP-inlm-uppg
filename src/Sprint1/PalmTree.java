package Sprint1;

import javax.swing.*;

public class PalmTree extends Plant implements HeightInMeters { //interface och arv
    private double heightInMeters;
    private NutritionalType nutritionalType = NutritionalType.TAPWATER;

    public PalmTree(String name, double heightInMeters) {
        super(name);
        this.heightInMeters = heightInMeters;
    }

    public double getWaterPerDay() {
        double waterPerDay = 0.5 * heightInMeters;
        return waterPerDay;
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
        JOptionPane.showMessageDialog(null, "Palmen " + getName() +
                " är " + heightInMeters + " meter hög och ska därför ha " +
                getWaterPerDay() + " liter " + getNutritionalType().nutritionalType + "/dag. ");
    }
}
