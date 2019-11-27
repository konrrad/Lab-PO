package agh.cs.lab7;

import java.util.ArrayList;

public class Animal implements IMapElement {

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;
    private ArrayList<IPositionChangeObserver> observers=new ArrayList<>();;

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
        if(map instanceof GrassField)
            this.addObserver((GrassField)map);
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

    @Override
    public String toString() {

        return orientation.toString();
    }
    public void move(MoveDirection direction) {
        if (direction == MoveDirection.RIGHT) {
            this.orientation = this.orientation.next();
        }
        else if (direction == MoveDirection.LEFT) {
            this.orientation = this.orientation.previous();
        }
        else if (direction == MoveDirection.FORWARD) {
            Vector2d potentialPos = this.position.add(this.orientation.toUnitVector());
            if (map.canMoveTo(potentialPos)) {
                Vector2d oldPos=this.position;
                this.position = potentialPos;
                positionChanged(oldPos);
            }
        }
        else if (direction == MoveDirection.BACKWARD) {
            Vector2d potentialPos = this.orientation.toUnitVector().opposite().add(this.position);
            if (map.canMoveTo(potentialPos)) {
                Vector2d oldPos=this.position;
                this.position = potentialPos;
                positionChanged(oldPos);
            }
        }
    }
    public void addObserver(IPositionChangeObserver observer)
    {
     this.observers.add(observer);
    }
    public void removeObserver(IPositionChangeObserver observer)
    {
        this.observers.remove(observer);
    }
    private void positionChanged(Vector2d oldPosition)
    {
        for(IPositionChangeObserver o: this.observers)
        {
            o.positionChanged(oldPosition,this.position);
        }
    }
}
