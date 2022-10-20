package Sprint2;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

class MemberHandlerTest {

    MemberHandler mH = new MemberHandler();
    BestGymEver bge = new BestGymEver(true, "ABC");
    List<Member> memberList = bge.getListFromFile(Path.of(bge.FILE_PATH));


    @Test
    void memberExistsTest() {
        Member isMember = mH.isMember("Ida Idylle", memberList);
        assertEquals("Ida Idylle", isMember.getName());
        assertEquals("8906138493", isMember.getIDnr());
        assertEquals(LocalDate.parse("2018-03-07"), isMember.getDateOfLastPayment());
    }

    @Test
    void memberDoesNotExistTest() {
        Member isMember = mH.isMember(bge.testData, memberList);
        assertEquals("", isMember.getName());
        assertEquals("", isMember.getIDnr());
    }

    @Test
    void inactiveMemberTest() {
        Member member = new Member("Anna Persson", "7602201234");
        member.setDateOfLastPayment("2019-01-02");
        assertTrue(mH.isInactiveMember(member));
    }

    @Test
    void activeMemberTest() {
        Member member = new Member("Anna Persson", "7602201234");
        member.setDateOfLastPayment(LocalDate.now().minusDays(90).toString());
        assertFalse(mH.isInactiveMember(member));
    }

    @Test
    void workoutForMemberTest() throws IOException {
        Member member = new Member("Anna Persson", "7602201234");
        mH.workoutForMember(member, Path.of("Test/Sprint2/PTinfoTest"), true);
        BufferedReader br = new BufferedReader(new FileReader("Test/Sprint2/PTinfoTest"));
        assertEquals(("Medlem 7602201234 Anna Persson tränade "+ LocalDate.now()), br.readLine());
    }
}