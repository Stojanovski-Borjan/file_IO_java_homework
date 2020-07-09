package codeacademy;

import codeacademy.Implementations.CreateAndRead_FileIO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int n;
        System.out.println("===============");
        System.out.println("1 -> Add your animal in our ZOO list.");
        System.out.println("2 -> See what kind of animals we have ");
        System.out.println("3 -> See name and breed of some kind of animal");
        System.out.println("===============");
        Scanner input = new Scanner(System.in);
        CreateAndRead_FileIO_Impl crf = new CreateAndRead_FileIO();
        while ((n = input.nextInt()) != 0) {
            crf.userInput(n);
        }
    }
}
