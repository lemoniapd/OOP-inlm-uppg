package Sprint2;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.util.*;


public class BestGymEver {

    public final String FILE_PATH = "src/Sprint2/customers.txt";
    public final String OUT_FILE_PATH = "src/Sprint2/PTinfo.txt";


    public boolean test = false;

    String testData = " ";
    private List<Member> memberList = new ArrayList<>();
    private MemberHandler memberHandler = new MemberHandler();

    public BestGymEver(boolean test, String testData) {
        getListFromFile(Path.of(FILE_PATH));
        String input;
        if (!test) {
            while (true) {
                input = JOptionPane.showInputDialog(null, "Skriv in namn eller personnummer: ");
                try {
                    Member member = memberHandler.isMember(input.trim(), memberList);
                    if (member.getName().equals("")) {
                        JOptionPane.showMessageDialog(null, "Ingen medlem med det namnet/personnumret hittad.");
                    } else if (memberHandler.isInactiveMember(member)) {
                        JOptionPane.showMessageDialog(null, member.printMembershipStatus());
                    } else {
                        JOptionPane.showMessageDialog(null, member.printMembershipStatus());
                        memberHandler.workoutForMember(member, Path.of(OUT_FILE_PATH), test);
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
        try (BufferedReader br = new BufferedReader(new FileReader(String.valueOf(p)))) {
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
}