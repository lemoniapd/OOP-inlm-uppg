package Sprint2;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class BestGymEver {

    String filePath = "src/Sprint2/customers.txt";
    String outFilePathName = "src/Sprint2/PTinfo.txt";

    public boolean test = false;
    private List<Member> memberList = new ArrayList<>();

    public BestGymEver(boolean b) {
        getListFromFile(Path.of(filePath));

        String input = JOptionPane.showInputDialog(null, "Skriv in namn: ");
        isMember(input);

        /*for (Member e: memberList) {
            System.out.println(e.toString());
        }
         */
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

    public boolean isMember (String input){
        if (memberList.contains(input)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isActiveMember (String input){
        LocalDate lastPaymentDate = LocalDate.parse(memberList.get(memberList.indexOf(input)).getDateOfLastPayment());
        Period sinceLastPayment = Period.ofYears(Period.between(LocalDate.now(), lastPaymentDate).getDays());
        if (sinceLastPayment.getDays() <= 365){
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

}