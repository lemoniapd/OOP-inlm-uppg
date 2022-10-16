package Sprint2;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public BestGymEver() {
        getListFromFile(Path.of(filePath));
        for (Member e: memberList) {
            System.out.println(e.toString());
        }

    }
}