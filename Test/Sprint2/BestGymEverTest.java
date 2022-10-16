package Sprint2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BestGymEverTest {

    List <Member> memberListTest = new ArrayList<>();

    BestGymEver bge = new BestGymEver(true);

    @Test
    void getListFromFileTest (){
        memberListTest = bge.getListFromFile(Path.of("Sprint2/customersTest.txt"));
        assertTrue(memberListTest.get(0).getName().equalsIgnoreCase("Alix Badalix"));
        assertTrue(memberListTest.get(0).getIDnr().equalsIgnoreCase("7703021234"));
        assertTrue(memberListTest.get(1).getName().equalsIgnoreCase("Bisou Bisousson"));
        assertTrue(memberListTest.get(1).getIDnr().equalsIgnoreCase("8204021234"));
        assertTrue(memberListTest.get(2).getName().equalsIgnoreCase("Chalix Calliz"));
        assertTrue(memberListTest.get(2).getIDnr().equalsIgnoreCase("8512021234"));
        assertTrue(memberListTest.get(3).getName().equalsIgnoreCase("Homina Momina"));
        assertTrue(memberListTest.get(3).getName().equalsIgnoreCase("4602141234"));
        assertFalse(memberListTest.get(1).getName().equalsIgnoreCase("Alix Badalix")); //tvärtom-test
    }

    @Test
    void isMemberTest () {
        boolean testIfMember = bge.isMember("Alix");
        assertTrue(testIfMember);
    }

    @Test
    void isActiveMemberTest () {
        boolean testIfActive = bge.isMember("Homina Momina");
        assertTrue(testIfActive);
    }

    @Test
    void workoutForMemberTest () {

    }
}
