package agh.cs.lab7;

public class RectangularMap extends AbstractWorldMap {

    Vector2d lowLeft;
    Vector2d upRight;
    public RectangularMap(int width, int height) {
        this.lowLeft=new Vector2d(0,0);
        this.upRight=new Vector2d(width-1,height-1);
    }

    @Override
    public String toString() {
        return mapVisualizer.draw(lowLeft,upRight);
    }
}