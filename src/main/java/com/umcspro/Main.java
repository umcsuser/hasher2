package com.umcspro;

import com.umcspro.hasher2.Hasher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
//add some changes...
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Utworz haslo:");
        String hashed = Hasher.hashPassword(sc.nextLine());
        System.out.println(hashed);

        try{
            PrintWriter pw = new PrintWriter("hashed.txt");
            pw.println(hashed);
            pw.close();
            Scanner scan = new Scanner(new File("hashed.txt"));
            System.out.println("Podaj swoje haslo:");
            if (Hasher.hashPassword(sc.nextLine()).equals(scan.nextLine())) {
                System.out.println("HASLO POPRAWNE!");
            }else{
                System.out.println("HASLO BLEDNE!");
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}