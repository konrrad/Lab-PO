package agh.cs.lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {

    protected Vector2d upperBorder;
    protected Vector2d lowerBorder;
    protected final HashMap<Vector2d, Object> rectMap;
    protected final List<Animal> listOfAnimals;


    public AbstractWorldMap()
    {
        this.rectMap = new HashMap<>();
        this.listOfAnimals = new ArrayList<>();

    }
    public Vector2d getUpperBorder()
    {
        return upperBorder;
    }
    public Vector2d getLowerBorder()
    {
        return lowerBorder;
    }
    @Override
    public abstract String toString();
    @Override
    public boolean isOccupied(Vector2d position) {

        return objectAt(position)!=null;
    }

    public boolean canMoveTo(Vector2d position) {

        return !isOccupied(position)&&isOnMap(position);
    }

    protected boolean isOnMap(Vector2d candidate) {
        return candidate.follows(lowerBorder)&&candidate.precedes(upperBorder);
    }

    @Override
    public boolean place(IMapElement mapElement) {
        //if that position is free
        if (canMoveTo(mapElement.getPosition())) {

            rectMap.put(mapElement.getPosition(), mapElement);
            if(mapElement instanceof Animal)
                listOfAnimals.add((Animal) mapElement);
            return true;
        }
        //position is occupied
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if (rectMap.isEmpty() || directions.length == 0) return;
        int numberOfAnimalsOnMap = listOfAnimals.size();
        for (int i = 0; i < directions.length; i++) {
            Animal currentAnimal = listOfAnimals.get(i % numberOfAnimalsOnMap);
            Vector2d currentPosition = currentAnimal.getPosition();
            if (currentAnimal.move(directions[i])) {
                Vector2d newPosition = currentAnimal.getPosition();
                rectMap.remove(currentPosition);
                rectMap.put(newPosition, currentAnimal);
            }

        }
    }


    @Override
    public Object objectAt(Vector2d position) {
        return rectMap.get(position);
    }


}
