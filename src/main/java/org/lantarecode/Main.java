package org.lantarecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main app = new Main();
        String result = app.run();

        System.out.println(result);
    }

    /**
     *
     */
    public static String run() {
        return run(null);
    }

    /**
     *
     * @param filePath
     */
    public static String run(String filePath) {

        // Get file from user
        Scanner scanner;
        if (filePath == null) {
            scanner = getFile();
        } else {
            scanner = getFile(filePath); // This is to allow for an end-to-end test
        }

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

        } catch (Exception e) {
            System.out.println(String.format("ERROR: The file contains an error. Please try again. Error Message: %s", e.getMessage()));
        }

        // Create output
        StringBuilder stringBuilder = new StringBuilder();
        for (Rover rover: movedRovers) {
            stringBuilder.append(rover.positionString()).append("\n");
        }

        return stringBuilder.toString();
    }

    /**
     * Prompt user for input & test if file location is valid
     * @return
     */
    private static Scanner getFile() {
        return getFile(null);
    }

    /**
     *
     * @param filePath
     * @return
     */
    private static Scanner getFile(String filePath) {

        Scanner scanner = new Scanner(System.in);
        String path;

        if (filePath == null) {
            System.out.println("Please enter the path to your .txt file:");
            path = scanner.nextLine();
        } else {
            path = filePath;
        }

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