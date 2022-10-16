package Sprint2;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class BestGymEver {

    String filePath = "src/Sprint2/customers.txt";
    String outFilePathName = "src/Sprint2/PTinfo.txt";

    public boolean test = false;
    private List <Member> memberList = new ArrayList<>();

    public List<Member> getListFromFile (Path p){
        try (BufferedReader input = new BufferedReader(new FileReader(String.valueOf(p)))){
            int counter = 0;
            while (true) {
                String newLine = input.readLine().trim();
                memberList.add(new Member(newLine.substring(0, newLine.indexOf(',')),
                        newLine.substring(newLine.indexOf(',') +1)));
                System.out.println(memberList.get(0).getName());
                if (newLine == null) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Filen finns inte!");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Någonting gick fel!");
            e.printStackTrace();
            System.exit(0);
        }
        return memberList;
    }

    public static String[] createArray() throws IndexOutOfBoundsException, FileNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new FileReader("Dice throws.txt"));
        List<String> inputList = new ArrayList<String>();
        while (true) {
            String newLine = input.readLine();
            if (newLine == null) {
                break;
            }
            inputList.add(newLine);
        }
        String[] arrayContainingAllThrows = inputList.toArray(new String[1000]);
        return arrayContainingAllThrows;
    }

    public BestGymEver (){
        getListFromFile(Path.of(filePath));
    }
}
