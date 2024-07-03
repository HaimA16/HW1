package System;

import java.util.Scanner;
import Animals.*;
import Mobility.*;
import Olympics.*;

public class Sys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;

        while (true) {
            try {
                System.out.print("Enter number of animals: ");
                size = sc.nextInt();
                if (size <= 0) {
                    System.out.println("Number of animals must be positive.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }

        Animal[] animals = new Animal[size];

        for (int i = 0; i < size; i++) {
            int type;

            while (true) {
                try {
                    System.out.print("""
                            Choose type of animal:
                            1-Air Animals
                            2-Water Animals
                            3-Terrestrial Animals
                            """);
                    type = sc.nextInt();
                    if (type < 1 || type > 3) {
                        System.out.println("Invalid animal type. Please enter a number between 1 and 3.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    sc.next();
                }
            }

            Point location = null;
            System.out.print("Enter animal name: ");
            String name = sc.next();
            Animal.Gender gender;

            while (true) {
                try {
                    System.out.print("Enter animal gender (Male, Female, Hermaphrodite): ");
                    String genderStr = sc.next();
                    gender = Animal.Gender.valueOf(genderStr.toUpperCase());
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid gender. Please enter 'Male', 'Female', or 'Hermaphrodite'.");
                }
            }

            double weight, speed;

            while (true) {
                try {
                    System.out.print("Enter animal weight: ");
                    weight = sc.nextDouble();
                    if (weight <= 0) {
                        System.out.println("Weight must be positive.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid weight.");
                    sc.next();
                }
            }

            while (true) {
                try {
                    System.out.print("Enter animal speed: ");
                    speed = sc.nextDouble();
                    if (speed <= 0) {
                        System.out.println("Speed must be positive.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid speed.");
                    sc.next();
                }
            }

            int numMedals;

            while (true) {
                try {
                    System.out.print("Enter number of medals: ");
                    numMedals = sc.nextInt();
                    if (numMedals < 0) {
                        System.out.println("Number of medals cannot be negative.");
                        continue;
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid number of medals.");
                    sc.next();
                }
            }

            Medal[] medals = new Medal[numMedals];

            for (int j = 0; j < numMedals; j++) {
                while (true) {
                    try {
                        System.out.print("Enter medal type (BRONZE, SILVER, GOLD): ");
                        String medalStr = sc.next().toUpperCase();
                        Medal.MedalType medalType = Medal.MedalType.valueOf(medalStr);
                        System.out.print("Enter tournament: ");
                        String tournament = sc.next();
                        int year;
                        while (true) {
                            try {
                                System.out.print("Enter year: ");
                                year = sc.nextInt();
                                if (year < 1900 || year > 2024) {
                                    System.out.println("Year must be between 1900 and 2024.");
                                    continue;
                                }
                                break;
                            } catch (Exception e) {
                                System.out.println("Invalid input. Please enter a valid year.");
                                sc.next();
                            }
                        }
                        medals[j] = new Medal(medalType, tournament, year);
                        break;
                    } catch (Exception e) {
                        System.out.println("Invalid input for medal. Please try again.");
                        sc.next();
                    }
                }
            }

            switch (type) {
                case 1:
                    //location = new Point(0, 100);
                    int airType;
                    while (true) {
                        try {
                            System.out.print("""
                                    Choose animal:
                                    1) Eagle
                                    2) Pigeon
                                    """);
                            airType = sc.nextInt();
                            if (airType < 1 || airType > 2) {
                                System.out.println("Invalid choice. Please enter 1 or 2.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    System.out.print("Enter wing span: ");
                    double span = sc.nextDouble();
                    switch (airType) {
                        case 1:
                            System.out.print("Enter altitude of flight: ");
                            double altitude = sc.nextDouble();
                            animals[i] = new Eagle(name, gender, weight, speed, medals, location, span, altitude);
                            break;
                        case 2:
                            System.out.print("Enter family: ");
                            String family = sc.next();
                            animals[i] = new Pigeon(name, gender, weight, speed, medals, location, span, family);
                            break;
                    }
                    break;
                case 2:
                    //location = new Point(50, 0);
                    int waterType;
                    while (true) {
                        try {
                            System.out.print("""
                                    Choose animal:
                                    1) Alligator
                                    2) Whale
                                    3) Dolphin
                                    """);
                            waterType = sc.nextInt();
                            if (waterType < 1 || waterType > 3) {
                                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    double diveDept;
                    while (true) {
                        try {
                            System.out.print("Enter dive depth: ");
                            diveDept = sc.nextDouble();
                            if (diveDept >= 0) {
                                System.out.println("Dive depth must be Negative.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid dive depth.");
                            sc.next();
                        }
                    }
                    switch (waterType) {
                        case 1:
                            System.out.print("Enter area of living: ");
                            String area = sc.next();
                            animals[i] = new Alligator(name, gender, weight, speed, medals, location, diveDept, area);
                            break;
                        case 2:
                            System.out.print("Enter food type: ");
                            String food = sc.next();
                            animals[i] = new Whale(name, gender, weight, speed, medals, location, diveDept, food);
                            break;
                        case 3:
                            Dolphin.WaterType waterTypeEnum;
                            while (true) {
                                try {
                                    System.out.print("Enter water type (SEA, SWEET): ");
                                    String waterTypeStr = sc.next().toUpperCase();
                                    waterTypeEnum = Dolphin.WaterType.valueOf(waterTypeStr);
                                    break;
                                } catch (Exception e) {
                                    System.out.println("SEA or SWEET only!");
                                    sc.next();
                                }
                            }
                            animals[i] = new Dolphin(name, gender, weight, speed, medals, location, diveDept, waterTypeEnum);
                            break;
                    }
                    break;
                case 3:
                    //location = new Point(0, 20);
                    int terrestrialType;
                    while (true) {
                        try {
                            System.out.print("""
                                    Choose animal:
                                    1) Dog
                                    2) Cat
                                    3) Snake
                                    """);
                            terrestrialType = sc.nextInt();
                            if (terrestrialType < 1 || terrestrialType > 3) {
                                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    System.out.print("Enter number of legs: ");
                    int noLegs = sc.nextInt();
                    switch (terrestrialType) {
                        case 1:
                            System.out.print("Enter breed: ");
                            String breed = sc.next();
                            animals[i] = new Dog(name, gender, weight, speed, medals, location, noLegs, breed);
                            break;
                        case 2:
                            System.out.print("Is the cat castrated? (true/false): ");
                            boolean castrated = sc.nextBoolean();
                            animals[i] = new Cat(name, gender, weight, speed, medals, location, noLegs, castrated);
                            break;
                        case 3:
                            noLegs = 0;
                            System.out.print("Enter snake length: ");
                            double length = sc.nextDouble();
                            System.out.print("Enter if snake is poisonous (YES, NO): ");
                            String poisonousStr = sc.next().toUpperCase();
                            Snake.Poisonous poisonous = Snake.Poisonous.valueOf(poisonousStr);
                            animals[i] = new Snake(name, gender, weight, speed, medals, location, noLegs, length, poisonous);
                            break;
                    }
                    break;
            }
        }

        while (true) {
            System.out.print("""
                    Choose an option:
                    1-View all animals
                    2-Hear all animals
                    3-compare
                    4-Exit
                    """);
            int option = sc.nextInt();
            if (option == 4) {
                System.out.println("Thank you, bye!");
                break;
            }
            switch (option) {
                case 1:
                    for (Animal animal : animals) {
                        System.out.println(animal.toString());
                    }
                    break;
                case 2:
                    for (Animal animal : animals) {
                        animal.makeSound();
                    }
                    break;
                case 3:
                    if (animals.length < 2) {
                        System.out.println("Can't compare, only 1 animal!.");
                    } else {
                        boolean allIdentical = true;
                        for (int i = 0; i < animals.length; i++) {
                            for (int j = i + 1; j < animals.length; j++) {
                                if (!animals[i].equals(animals[j])) {
                                    allIdentical = false;
                                    break;
                                }
                            }
                        }

                        if (allIdentical) {
                            System.out.println("All animals identical.");
                        } else {
                            System.out.println("All animals not identical.");
                        }
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        sc.close();
    }
}
