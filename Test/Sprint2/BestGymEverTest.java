package Sprint2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BestGymEverTest {

    List <Member> memberListTest = new ArrayList<>();

    BestGymEver bge = new BestGymEver(true, memberListTest);

    @Test
    void getListFromFileTest (List<Member> memberListTest){
        assert (memberListTest.get(0) == "7703021234, Alix Badalix");
        assert (memberListTest.get(1) == "8204021234, Bisou Bisousson");
        assert (memberListTest.get(2) == "8512021234, Chalix Calliz");
        assert !(memberListTest.get(1) == "7703021234, Alix Badalix"); //tvärtom-test
    }

    @Test
    void getMembershipInformation (){

    }
}
