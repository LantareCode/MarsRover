package org.lantarecode;

public class Rover implements Movement {
    private Position position;
    private Plateau plateau;

    /**
     *
     * @param x
     * @param y
     * @param facing
     * @param plateau
     */
    Rover(int x, int y, String facing, Plateau plateau) {
        this.setPlateau(plateau);
        this.setPosition(new Position(x, y, facing));
        if (!this.getPlateau().inBounds(this.getPosition())) {
            throw new IllegalStateException("Position out of bounds");
        }
    }

    /**
     *
     * @param instructions
     */
    public void executeInstructions(String instructions) {
        for (String instruction: instructions.split("")) {
            switch(instruction.toUpperCase()) {
                case "L":
                    this.turnLeft();
                    break;
                case "R":
                    this.turnRight();
                    break;
                case "M":
                    this.move();
                    break;
                default:
                    throw new IllegalArgumentException ("Invalid instruction: " + instruction.toUpperCase());
            }
        }
    }

    /**
     *
     */
    @Override
    public void turnLeft() {
        switch(this.getPosition().getFacing()) {
            case N:
                this.getPosition().setFacing(Facing.W);
                break;
            case E:
                this.getPosition().setFacing(Facing.N);
                break;
            case S:
                this.getPosition().setFacing(Facing.E);
                break;
            case W:
                this.getPosition().setFacing(Facing.S);
                break;
            default:
                throw new IllegalArgumentException ("Invalid facing");
        }
    }

    /**
     *
     */
    @Override
    public void turnRight() {
        switch(this.getPosition().getFacing()) {
            case N:
                this.getPosition().setFacing(Facing.E);
                break;
            case E:
                this.getPosition().setFacing(Facing.S);
                break;
            case S:
                this.getPosition().setFacing(Facing.W);
                break;
            case W:
                this.getPosition().setFacing(Facing.N);
                break;
            default:
                throw new IllegalArgumentException ("Invalid facing");
        }
    }

    /**
     *
     */
    @Override
    public void move() {
        switch(this.getPosition().getFacing()) {
            case N:
                this.getPosition().setY(this.getPosition().getY()+1);
                break;
            case E:
                this.getPosition().setX(this.getPosition().getX()+1);
                break;
            case S:
                this.getPosition().setY(this.getPosition().getY()-1);
                break;
            case W:
                this.getPosition().setX(this.getPosition().getX()-1);
                break;
            default:
                throw new IllegalArgumentException ("Invalid facing");
        }

        if (!this.getPlateau().inBounds(this.getPosition())) {
            throw new IllegalStateException("Position out of bounds");
        }
    }

    /**
     *
     * @return
     */
    public String getPositionString() {
        return String.format("%d %d %s", this.getPosition().getX(), this.getPosition().getY(), this.getPosition().getFacing().toString());
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
}
