package org.lantarecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseUtilTest {

    @Test
    void testParsePlateau() throws Exception {
        String plateauStr = "1 2";

        Plateau plateau = ParseUtil.parsePlateau(plateauStr);
        assertEquals(1, plateau.getUpperRightX());
        assertEquals(2, plateau.getUpperRightY());
    }

    @Test
    void testParseRover() throws Exception {
        String plateauStr = "1 2 N";

        Plateau plateau = new Plateau(5,5);

        Rover rover = ParseUtil.parseRover("1 2 N", plateau);
        assertEquals(1, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());
        assertEquals(Facing.N, rover.getPosition().getFacing());
    }
}