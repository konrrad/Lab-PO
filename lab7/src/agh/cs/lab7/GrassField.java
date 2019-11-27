package agh.cs.lab7;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.StrictMath.sqrt;

public class GrassField extends AbstractWorldMap {
    private final HashMap<Vector2d, Grass> gMap=new HashMap<>();
    private final int numOfFields;
    private final MapBoundary boundary;


    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(oldPosition,newPosition);
        this.boundary.positionChanged(oldPosition,newPosition);

    }
    @Override
    public void place(IMapElement mapElement)
    {
        super.place(mapElement);
        boundary.addIMapElement(mapElement);
    }
    /*public  Vector2d getUpRight()
    {
        Vector2d upRight=new Vector2d(0,0);
        Collection<Vector2d> grassPositions=gMap.keySet();
        for(Vector2d position:grassPositions)
        {
            upRight=upRight.upperRight(position);
        }
        Collection<Vector2d> animalsPositions=rectMap.keySet();
        for(Vector2d posAn:animalsPositions)
        {
            upRight=upRight.upperRight(posAn);
        }
        System.out.println(upRight);
        return upRight;
    }*/
    @Override
    public String toString()
    {
        return mapVisualizer.draw(boundary.getLowerLeft(),boundary.getUpperRight());
    }
    @Override
    public Object objectAt(Vector2d position)
    {
        if(this.rectMap.get(position)!=null)
            return this.rectMap.get(position);
        //super.objectAt(position);
        return this.gMap.get(position);
    }
    public GrassField(int numOfFields)
    {
        this.boundary=new MapBoundary();
        this.numOfFields=numOfFields;
        plantGrass();
    }
    public boolean canMoveTo(Vector2d position) {

        return !this.rectMap.containsKey(position);
    }
    private void plantGrass()
    {
        for(int i=0;i<numOfFields;i++)
            plant();
    }
    private void plant()
    {
        int bound=(int)sqrt(numOfFields*10)+1;
        Random r=new Random();
        int x;
        int y;
        while(true)
        {
            x= r.nextInt(bound);
            y=r.nextInt(bound);
            Vector2d position =new Vector2d(x,y);
            if(!gMap.containsKey(position))
            {
                Grass gr=new Grass(position);
                boundary.addIMapElement(gr);
                gMap.put(position,gr);
                break;
            }
        }
    }
}
