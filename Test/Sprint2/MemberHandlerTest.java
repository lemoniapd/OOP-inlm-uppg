package Sprint2;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class MemberHandlerTest {

    MemberHandler mH = new MemberHandler();
    BestGymEver bge = new BestGymEver(true, "ABC");
    List<Member> memberListForTests = bge.getListFromFile(Path.of(bge.FILE_PATH));

/*
    @Test
    void memberExistsTest() {
        Member isMember = mH.isMember("Alix Badalix", memberListForTests);
        assertNotNull(isMember);
    }

 */

    @Test
    void memberDoesNotExistTest() {
        Member isMember = mH.isMember(bge.testData, memberListForTests);
        assertEquals("", isMember.getName());
        assertEquals("", isMember.getIDnr());
    }
/*
    @Test
    void isInactiveMemberTest() {
        boolean testIfActive = mH.isMember("Homina Momina");
        assertTrue(testIfActive);
    }

    @Test
    void workoutForMemberTest() {
    }

 */
}