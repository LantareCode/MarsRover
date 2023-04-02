package org.lantarecode;

public class Position {
    private int x;
    private int y;
    private Facing facing;

    /**
     *
     * @param x
     * @param y
     * @param facing
     */
    public Position(int x, int y, String facing) {
        this.x = x;
        this.y = y;
        switch(facing.toUpperCase()) {
            case "N":
                this.setFacing(Facing.N);
                break;
            case "E":
                this.setFacing(Facing.E);
                break;
            case "S":
                this.setFacing(Facing.S);
                break;
            case "W":
                this.setFacing(Facing.W);
                break;
            default:
                throw new IllegalArgumentException ("Invalid direction: " + facing.toUpperCase());
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }
}
