package Sprint2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BestGymEverTest {

    BestGymEver bge = new BestGymEver(true, "ABC");
    List <Member> memberListTest = new ArrayList<>();

    @Test
    void getListFromFileTest (){
        memberListTest = bge.getListFromFile(Path.of(bge.FILE_PATH));
        assertTrue(memberListTest.get(0).getName().equalsIgnoreCase("Alhambra Aromes"));
        assertTrue(memberListTest.get(0).getIDnr().equalsIgnoreCase("7703021234"));
        assertTrue(memberListTest.get(1).getName().equalsIgnoreCase("Bear Belle"));
        assertTrue(memberListTest.get(1).getIDnr().equalsIgnoreCase("8204021234"));
        assertFalse(memberListTest.get(1).getName().equalsIgnoreCase("Alhambra Aromes")); //tvärtom-test
    }
}
