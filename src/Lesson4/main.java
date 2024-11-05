package Lesson4;

import java.util.Scanner;
import java.io.*;

// Azam
//05/11
//Main function of reading and writing club members
public class main {
    public static void main(String[] args) {

        Member mem = new Member();

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name:");
        mem.setName(input.next());
        System.out.println("Enter Surname");
        mem.setSurname(input.next());
        System.out.println("Enter Miles");
        mem.setMiles(input.nextDouble());

        System.out.println("The name is " + mem.getName());
        System.out.println("The surname is " + mem.getSurname());
        System.out.println("The miles is " + mem.getMiles());

        try {
            FileWriter file = new FileWriter("C:\\Users\\lanke\\IdeaProjects\\HND Software Development\\src\\Lesson4\\club.txt");
            String s = mem.getName() + "," + mem.getSurname() + "," + mem.getMiles();
            file.write(s);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Winner winner = new Winner();
        winner.findWinner("C:\\Users\\lanke\\IdeaProjects\\HND Software Development\\src\\Lesson4\\clubread.txt",
                "C:\\Users\\lanke\\IdeaProjects\\HND Software Development\\src\\Lesson4\\MoreThan70%.txt");

        System.out.println("The winner of the furthest distance walked is: " + winner.getWinner());


    }
}