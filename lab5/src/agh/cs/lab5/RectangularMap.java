package agh.cs.lab5;

import java.util.*;
import java.util.stream.Stream;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        this.lowerBorder=new Vector2d(0,0);
        this.upperBorder=new Vector2d(width-1,height-1);
    }
    @Override
    public String toString() {
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(lowerBorder,upperBorder);
    }


}