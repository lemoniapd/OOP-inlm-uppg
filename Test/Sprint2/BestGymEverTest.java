package Sprint2;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BestGymEverTest {

    BestGymEver bge = new BestGymEver(true, "ABC");
    List <Member> memberList = new ArrayList<>();

    @Test
    void getListFromFileTest (){
        memberList = bge.getListFromFile(Path.of(bge.FILE_PATH));
        assertTrue(memberList.get(0).getName().equalsIgnoreCase("Alhambra Aromes"));
        assertTrue(memberList.get(0).getIDnr().equalsIgnoreCase("7703021234"));
        assertEquals(memberList.get(0).getDateOfLastPayment(), LocalDate.parse("2022-07-01"));
        assertTrue(memberList.get(1).getName().equalsIgnoreCase("Bear Belle"));
        assertTrue(memberList.get(1).getIDnr().equalsIgnoreCase("8204021234"));
        assertEquals(memberList.get(1).getDateOfLastPayment(), LocalDate.parse("2019-12-02"));
        assertFalse(memberList.get(1).getName().equalsIgnoreCase("Alhambra Aromes")); //tvärtom-test
    }
}
