package org.lantarecode;

public class ParseUtil {

    /**
     *
     * @param plateauStr
     * @return
     */
    public static Plateau parsePlateau(String plateauStr) throws Exception {
        try {
            // Should contain two integers
            String[] plateau = plateauStr.split(" ");
            return new Plateau(Integer.parseInt(plateau[0].trim()),Integer.parseInt(plateau[1].trim()));
        } catch (Exception e) {
            throw new Exception(e);
        }

    }

    /**
     *
     * @param roverStr
     * @param plateau
     * @return
     */
    public static Rover parseRover(String roverStr, Plateau plateau) throws Exception {
        try {
            // Should contain two integers and a string
            String[] rover = roverStr.split(" ");
            return new Rover(Integer.parseInt(rover[0].trim()),Integer.parseInt(rover[1].trim()), rover[2].trim(), plateau);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}
