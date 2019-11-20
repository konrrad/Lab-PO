package agh.cs.lab6;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        this.lowerBorder=new Vector2d(0,0);
        this.upperBorder=new Vector2d(width-1,height-1);
    }




}