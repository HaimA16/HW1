/**
 * Main class for managing a system of animals.
 * This class allows the user to create instances of different types of animals (Air, Water,
 * Terrestrial) based on user input. It handles input validation and provides options to view and
 * hear the animals created.
 * Each animal type requires specific attributes to be entered by the user:
 * The program continues to run until the user chooses to exit. It allows the user to view all
 * animals created and hear the sound each animal makes.
 * Author: Haim Armias 315569061
 * Author: Yeuda Baza 208029819
 */
package System;

import java.util.Scanner;
import Animals.*;

public class Sys {

    private static Scanner sc = new Scanner(System.in);

    /**
     * Main method to start the program.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int size = getNumberOfAnimals();

        Animal[] animals = new Animal[size];

        for (int i = 0; i < size; i++) {
            int type = getAnimalType();

            switch (type) {
                case 1:
                    animals[i] = createAirAnimal();
                    break;
                case 2:
                    animals[i] = createWaterAnimal();
                    break;
                case 3:
                    animals[i] = createTerrestrialAnimal();
                    break;
            }
        }

        handleUserOptions(animals);

        sc.close();
    }

    /**
     * Prompts the user for the number of animals to create.
     *
     * @return the number of animals to create
     */
    private static int getNumberOfAnimals() {
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
        return size;
    }

    /**
     * Prompts the user to choose the type of animal to create (Air, Water, Terrestrial).
     *
     * @return the chosen animal type
     */
    private static int getAnimalType() {
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
        return type;
    }

    /**
     * Creates an instance of an Air Animal (Eagle or Pigeon) based on user input.
     *
     * @return the created Air Animal instance
     */
    private static Animal createAirAnimal() {
        Animal animal = null;
        int airType;
        double span;
        AnimalAttributes attributes = new AnimalAttributes();

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

        while (true) {
            try {
                System.out.print("Enter wing span: ");
                span = sc.nextDouble();
                if (span <= 0) {
                    System.out.println("Wing span must be positive.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }

        switch (airType) {
            case 1:
                try {
                    attributes.input(attributes);
                    double altitude;
                    while (true) {
                        try {
                            System.out.print("Enter altitude of flight: ");
                            altitude = sc.nextDouble();
                            if (altitude <= 0 || altitude > 1000) {
                                System.out.println("Altitude of flight must be positive and less than 1000.");
                                continue;
                            }
                            animal = new Eagle(attributes.getName(), attributes.getGender(), attributes.getWeight(), attributes.getSpeed(), attributes.getMedals(), attributes.getLocation(), span, altitude);
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please try again.");
                            sc.next();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    sc.next();
                }
                break;
            case 2:
                try {
                    attributes.input(attributes);
                    System.out.print("Enter family: ");
                    String family = sc.next();
                    animal = new Pigeon(attributes.getName(), attributes.getGender(), attributes.getWeight(), attributes.getSpeed(), attributes.getMedals(), attributes.getLocation(), span, family);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.next();
                }
                break;
        }
        return animal;
    }

    /**
     * Creates an instance of a Water Animal (Alligator, Whale, Dolphin) based on user input.
     *
     * @return the created Water Animal instance
     */
    private static Animal createWaterAnimal() {
        Animal animal = null;
        int waterType;
        double diveDepth;
        AnimalAttributes attributes = new AnimalAttributes();

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

        while (true) {
            try {
                System.out.print("Enter dive depth: ");
                diveDepth = sc.nextDouble();
                if (diveDepth >= 0 || diveDepth <= -800) {
                    System.out.println("Dive depth must be negative and maximum -800.");
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
                try {
                    attributes.input(attributes);
                    System.out.print("Enter area of living: ");
                    String area = sc.next();
                    animal = new Alligator(attributes.getName(), attributes.getGender(), attributes.getWeight(), attributes.getSpeed(), attributes.getMedals(), attributes.getLocation(), diveDepth, area);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.next();
                }
                break;
            case 2:
                try {
                    attributes.input(attributes);
                    System.out.print("Enter food type: ");
                    String food = sc.next();
                    animal = new Whale(attributes.getName(), attributes.getGender(), attributes.getWeight(), attributes.getSpeed(), attributes.getMedals(), attributes.getLocation(), diveDepth, food);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.next();
                }
                break;
            case 3:
                try {
                    attributes.input(attributes);
                    Dolphin.WaterType waterTypeEnum;
                    int choice;
                    while (true) {
                        try {
                            System.out.print("""
                                    Choose water type:
                                    1) Sea
                                    2) Sweet
                                    """);
                            choice = sc.nextInt();
                            if (choice == 1) {
                                waterTypeEnum = Dolphin.WaterType.SEA;
                            } else if (choice == 2) {
                                waterTypeEnum = Dolphin.WaterType.SWEET;
                            } else {
                                System.out.println("Invalid choice. Please enter 1 or 2.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    animal = new Dolphin(attributes.getName(), attributes.getGender(), attributes.getWeight(), attributes.getSpeed(), attributes.getMedals(), attributes.getLocation(), diveDepth, waterTypeEnum);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.next();
                }
                break;
        }
        return animal;
    }

    /**
     * Creates an instance of a Terrestrial Animal (Dog, Cat, Snake) based on user input.
     *
     * @return the created Terrestrial Animal instance
     */
    private static Animal createTerrestrialAnimal() {
        Animal animal = null;
        int terrestrialType;
        int noLegs;
        AnimalAttributes attributes = new AnimalAttributes();

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

        while (true) {
            try {
                System.out.print("Enter number of legs: ");
                noLegs = sc.nextInt();
                if (noLegs < 0) {
                    System.out.println("Number of legs must be non-negative.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.next();
            }
        }

        switch (terrestrialType) {
            case 1:
                try {
                    attributes.input(attributes);
                    System.out.print("Enter breed: ");
                    String breed = sc.next();
                    animal = new Dog(attributes.getName(), attributes.getGender(), attributes.getWeight(), attributes.getSpeed(), attributes.getMedals(), attributes.getLocation(), noLegs, breed);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.next();
                }
                break;
            case 2:
                try {
                    attributes.input(attributes);
                    boolean castrated;
                    int choice1;
                    while (true) {
                        try {
                            System.out.print("""
                                    1) Castrated
                                    2) Not castrated
                                    """);
                            choice1 = sc.nextInt();
                            if (choice1 == 1) {
                                castrated = true;
                            } else if (choice1 == 2) {
                                castrated = false;
                            } else {
                                System.out.println("Invalid input. Please enter 1 or 2.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    animal = new Cat(attributes.getName(), attributes.getGender(), attributes.getWeight(), attributes.getSpeed(), attributes.getMedals(), attributes.getLocation(), noLegs, castrated);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.next();
                }
                break;
            case 3:
                try {
                    attributes.input(attributes);
                    noLegs = 0; // Snakes have no legs
                    System.out.print("Enter snake length: ");
                    double length = sc.nextDouble();
                    Snake.Poisonous poisonous;
                    int choice2;
                    while (true) {
                        try {
                            System.out.print("""
                                    1) Poisonous
                                    2) Not poisonous
                                    """);
                            choice2 = sc.nextInt();
                            if (choice2 == 1) {
                                poisonous = Snake.Poisonous.YES;
                            } else if (choice2 == 2) {
                                poisonous = Snake.Poisonous.NO;
                            } else {
                                System.out.println("Invalid choice. Please enter 1 or 2.");
                                continue;
                            }
                            break;
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    animal = new Snake(attributes.getName(), attributes.getGender(), attributes.getWeight(), attributes.getSpeed(), attributes.getMedals(), attributes.getLocation(), noLegs, length, poisonous);
                } catch (Exception e) {
                    System.out.println("Invalid input. Please try again.");
                    sc.next();
                }
                break;
        }
        return animal;
    }

    /**
     * Handles user options to view or hear animals.
     *
     * @param animals array of animals to operate on
     */
    private static void handleUserOptions(Animal[] animals) {
        while (true) {
            try {
                System.out.print("""
                        Choose an option:
                        1-View all animals
                        2-Hear all animals
                        3-Exit
                        """);
                int option = sc.nextInt();
                if (option == 3) {
                    System.out.println("Thank you, bye!");
                    break;
                }
                switch (option) {
                    case 1:
                        viewAllAnimals(animals);
                        break;
                    case 2:
                        hearAllAnimals(animals);
                        break;
                    default:
                        System.out.println("Invalid option. Please choose a valid option.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid option.");
                sc.next();
            }
        }
    }

    /**
     * Displays information about all animals in the provided array.
     *
     * @param animals array of animals to display
     */
    private static void viewAllAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }

    /**
     * Makes all animals in the provided array produce their characteristic sounds.
     *
     * @param animals array of animals to operate on
     */
    private static void hearAllAnimals(Animal[] animals) {
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
