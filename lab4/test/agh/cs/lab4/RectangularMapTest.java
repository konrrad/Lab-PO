package agh.cs.lab4;

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


        //first free position
        map = new RectangularMap(2, 3);
        a1.setPosition(new Vector2d(0, 0));
        a2.setPosition(new Vector2d(0, 1));
        Animal a3 = new Animal(map, new Vector2d(1, 0));
        map.place(a1);
        map.place(a2);
        map.place(a3);
        Animal a4 = new Animal(map);
        map.place(a4);
        assertEquals(new Vector2d(1, 1), a4.getPosition());
    }

    @Test
    public void run() {
        String[] args = {
                "f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"
        };
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Animal a1 = new Animal(map);
        Animal a2 = new Animal(map, new Vector2d(3, 4));
        map.place(a1);
        map.place(a2);
        map.run(directions);
        assertEquals(new Vector2d(1, 0), a1.getPosition());
        assertEquals(new Vector2d(2, 4), a2.getPosition());

    }
}
