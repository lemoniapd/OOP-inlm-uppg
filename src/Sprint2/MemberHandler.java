package Sprint2;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import static Sprint2.MembershipStatus.ACTIVE_MEMBER;
import static Sprint2.MembershipStatus.INACTIVE_MEMBER;

public class MemberHandler {

    private final String OUT_FILE_PATH = "src/Sprint2/PTinfo.txt";

    public Member isMember(String input, List<Member> memberList) {
        Member member = new Member("", "");
        for (Member element : memberList) {
            if (element.getName().equalsIgnoreCase(input) || element.getIDnr().equalsIgnoreCase(input)) {
                member.setName(element.getName());
                member.setIDnr(element.getIDnr());
                member.setDateOfLastPayment(String.valueOf(element.getDateOfLastPayment()));
                return member;
            }
        }
        return member;
    }

    public boolean isInactiveMember(Member member) {
        LocalDate expirationDateMembership = member.getDateOfLastPayment().plusYears(1);
        if (expirationDateMembership.isBefore(LocalDate.now())) {
            member.setMembershipStatus(INACTIVE_MEMBER.membershipStatus);
            return true;
        } else {
            member.setMembershipStatus(ACTIVE_MEMBER.membershipStatus);
            return false;
        }
    }

    public void workoutForMember(Member member) {
        int workout = JOptionPane.showConfirmDialog(null, "Ska medlemmen även träna?");
        if (workout == 0) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(OUT_FILE_PATH, true)))) {
                out.println("Medlem " + member.getName() + " " + member.getIDnr() + " tränade " + LocalDate.now());
                JOptionPane.showMessageDialog(null, "Träningspass registrerat!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel när träningspass skulle sparas!");
                e.printStackTrace();
                System.exit(0);
            }
        }
    }
}
