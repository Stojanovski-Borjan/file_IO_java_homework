package codeacademy.Implementations;

import codeacademy.Animal;
import codeacademy.CreateAndRead_FileIO_Impl;

import java.io.*;
import java.util.Scanner;

public class CreateAndRead_FileIO implements CreateAndRead_FileIO_Impl {

    @Override
    public void userInput(int input) throws IOException {
        if (input == 1) {
            checkIfFileExist(inputFileName(), createAnimal());
            System.out.println("===============");
        } else if (input == 2) {
            listAllFiles();
            System.out.println("===============");
        } else if (input == 3) {
            readFromFile();
            System.out.println("===============");
        } else {
            System.out.println("Invalid Input");
            System.out.println("===============");
        }
    }

    @Override
    public Animal createAnimal() {
        Scanner in = new Scanner(System.in);

        System.out.println("What is it's name?");
        String name = in.nextLine();
        System.out.println("What kind of breed is it?");
        String breed = in.nextLine();
        Animal animal = new Animal(name, breed);
        return animal;
    }

    @Override
    public File inputFileName() {
        Scanner in = new Scanner(System.in);

        System.out.println("What kind of animal do you have?");
        String fileName = in.nextLine();

        File file = new File(fileName.toLowerCase() + ".txt");
        return file;
    }

    @Override
    public void checkIfFileExist(File file, Animal animal) throws IOException {
        if (file.exists()) {
            System.out.println(" ");
            appendAnimalInFile(file, animal);
        } else {
            file.createNewFile();
            appendFirstLineInFile(file);
            appendAnimalInFile(file, animal);
        }

        System.out.println("Thanks for add new animal in our list ");
    }

    @Override
    public void appendFirstLineInFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.write("Name, Breed \n");
        fileWriter.flush();
    }

    @Override
    public void appendAnimalInFile(File file, Animal animal) throws IOException {
        FileWriter fileWriter = new FileWriter(file, true);
        fileWriter.append(animal.getName()).append(", ").append(animal.getBreed()).append("\n");
        fileWriter.flush();
    }

    @Override
    public void readFromFile() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        System.out.println("Which file do you want to read?");
        String fileName = in.nextLine();

        File file = new File(fileName.toLowerCase() + ".txt");
        if (file.exists()) {
            try {
                Scanner myReader = new Scanner(file);
                int count = 0;
                while (myReader.hasNextLine()) {
                    System.out.println(count + ". " + myReader.nextLine());
                    count++;
                }
                if (count > 2) {
                    System.out.println("We have: " + (count - 1) + " " + fileName + "s");
                } else {
                    System.out.println("We have: " + (count - 1) + " " + fileName);

                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        } else {
            System.out.println("That file does not exist!");
        }
    }

    @Override
    public void listAllFiles() throws FileNotFoundException {
        File curDir = new File(".");
        String[] pathnames = curDir.list();
        int count = 0;
        System.out.println("Animals: ");
        for (String pathname : pathnames) {
            if (pathname.endsWith(".txt")) {
                System.out.println(stripExtension(pathname));
                count++;
            }
        }
        System.out.println("Wh have got " + count + " animals" );
    }

    @Override
    public String stripExtension(String pathname) {
        if (pathname == null) {
            return null;
        }
        int pos = pathname.lastIndexOf(".");
        if (pos == -1) {
            return pathname;
        }
        return pathname.substring(0, pos);
    }
}
