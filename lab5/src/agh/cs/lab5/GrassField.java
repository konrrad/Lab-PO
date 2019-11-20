package agh.cs.lab5;

import java.util.HashMap;
import java.util.Random;

import static java.lang.StrictMath.sqrt;

public class GrassField extends AbstractWorldMap {
    private final HashMap<Vector2d, Grass> gMap=new HashMap<>();
    private final int numOfFields;
    @Override
    public Object objectAt(Vector2d position)
    {
        if(this.rectMap.get(position)!=null)
            return this.rectMap.get(position);
        return this.gMap.get(position);
    }
    public GrassField(int numOfFields)
    {
        this.numOfFields=numOfFields;
        this.lowerBorder=new Vector2d(0,0);
        this.upperBorder=new Vector2d(0,0);
        plantGrass();
    }
    public boolean canMoveTo(Vector2d position) {

        return !this.rectMap.containsKey(position)&&this.isOnMap(position);
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
                gMap.put(position,new Grass(position));
                System.out.println(position);
                upperBorder=upperBorder.upperRight(position);
                break;
            }
        }
    }

    @Override
    public String toString() {
        MapVisualizer mapVisualizer=new MapVisualizer(this);
        return mapVisualizer.draw(lowerBorder,upperBorder);
    }
}
