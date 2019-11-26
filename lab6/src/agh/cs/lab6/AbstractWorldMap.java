package agh.cs.lab6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public abstract class AbstractWorldMap implements IWorldMap {

    protected Vector2d upperBorder;
    protected Vector2d lowerBorder;
    protected final HashMap<Vector2d, IMapElement> rectMap;
    protected final List<Animal> listOfAnimals;
    private MapVisualizer mapVisualizer;

    public AbstractWorldMap()
    {
        this.rectMap = new HashMap<>();
        this.listOfAnimals = new ArrayList<>();
        mapVisualizer = new MapVisualizer(this);

    }

    @Override
    public String toString() {

        return mapVisualizer.draw(lowerBorder,upperBorder);
    }
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
        Vector2d position=mapElement.getPosition();
        if (canMoveTo(position)) {
            rectMap.put(position, mapElement);
            if(mapElement instanceof Animal)
                listOfAnimals.add((Animal) mapElement);
            return true;
        }
        throw new IllegalArgumentException("Couldn't add on "+position.toString());
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
