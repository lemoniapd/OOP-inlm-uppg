package Sprint1;

import org.junit.jupiter.api.Test;

class CactusTest {

    Cactus igge = new Cactus("Igge");

    @Test
    void TestGetName() {
        assert(igge.getName() == "Igge");
        assert(igge.getName() != "Laura"); //tvärtom-test
    }
}