package agh.cs.lab7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected final HashMap<Vector2d, IMapElement> rectMap;
    protected final List<Animal> listOfAnimals;
    protected MapVisualizer mapVisualizer;

    public AbstractWorldMap()
    {
        this.rectMap = new HashMap<>();
        this.listOfAnimals = new ArrayList<>();
        mapVisualizer = new MapVisualizer(this);

    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement a=rectMap.get(oldPosition);
        a.getPosition();
        rectMap.remove(oldPosition);
        rectMap.put(newPosition,a);

    }

    @Override
    abstract public String toString();
    @Override
    public boolean isOccupied(Vector2d position) {

        return objectAt(position)!=null;
    }

    public boolean canMoveTo(Vector2d position) {

        return !isOccupied(position);
    }

    @Override
    public void place(IMapElement mapElement) {
        //if that position is free
        Vector2d position=mapElement.getPosition();
        if (canMoveTo(position)) {
            rectMap.put(position, mapElement);
            if(mapElement instanceof Animal)
                listOfAnimals.add((Animal) mapElement);
        }
        //position is occupied
        else
            throw new IllegalArgumentException("Error: Field "+position.toString()+" is occupied.");
    }

    @Override
    public void run(MoveDirection[] directions) {
        if (rectMap.isEmpty() || directions.length == 0) return;
        int numberOfAnimalsOnMap = listOfAnimals.size();
        for (int i = 0; i < directions.length; i++) {
            Animal currentAnimal = listOfAnimals.get(i % numberOfAnimalsOnMap);
            currentAnimal.move(directions[i]);
        }
    }


    @Override
    public Object objectAt(Vector2d position) {

        return rectMap.get(position);
    }


}
