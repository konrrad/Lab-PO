package agh.cs.lab3;

import agh.cs.lab3.MapDirection;
import agh.cs.lab3.Vector2d;
import agh.cs.lab3.MoveDirection;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;

    public Animal() {
        orientation = MapDirection.NORTH;
        position = new Vector2d(2, 2);
    }

    public MapDirection getOrientation() {
        return orientation;
    }

    public Vector2d getPosition() {
        return position;
    }


    @Override
    public String toString() {
        return orientation + " " + position.toString();
    }

    public void move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
        } else if (direction == MoveDirection.LEFT) {
            this.orientation = this.orientation.previous();
        } else if (direction == MoveDirection.FORWARD) {

            Vector2d potentialPos = this.position.add(this.orientation.toUnitVector());
            if (!(potentialPos.x < 0 || potentialPos.y < 0 || potentialPos.x > 4 || potentialPos.y > 4))
                this.position = potentialPos;
        } else if (direction == MoveDirection.BACKWARD) {
            Vector2d potentialPos = this.orientation.toUnitVector().opposite().add(this.position);
            if (!(potentialPos.x < 0 || potentialPos.y < 0 || potentialPos.x > 4 || potentialPos.y > 4))
                this.position = potentialPos;
        }


    }
}
