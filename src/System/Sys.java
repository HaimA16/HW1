package System;
import java.util.Scanner;

import Animals.AirAnimal;
import Animals.Animal;
import Animals.Gender;
import Animals.Snake;
import Animals.TerrestrialAnimals;
import Animals.Dog;
import Animals.Cat;
import Animals.WaterAnimal;
import Animals.Alligator;
import Animals.Whale;
import Animals.Dolphin;
import Mobility.Point;
import Olympics.Medal;

public class Sys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of animals: ");
        int size = sc.nextInt();
        Animal[] animals = new Animal[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Enter animal name: ");
            String name = sc.next();
            System.out.print("Enter animal gender (Male, Female, Hermaphrodite): ");
            String genderStr = sc.next();
            Gender gender = Gender.valueOf(genderStr.toUpperCase());
            System.out.print("Enter animal weight: ");
            double weight = sc.nextDouble();
            System.out.print("Enter animal speed: ");
            double speed = sc.nextDouble();
            System.out.print("Enter number of medals: ");
            int numMedals = sc.nextInt();
            Medal[] medals = new Medal[numMedals];
            for (int j = 0; j < numMedals; j++) {
                System.out.print("Enter medal type (bronze, silver, gold): ");
                String medalStr = sc.next();
                medals[j] = medalStr;
            }

            System.out.print("Choose type of animal: \n" +
                    "1-Air Animals\n" +
                    "2-Water Animals\n" +
                    "3-Terrestrial Animals\n");
            int type = sc.nextInt();
            Point location = new Point(0, 0); // example location, can be changed
            switch (type) {
                case 1:
                    System.out.print("Enter wing span");
                    double span = sc.nextDouble();
                    System.out.print("Choose animal:\n" +
                            "1) Eagle\n" +
                            "2) Pigeon\n");
                    int airType = sc.nextInt();
                    switch (airType) {
                        case 1:
                            System.out.print("Enter altitude of flight");
                            double altitude = sc.nextDouble();
                            animals[i] = new Eagle(name, gender, weight, speed, medals, location,span,altitude);
                            break;
                        case 2:
                            animals[i] = new Pigeon(name, gender, weight, speed, medals, location);
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Enter dive depth");
                    double diveDept = sc.nextDouble();
                    System.out.print("Choose animal:\n" +
                            "1) Alligator\n" +
                            "2) Whale\n" +
                            "3) Dolphin\n");
                    int waterType = sc.nextInt();
                    switch (waterType) {
                        case 1:
                            System.out.print("Enter area of living");
                             String area = sc.next();
                            animals[i] = new Alligator(name, gender, weight, speed, medals, location,diveDept,area);
                            break;
                        case 2:
                            System.out.print("Enter food type");
                            String food = sc.next();
                            animals[i] = new Whale(name, gender, weight, speed, medals, location,diveDept,food);
                            break;
                        case 3:
                            animals[i] = new Dolphin(name, gender, weight, speed, medals, location);
                            break;
                    }
                    break;
                case 3:

                    System.out.print("Choose animal:\n" +
                            "1) Dog\n" +
                            "2) Cat\n" +
                            "3) Snake\n");
                    int terrestrialType = sc.nextInt();
                    System.out.print("Enter number of legs");
                    int noLeg = sc.nextInt();
                    switch (terrestrialType) {
                        case 1:
                            System.out.print("Enter breed");
                            String breed = sc.next();
                            animals[i] = new Dog(name, gender, weight, speed, medals, location,noLeg, breed);
                            break;
                        case 2:
                            System.out.print("Is the cat castrated? (true/false): ");
                            boolean castrated = sc.nextBoolean();
                            animals[i] = new Cat(name, gender, weight, speed, medals, location,noLeg, castrated);
                            break;
                        case 3:
                            System.out.print("Enter snake length: ");
                            double length = sc.nextDouble();
                            System.out.print("Enter if snake is poisonous (YES, NO): ");
                            String poisonousStr = sc.next();
                            Snake.Poisonous poisonous = Snake.Poisonous.valueOf(poisonousStr.toUpperCase());
                            animals[i] = new Snake(name, gender, weight, speed, medals, location,noLeg, length, poisonous);
                            break;
                    }
                    break;
            }
        }

        while (true) {
            System.out.print("Choose an option: \n" +
                    "1-View all animals\n" +
                    "2-Hear all animals\n" +
                    "3-Exit\n");
            int option = sc.nextInt();
            if (option == 3) {
                break;
            }
            switch (option) {
                case 1:
                    for (Animal animal : animals) {
                        System.out.println(animal);
                    }
                    break;
                case 2:
                    for (Animal animal : animals) {
                        animal.makeSound();
                    }
                    break;
            }
        }

        sc.close();
    }
}
