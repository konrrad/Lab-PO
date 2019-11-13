package agh.cs.lab5;

import org.junit.Test;

import static org.junit.Assert.*;

public class Vector2dTest {
    @Test
    public void equalsSameXY() {
        final Vector2d o = new Vector2d(2, 2);
        final Vector2d p = new Vector2d(2, 2);
        assertTrue(o.equals(p));
        assertTrue(p.equals(o));
    }

    @Test
    public void equalsToItself() {
        final Vector2d o = new Vector2d(10, -4);
        assertTrue(o.equals(o));
    }

    @Test
    public void equalsSameX() {
        final Vector2d o = new Vector2d(2, 3);
        final Vector2d p = new Vector2d(2, 0);
        assertFalse(o.equals(p));
        assertFalse(p.equals(o));
    }

    @Test
    public void equalsSameY() {
        final Vector2d o = new Vector2d(2, 3);
        final Vector2d p = new Vector2d(2, 0);
        assertFalse(o.equals(p));
        assertFalse(p.equals(o));
    }

    @Test
    public void equalsDiffersXandY() {
        final Vector2d o = new Vector2d(25, 3);
        final Vector2d p = new Vector2d(-6, 0);
        assertFalse(o.equals(p));
        assertFalse(p.equals(o));
    }

    @Test
    public void equalsDiffersNull() {
        final Vector2d o = new Vector2d(25, 3);
        assertFalse(o.equals(null));
    }

    @Test
    public void equalsForeignClass() {
        final Vector2d o = new Vector2d(25, 3);
        assertFalse(o.equals("Foreign Class"));
    }

    @Test
    public void toStringTest() {
        final Vector2d p = new Vector2d(-6, 0);
        assertEquals(p.toString(), "(-6,0)");
    }

    @Test
    public void predeces() {
        final Vector2d o = new Vector2d(25, 3);
        final Vector2d p = new Vector2d(-6, 0);
        assertTrue(p.precedes(o));
        assertTrue(p.precedes(p));
        assertFalse(o.precedes(p));
    }

    @Test
    public void follows() {
        final Vector2d o = new Vector2d(1, -2);
        final Vector2d p = new Vector2d(6, 5);
        assertTrue(o.follows(o));
        assertFalse(o.follows(p));
        assertTrue(p.follows(o));
    }

    @Test
    public void neitherPredecesNorFollows() {
        final Vector2d o = new Vector2d(1, -2);
        final Vector2d p = new Vector2d(-3, 5);
        assertFalse(o.precedes(p));
        assertFalse(p.follows(o));
    }

    @Test
    public void upperRight() {
        final Vector2d o = new Vector2d(1, -2);
        final Vector2d p = new Vector2d(-4, 12);
        assertEquals(o.upperRight(p), new Vector2d(Math.max(o.x, p.x), Math.max(o.y, p.y)));
        assertEquals(o.upperRight(o), o);
    }

    @Test
    public void lowerLeft() {
        final Vector2d o = new Vector2d(4, -2);
        final Vector2d p = new Vector2d(-4, 12);
        assertEquals(o.lowerLeft(p), new Vector2d(Math.min(o.x, p.x), Math.min(o.y, p.y)));
        assertEquals(o.lowerLeft(o), o);
    }

    @Test
    public void subtract() {
        final Vector2d o = new Vector2d(4, -2);
        final Vector2d p = new Vector2d(-4, 12);
        assertEquals(o.subtract(p), new Vector2d(o.x - p.x, o.y - p.y));
        //assertNotEquals(p.subtract(o),new Vector2d(o.x-p.x,o.y-p.x));
        assertNotEquals(p.subtract(o), o.subtract(p));
    }

    @Test
    public void add() {
        final Vector2d o = new Vector2d(4, -2);
        final Vector2d p = new Vector2d(-4, 12);
        assertEquals(o.add(p), new Vector2d(o.x + p.x, o.y + p.y));
        assertEquals(o.add(p), p.add(o));
    }

    @Test
    public void opposite() {
        final Vector2d o = new Vector2d(0, 0);
        final Vector2d p = new Vector2d(-4, 12);
        assertEquals(o.opposite(), o);
        assertEquals(p.opposite(), new Vector2d(4, -12));
    }
}
