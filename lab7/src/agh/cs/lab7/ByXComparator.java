package agh.cs.lab7;

import java.util.Comparator;

public class ByXComparator implements Comparator {

    @Override
    public int compare(Object o, Object t) {
        if(o instanceof Vector2d && t instanceof Vector2d)
        {
            Vector2d o1=(Vector2d) o;
            Vector2d t1=(Vector2d) t;
            return !(o1.x==t1.x) ? Integer.compare(o1.x,t1.x):Integer.compare(o1.y,t1.y);
        }
        throw new RuntimeException("Objects not of the same type in comprison");

    }
}
