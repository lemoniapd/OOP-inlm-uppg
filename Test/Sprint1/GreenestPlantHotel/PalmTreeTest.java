package Sprint1_OOP.GreenestPlantHotel;

import org.junit.jupiter.api.Test;

class PalmTreeTest {

    PalmTree laura = new PalmTree("Laura", 5.0);

    @Test
    void TestGetHeightInMeters() {
        assert (laura.getHeightInMeters() == 5.0);
        assert (laura.getHeightInMeters() != 2.0); //tvärtom-test
    }

    @Test
    void TestGetWaterPerDay () {
        double expectedValue = 2.5;
        double wrongValue = 0.01;
        assert (laura.getWaterPerDay() == expectedValue);
        assert (laura.getWaterPerDay() != wrongValue); //tvärtom-test
    }
}