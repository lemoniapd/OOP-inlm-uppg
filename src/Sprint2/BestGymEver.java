package Sprint2;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

import static Sprint2.MembershipStatus.*;

public class BestGymEver {

    String filePath = "src/Sprint2/customers.txt";
    String outFilePathName = "src/Sprint2/PTinfo.txt";

    public boolean test = false;

    String testData = " ";
    private List<Member> memberList = new ArrayList<>();

    public BestGymEver(boolean test, String testData) {
        getListFromFile(Path.of(filePath));
        String input;
        if (!test) {
            while (true) {
                input = JOptionPane.showInputDialog(null, "Skriv in namn eller personnummer: ");
                try {
                    Member member = isMember(input.trim());
                    if (member.getName().equals("")) {
                        JOptionPane.showMessageDialog(null, "Ingen medlem med det namnet/personnumret hittad.");
                    } else if (isInactiveMember(member)) {
                        JOptionPane.showMessageDialog(null, member.printMembershipStatus());
                    } else {
                        JOptionPane.showMessageDialog(null, member.printMembershipStatus());
                        workoutForMember(member);
                    }
                } catch (NullPointerException e) {
                    System.exit(0);
                }
            }
        } else {
            input = testData;
        }
    }

    public List<Member> getListFromFile(Path p) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            int memberCounter = 0;
            while ((line = br.readLine()) != null) {
                memberList.add(new Member(line.substring(0, line.indexOf(',')),
                        line.substring(line.indexOf(',') + 2)));

                memberList.get(memberCounter).setDateOfLastPayment(br.readLine().trim());
                memberCounter++;
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Filen finns inte!");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel!");
            e.printStackTrace();
            System.exit(0);
        }
        return memberList;
    }

    public Member isMember(String input) {
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
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFilePathName, true)))) {
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