package agh.cs.lab7;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GrassFieldTest {
    @Test
    public void objectAt()
    {
        GrassField map=new GrassField(5);

        //just an Animal on the map
        Vector2d pos=new Vector2d(0,0);
        Animal a1=new Animal(map,pos);
        map.place(a1);
        assertTrue(map.objectAt(pos) instanceof Animal);

        Vector2d upperBorder=map.getUpRight();
        //searching for Grass
        Grass gr=new Grass(new Vector2d(0,0));
        for(int x=1;x<upperBorder.x;x++)
        {
            for(int y=0;y<upperBorder.y;y++)
            {
                Vector2d cur=new Vector2d(x,y);
                if(map.objectAt(cur) instanceof Grass)
                {
                    System.out.println(map.objectAt(cur));
                    gr=(Grass)map.objectAt(cur);
                    break;
                }
            }
        }
        Vector2d gPos=gr.getPosition();
        Animal a2=new Animal(map,gPos);
        map.place(a2);
        assertTrue(map.objectAt(gPos) instanceof Animal);

    }
    @Test
    public void isOccupied()
    {
        GrassField map=new GrassField(5);

        //just an Animal on the map
        Vector2d pos=new Vector2d(0,0);
        Animal a1=new Animal(map,pos);
        map.place(a1);
        assertTrue(map.isOccupied(pos));


        Vector2d upperBorder=map.getUpRight();
        //searching for Grass and empty field
        Grass gr=new Grass(new Vector2d(0,0));
        Vector2d empty=new Vector2d(0,0);
        for(int x=1;x<upperBorder.x;x++)
        {
            for(int y=0;y<upperBorder.y;y++)
            {
                Vector2d cur=new Vector2d(x,y);
                if(map.objectAt(cur) instanceof Grass)
                {
                    gr=(Grass)map.objectAt(cur);
                    break;
                }
                else if(map.objectAt(cur)==null)
                {
                    empty=new Vector2d(x,y);
                }
            }
        }
        assertTrue(map.isOccupied(gr.getPosition()));
        assertFalse(map.isOccupied(empty));
    }
    @Test
    public void canMoveTo()
    {

        GrassField map=new GrassField(5);
        Vector2d upperBorder=map.getUpRight();
        int upx= upperBorder.x;

        //two Animals
        Vector2d pos1=new Vector2d(0,0);
        Animal a1=new Animal(map,pos1);
        map.place(a1);
        Vector2d pos2=new Vector2d(0,1);
        Animal a2=new Animal(map,pos2);
        map.place(a2);
        assertFalse(map.canMoveTo(pos2));

        //outside the map
        assertTrue(map.canMoveTo(new Vector2d(upx+1,0)));

        //onto Grass
        //searching for Grass
        Grass gr=new Grass(new Vector2d(0,0));
        for(int x=1;x<upperBorder.x;x++)
        {
            for(int y=0;y<upperBorder.y;y++)
            {
                Vector2d cur=new Vector2d(x,y);
                if(map.objectAt(cur) instanceof Grass)
                {
                    System.out.println(map.objectAt(cur));
                    gr=(Grass)map.objectAt(cur);
                    break;
                }
            }
        }
        Vector2d gPos=gr.getPosition();
        assertTrue(map.canMoveTo(gPos));
    }

    //if canMoveTo() works then place() and run() work
}
