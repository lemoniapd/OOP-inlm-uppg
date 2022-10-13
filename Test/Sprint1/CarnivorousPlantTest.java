package Sprint1;

import org.junit.jupiter.api.Test;

class CarnivorousPlantTest {

    CarnivorousPlant meatLoaf = new CarnivorousPlant("Meatloaf", 0.7);

    @Test
    void TestProteindrinkPerDay() {
        double expectedValue = 0.24;
        double wrongValue = 0.1;
        assert (meatLoaf.getProteindrinkPerDay() == expectedValue);
        assert (meatLoaf.getProteindrinkPerDay() != wrongValue); //tvärtom-test
    }
}