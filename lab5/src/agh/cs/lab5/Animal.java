package agh.cs.lab5;

public class Animal implements IMapElement {

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    public  Animal()
    {
        orientation= MapDirection.NORTH;
        position=new Vector2d(2,2);
        map=null;
    }
    public Animal(IWorldMap map) {
        this.orientation = MapDirection.NORTH;
        this.map = map;
        this.position = new Vector2d(2,2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this(map);
        this.position = initialPosition;
    }

    public MapDirection getOrientation() {

        return orientation;
    }

    public Vector2d getPosition() {

        return position;
    }

    public void setPosition(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {

        return orientation.toString();
    }

    public boolean move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
            return true;
        } else if (direction == MoveDirection.LEFT) {
            this.orientation = this.orientation.previous();
            return true;
        } else if (direction == MoveDirection.FORWARD) {
            Vector2d potentialPos = this.position.add(this.orientation.toUnitVector());
            if (map.canMoveTo(potentialPos)) {
                this.position = potentialPos;
                return true;
            }

        } else if (direction == MoveDirection.BACKWARD) {
            Vector2d potentialPos = this.orientation.toUnitVector().opposite().add(this.position);
            if (map.canMoveTo(potentialPos)) {
                this.position = potentialPos;
                return true;
            }

        }
        return false;


    }
}
