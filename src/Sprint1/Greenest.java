package Sprint1;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Greenest {

    public List<Plant> createPlants() {
        List<Plant> checkedIn = new ArrayList<>();
        checkedIn.add(0, new Cactus("Igge"));
        checkedIn.add(1, new PalmTree("Laura", 5.0));
        checkedIn.add(2, new CarnivorousPlant("Meatloaf", 0.7));
        checkedIn.add(3, new PalmTree("Putte", 1.0));
        return checkedIn;
    }

    public void printTreatment(List<Plant> listIn) {
        while (true) {
            try {
                String userInput = JOptionPane.showInputDialog(null, "Vilken av växterna vill du veta behandling för? " +
                        "\n\"Avbryt\" för att avbryta programmet. ");
                if (userInput.equalsIgnoreCase("Avbryt")) {
                    break;
                }
                int counter = 0;
                for (Plant element : listIn) {
                    if (userInput.equalsIgnoreCase(element.getName())) {
                        element.printMe();
                        counter++;
                        break;
                    }
                }
                if (counter == 0) {
                    JOptionPane.showMessageDialog(null, userInput + " bor tyvärr inte på Växthotell Greenest just nu! ");
                }
            } catch (NullPointerException e) {
                System.exit(0);
            }
        }
    }
}