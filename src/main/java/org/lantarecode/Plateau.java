package org.lantarecode;

public class Plateau {
    private final int UPPER_RIGHT_X;
    private final int UPPER_RIGHT_Y;

    /**
     *
     * @param upperRightX
     * @param upperRightY
     */
    public Plateau(int upperRightX, int upperRightY) {
        if (upperRightX < 0 || upperRightY < 0) {
            throw new IllegalStateException ("upperRightX && upperRightY should be greater than 0");
        }
        this.UPPER_RIGHT_X = upperRightX;
        this.UPPER_RIGHT_Y = upperRightX;
    }

    /**
     *
     * @param position
     * @return
     */
    public boolean inBounds(Position position) {
        int x = position.getX();
        int y = position.getY();
        return (x >= 0 && x <= this.UPPER_RIGHT_Y && y >= 0 && y <= this.UPPER_RIGHT_X);
    }
}
