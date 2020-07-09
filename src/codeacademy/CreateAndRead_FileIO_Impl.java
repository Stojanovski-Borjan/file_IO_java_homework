package codeacademy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface CreateAndRead_FileIO_Impl {
    public void userInput(int input) throws IOException;

    public Animal createAnimal();

    public <Fail> Fail inputFileName();

    public void checkIfFileExist(File file, Animal animal) throws IOException;

    public void appendAnimalInFile(File file, Animal animal) throws IOException;

    public void appendFirstLineInFile(File file) throws IOException;

    public void readFromFile() throws FileNotFoundException;

    public void listAllFiles() throws FileNotFoundException;

    public String stripExtension(String pathname);

}
