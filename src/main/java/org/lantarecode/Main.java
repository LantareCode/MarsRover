package org.lantarecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    // TODO: unit tests
    // TODO: end-to-end tset (integration test)
    // TODO: Maven
    // TODO: Create good readme

    /*
    Plateau plateau = new Plateau(5, 5);
        Rover rover = new Rover(1, 2, "N", plateau);
        rover.executeInstructions("LMLMLMLMM");
        System.out.println(rover.positionString());
     */
    public static void main(String[] args) {


        // Get file from user
        Scanner scanner = getFile();

        List<String> inputLines = new ArrayList<String>();
        List<Rover> movedRovers = new ArrayList<Rover>();

        try {
            // Build a map containing Team Name (String) and their Points (Integer)
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                inputLines.add(data);
            }

            if (inputLines.size() <= 0) {
                throw new Exception("The file is empty");
            }
            // Each rover should contain 2 lines
            if ((inputLines.size()-1)%2 != 0) {
                throw new Exception("Rovers not created correctly in text file.");
            }

            // Create plateau and move the rovers
            Plateau plateau = ParseUtil.parsePlateau(inputLines.get(0));
            for (int i = 1; i < inputLines.size(); i += 2) {
                Rover rover = ParseUtil.parseRover(inputLines.get(i), plateau);
                rover.executeInstructions(inputLines.get(i+1));
                movedRovers.add(rover);
            }

            // Print output
            for (Rover rover: movedRovers) {
                System.out.println(rover.positionString());
            }
        } catch (Exception e) {
            System.out.println(String.format("ERROR: The file contains an error. Please try again. Error Message: %s", e.getMessage()));
        }

    }

    /**
     * Prompt user for input & test if file location is valid
     * @return
     */
    private static Scanner getFile() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter the path to your .txt file:");
//        String path = scanner.nextLine();

        /**/
        Scanner scanner = new Scanner(System.in);
        String path = "C:/Users/Valeske/Desktop/IdeaProjects/MarsRover/src/main/resources/input.txt"; // TOOD
        /**/
        // Check if file is found.
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println(String.format("File at %s not found.", path));
            getFile();
        }
        return scanner;
    }
}