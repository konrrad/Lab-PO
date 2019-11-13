package agh.cs.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest {

    @Test
    public void canMoveTo() {
        RectangularMap map = new RectangularMap(5, 5);
        Animal a1 = new Animal(map, new Vector2d(3, 4));
        assertTrue(map.canMoveTo(new Vector2d(4, 4)));
        assertTrue(map.canMoveTo(new Vector2d(2, 1)));
        assertFalse(map.canMoveTo(new Vector2d(5, 5)));
        assertFalse(map.canMoveTo(new Vector2d(9, -4)));

    }

    @Test
    public void place() {

        //on occupied position
        RectangularMap map = new RectangularMap(10, 5);
        Animal a1 = new Animal(map, new Vector2d(3, 4));
        map.place(a1);
        Animal a2 = new Animal(map, new Vector2d(3, 4));
        assertFalse(map.place(a2));

        //on free position
        Animal free = new Animal(map, new Vector2d(6, 3));
        assertTrue(map.place(free));


        //outside the map
        Animal outside = new Animal(map, new Vector2d(11, 4));
        assertFalse(map.place(outside));


        //on full map
        map = new RectangularMap(4, 5);
        //filling the map
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                map.place(new Animal(map, new Vector2d(i, j)));
            }
        }
        assertFalse(map.place(new Animal(map, new Vector2d(3, 4))));


    }

    @Test
    public void run() {
        String[] args = {
                "f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"
        };
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Animal a1=new Animal(map, new Vector2d(0,0));
        Animal a2 = new Animal(map, new Vector2d(3, 4));
        map.place(a1);
        map.place(a2);
        map.run(directions);
        assertEquals(new Vector2d(1, 0), a1.getPosition());
        assertEquals(new Vector2d(2, 4), a2.getPosition());

    }

    @Test
    public void isOccupied()
    {
        RectangularMap map=new RectangularMap(10,5);
        Vector2d position1=new Vector2d(4,2);
        Vector2d position2=new Vector2d(2,3);


        map.place(new Animal(map,position1));
        map.place(new Animal(map,position2));
        //occupied position
        assertTrue(map.isOccupied(position1));
        assertTrue(map.isOccupied(position2));
        //free position
        assertFalse(map.isOccupied(new Vector2d(1,2)));
        assertFalse(map.isOccupied(new Vector2d(0,0)));
    }



    @Test
    public void objectAt()
    {
        RectangularMap map=new RectangularMap(10,5);
        Vector2d position1=new Vector2d(4,2);
        Vector2d position2=new Vector2d(2,3);
        Animal a1=new Animal(map,position1);
        Animal a2=new Animal(map,position2);
        map.place(a1);
        map.place(a2);
        //instance of Animal
        assertTrue(map.objectAt(position1) instanceof Animal);
        assertTrue(map.objectAt(position2) instanceof Animal);
        //nothing
        assertEquals(map.objectAt(new Vector2d(3,4)),null);
        assertEquals(map.objectAt(new Vector2d(8,4)),null);
    }
}
