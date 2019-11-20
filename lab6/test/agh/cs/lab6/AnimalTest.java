package agh.cs.lab6;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class AnimalTest {


    @Test
    public void constructor1() {
        final Animal a = new Animal();
        assertEquals(MapDirection.NORTH, a.getOrientation());
        assertTrue(a.getPosition().equals(new Vector2d(2, 2)));
    }

    @Test
    public void moveOrientLeft() {
        final Animal a = new Animal();
        //moving left(counter-clockwise)
        a.move(MoveDirection.LEFT);
        assertEquals(MapDirection.WEST, a.getOrientation());

        a.move(MoveDirection.LEFT);
        assertEquals(MapDirection.SOUTH, a.getOrientation());

        a.move(MoveDirection.LEFT);
        assertEquals(MapDirection.EAST, a.getOrientation());

        a.move(MoveDirection.LEFT);
        assertEquals(MapDirection.NORTH, a.getOrientation());


    }

    @Test
    public void moveOrientRight() {
        final Animal a = new Animal();
        //moving right(clockwise)
        a.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST, a.getOrientation());

        a.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH, a.getOrientation());

        a.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.WEST, a.getOrientation());

        a.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.NORTH, a.getOrientation());

    }

    @Test
    public void movePosition() {
        Animal a = new Animal();
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.FORWARD);
        assertTrue(a.getPosition().equals(new Vector2d(1, 2)));

        a.move(MoveDirection.FORWARD);
        assertTrue(a.getPosition().equals(new Vector2d(0, 2)));

        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.FORWARD);
        assertTrue(a.getPosition().equals(new Vector2d(0, 1)));

        a.move(MoveDirection.FORWARD);
        assertTrue(a.getPosition().equals(new Vector2d(0, 0)));

        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.FORWARD);
        assertTrue(a.getPosition().equals(new Vector2d(1, 0)));

        a.move(MoveDirection.FORWARD);
        assertTrue(a.getPosition().equals(new Vector2d(2, 0)));

    }

    @Test
    public void moveOutOfMap() {
        //NORTH
        Animal a = new Animal();
        for (int i = 0; i < 5; i++)
            a.move(MoveDirection.FORWARD);
        assertTrue(new Vector2d(2, 4).equals(a.getPosition()));
        //EAST
        a = new Animal();
        a.move(MoveDirection.RIGHT);
        for (int i = 0; i < 7; i++)
            a.move(MoveDirection.FORWARD);
        assertTrue(new Vector2d(4, 2).equals(a.getPosition()));
        //WEST
        a = new Animal();
        a.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++)
            a.move(MoveDirection.FORWARD);
        assertTrue(new Vector2d(0, 2).equals(a.getPosition()));
        //SOUTH
        a = new Animal();
        a.move(MoveDirection.LEFT);
        a.move(MoveDirection.LEFT);
        for (int i = 0; i < 10; i++)
            a.move(MoveDirection.FORWARD);
        assertTrue(new Vector2d(2, 0).equals(a.getPosition()));
    }

}
