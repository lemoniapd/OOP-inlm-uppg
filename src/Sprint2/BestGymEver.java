package Sprint2;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

import static Sprint2.MembershipStatus.*;

public class BestGymEver {

    String filePath = "src/Sprint2/customers.txt";
    String outFilePathName = "src/Sprint2/PTinfo.txt";

    public boolean test = false;
    private List<Member> memberList = new ArrayList<>();

    public BestGymEver(boolean b) {
        getListFromFile(Path.of(filePath));
        while (true) {
            String input = JOptionPane.showInputDialog(null, "Skriv in namn: ");
            try {
                Member member = isMember(input);
                if (isActiveMember(member)) {
                    JOptionPane.showMessageDialog(null, "Aktiv");
                } else if (member != null) {
                    JOptionPane.showMessageDialog(null, "Inaktiv");
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, input + " är inte medlem!");
            }
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
        for (Member element : memberList) {
            if (element.getName().equalsIgnoreCase(input)) {
                return element;
            }
        }
        return null; //TILLFÄLLIG LÖSNING
    }

    public boolean isActiveMember(Member member) {
        LocalDate lastPaymentDate = LocalDate.parse(member.getDateOfLastPayment());
        Period sinceLastPayment = Period.between(LocalDate.now(), lastPaymentDate);
        int passedYears = Math.abs(sinceLastPayment.getYears());
        if (passedYears <= 1) {
            member.setMembershipStatus(ACTIVE_MEMBER.membershipStatus);
            return true;
        } else {
            member.setMembershipStatus(INACTIVE_MEMBER.membershipStatus);
            return false;
        }
    }

    public void workoutForMember(Member member) {
        int workout = JOptionPane.showConfirmDialog(null, "Ska medlemmen även träna?");
        if (workout == 1) {
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFilePathName)))) {
                out.println("Medlem " + member.getName() + " " + member.getIDnr() + " tränade " + LocalDate.now());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Någonting gick fel!");
                e.printStackTrace();
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }
}