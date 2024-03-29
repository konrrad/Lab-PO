package agh.cs.lab4;

import java.util.*;
import java.util.stream.Stream;

public class RectangularMap implements IWorldMap {

    private HashMap<Vector2d, Object> rectMap;
    private List<Animal> listOfAnimals;
    private final int width;
    private final int height;

    public RectangularMap(int width, int height) {
        this.rectMap = new HashMap<>();
        this.listOfAnimals = new ArrayList<>();
        this.width = width;
        this.height = height;

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (!isOccupied(position) && isOnMap(position))
            return true;
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        //map is full
        if (rectMap.size() == height * width)
            return false;
        //animal has its position from constructor, only placing
        //if that position is free
        if (animal.getPosition() != null && canMoveTo(animal.getPosition())) {
            rectMap.put(animal.getPosition(), animal);
            listOfAnimals.add(animal);
            return true;
        }
        //animals position is occupied
        else if (animal.getPosition() != null && !canMoveTo(animal.getPosition()))
            return false;
        //animal has no position, looking for one
        for (int i = 0; i < width * height - 1; i++) {
            if (!rectMap.containsKey(new Vector2d(i % width, i / width))) {
                Vector2d placement = new Vector2d(i % width, i / width);
                rectMap.put(new Vector2d(i % width, i / width), animal);
                animal.setPosition(new Vector2d(i % width, i / width));
                listOfAnimals.add(animal);
                return true;
            }
        }
        return false;
    }

    @Override
    public void run(MoveDirection[] directions) {
        if (rectMap.isEmpty() && directions.length == 0) return;
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
    public boolean isOccupied(Vector2d position) {

        return rectMap.containsKey(position);
    }

    @Override
    public Object objectAt(Vector2d position) {

        return rectMap.get(position);
    }

    private boolean isOnMap(Vector2d candidate) {
        Vector2d up = new Vector2d(this.width - 1, this.height - 1);
        Vector2d low = new Vector2d(0, 0);
        if (candidate.precedes(up)
                && candidate.follows(low))
            return true;
        return false;
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(new Vector2d(0, 0), new Vector2d(width - 1, height - 1));
    }

}