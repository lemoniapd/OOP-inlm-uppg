package Sprint2;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.*;

public class BestGymEver {

    String filePath = "src/Sprint2/customers.txt";
    String outFilePathName = "src/Sprint2/PTinfo.txt";

    public boolean test = false;
    private List<Member> memberList = new ArrayList<>();

    public List<Member> getListFromFile(Path p) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int memberCounter = 0;
            while ((line = br.readLine()) != null) {
                line = br.readLine();
                memberList.add(new Member(line.substring(0, line.indexOf(',')),
                        line.substring(line.indexOf(',') + 1)));
                line = br.readLine().trim();
                memberList.get(memberCounter).setDateOfLastPayment(br.readLine());
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

    public boolean isMember (String input){
        if (memberList.contains(input)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isActiveMember (String input){
        LocalDate lastPaymentDate = LocalDate.parse(memberList.get(memberList.indexOf(input)).getDateOfLastPayment());
        if (lastPaymentDate.compareTo(LocalDate.now()) <= 365){
            return true;
        } else {
            return false;
        }
    }

    public void workoutForMember (Member member){
        int workout = JOptionPane.showConfirmDialog(null, "Ska medlemmen även träna?");
        if (workout == 1){
            try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outFilePathName)))){
                out.println("Medlem " + member.getName() + " " + member.getIDnr() + " tränade " + LocalDate.now());
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Någonting gick fel!");
                e.printStackTrace();
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    public BestGymEver(boolean b) {
        getListFromFile(Path.of(filePath));
        for (Member e: memberList) {
            System.out.println(e.toString());
        }
    }
}