package Lesson4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Winner extends Member {

    public Winner(String name, String surname, double miles) {
        this.name = name;
        this.surname = surname;
        this.miles = miles;
    }

    public Winner() {

    }

    public void findWinner(String inputFilePath, String outputFilePath) {
        try (Scanner fread = new Scanner(new FileReader(inputFilePath))) {
            Member[] members = new Member[100];
            String line;

            int j = 0;
            while (fread.hasNext()) {
                line = fread.nextLine();
                line = line.trim();
                String[] items = line.split(",");
                members[j] = new Member();
                members[j].setName(items[0]);
                members[j].setSurname(items[1]);
                members[j].setMiles(Double.parseDouble(items[2]));
                j++;

            }

            double max = 0;
            for (int i = 0; i < j; i++) {
                System.out.println(members[i].getName() + "," + members[i].getSurname() + "," + members[i].getMiles());
                if (members[i].getMiles() > max) {
                    max = members[i].getMiles();
                    name = members[i].getName();
                    surname = members[i].getSurname();
                }
            }

            writeMoreThan70(members, j, max, outputFilePath);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void writeMoreThan70(Member[] members, int count, double maxMiles, String outputFilePath) {
        try {
            FileWriter file = new FileWriter("C:\\Users\\lanke\\IdeaProjects\\HND Software Development\\src\\Lesson4\\MoreThan70%.txt");
            for (int i = 0; i < count; i++) {
                if (members[i].getMiles() > (maxMiles * 0.7)) {
                    String s = members[i].getName() + "," + members[i].getSurname() + "," + members[i].getMiles();
                    file.write(s + "\n");
                }
            }
            file.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getWinner() {
        return name + " " + surname;
    }


}
