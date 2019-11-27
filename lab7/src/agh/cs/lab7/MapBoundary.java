package agh.cs.lab7;

import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {


    SortedSet<Vector2d> axisX;
    SortedSet<Vector2d> axisY;

    public MapBoundary()
    {
        axisX=new TreeSet<>(new ByXComparator());
        axisY=new TreeSet<>(new ByYComparator());
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        axisY.remove(oldPosition);
        axisX.remove(oldPosition);
        axisX.add(newPosition);
        axisY.add(newPosition);
    }

    public void addIMapElement(IMapElement e)
    {
        axisX.add(e.getPosition());
        axisY.add(e.getPosition());
    }
    public Vector2d getLowerLeft() {
        if (!(axisX.isEmpty() || axisY.isEmpty()))
            return new Vector2d(axisX.first().x, axisY.first().y);
        return new Vector2d(0,0);
    }

    public Vector2d getUpperRight() {
        if (!(axisX.isEmpty() || axisY.isEmpty()))
            return new Vector2d(axisX.last().x, axisY.last().y);
        return new Vector2d(0,0);
    }

}
