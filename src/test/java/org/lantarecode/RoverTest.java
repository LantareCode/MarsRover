package org.lantarecode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {

    private Plateau plateau = new Plateau(10, 10);

    @Test
    void notInBoundsShouldResultInIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> {
            Rover rover = new Rover(20, 5, "N", this.plateau);
        });

        assertThrows(IllegalStateException.class, () -> {
            Rover rover = new Rover(5, 20, "N", this.plateau);
        });
    }

    @Test
    void facingShouldResultInNorth() {
        Rover rover = new Rover(0, 0, "E", this.plateau);
        rover.turnLeft();
        assertEquals(Facing.N, rover.getPosition().getFacing());

        rover = new Rover(0, 0, "W", this.plateau);
        rover.turnRight();
        assertEquals(Facing.N, rover.getPosition().getFacing());
    }

    @Test
    void facingShouldResultInEast() {
        Rover rover = new Rover(0, 0, "S", this.plateau);
        rover.turnLeft();
        assertEquals(Facing.E, rover.getPosition().getFacing());

        rover = new Rover(0, 0, "N", this.plateau);
        rover.turnRight();
        assertEquals(Facing.E, rover.getPosition().getFacing());
    }

    @Test
    void facingShouldResultInSouth() {
        Rover rover = new Rover(0, 0, "W", this.plateau);
        rover.turnLeft();
        assertEquals(Facing.S, rover.getPosition().getFacing());

        rover = new Rover(0, 0, "E", this.plateau);
        rover.turnRight();
        assertEquals(Facing.S, rover.getPosition().getFacing());
    }

    @Test
    void facingShouldResultInWest() {
        Rover rover = new Rover(0, 0, "N", this.plateau);
        rover.turnLeft();
        assertEquals(Facing.W, rover.getPosition().getFacing());

        rover = new Rover(0, 0, "S", this.plateau);
        rover.turnRight();
        assertEquals(Facing.W, rover.getPosition().getFacing());
    }

    @Test
    void invalidFacingShouldReturnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rover rover = new Rover(0,0, "L", this.plateau);
            rover.turnLeft();
        });
    }

    @Test
    void testExecuteInstructions() {
        Rover rover = new Rover(1, 2, "N", this.plateau);
        rover.executeInstructions("LMLMLMLMM");

        assertEquals(1, rover.getPosition().getX());
        assertEquals(3, rover.getPosition().getY());
        assertEquals(Facing.N, rover.getPosition().getFacing());
    }

    @Test
    void executeInstructionsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rover rover = new Rover(0,0, "L", this.plateau);
            rover.executeInstructions("D");
        });
    }

    @Test
    void movingWhenFacingNorthShouldIncreaseY () {
        Rover rover = new Rover(5, 5, "N", this.plateau);
        rover.move();
        assertEquals(5, rover.getPosition().getX());
        assertEquals(6, rover.getPosition().getY());
    }

    @Test
    void movingWhenFacingEastShouldIncreaseX () {
        Rover rover = new Rover(5, 5, "E", this.plateau);
        rover.move();
        assertEquals(6, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
    }

    @Test
    void movingWhenFacingSouthShouldDecreaseY () {
        Rover rover = new Rover(5, 5, "S", this.plateau);
        rover.move();
        assertEquals(5, rover.getPosition().getX());
        assertEquals(4, rover.getPosition().getY());
    }

    @Test
    void movingWhenFacingWestShouldDecreaseX () {
        Rover rover = new Rover(5, 5, "W", this.plateau);
        rover.move();
        assertEquals(4, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
    }

    @Test
    void movingOutOfBoundsShouldResultIllegalStateExceptionException() {
        assertThrows(IllegalStateException.class, () -> {
            Rover rover = new Rover(0, 5, "W", this.plateau);
            rover.move();
        });
    }

    @Test
    void movingWithWrongFacingShouldResultInIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            Rover rover = new Rover(0, 5, "L", this.plateau);
            rover.move();
        });
    }

    @Test
    void testPositionString() {
        Rover rover = new Rover(1, 2, "N", this.plateau);
        assertEquals("1 2 N", rover.positionString());
    }

}