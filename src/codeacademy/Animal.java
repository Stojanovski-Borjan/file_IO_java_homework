package codeacademy;

public class Animal {
    private String name;
    private String breed;

    Animal(){};

    public Animal(String name, String bread) {
        this.name = name;
        this.breed = bread;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                '}';
    }
}
