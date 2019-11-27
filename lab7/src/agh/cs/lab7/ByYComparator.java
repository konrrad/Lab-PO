package agh.cs.lab7;

import java.util.Collection;
import java.util.Comparator;

public class ByYComparator implements Comparator {
    @Override
    public int compare(Object o, Object t) {
        if(o instanceof Vector2d && t instanceof Vector2d)
        {
            Vector2d o1=(Vector2d) o;
            Vector2d t1=(Vector2d) t;
            return !(o1.y==t1.y) ? Integer.compare(o1.y,t1.y):Integer.compare(o1.x,t1.x);
        }
        throw new RuntimeException("Objects not of the same type in comprison");

    }
}
