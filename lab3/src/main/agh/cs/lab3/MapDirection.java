package agh.cs.lab3;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;



    @Override
    public String toString() {
       if(this==EAST)
           return "Wschód";
       else if(this==WEST)
           return "Zachód";
       else if(this==NORTH)
           return "Północ";
       else if(this==SOUTH)
           return "Południe";
       return null;
    }
    public MapDirection next()
    {
        if(this==NORTH) return EAST;
        if(this==EAST) return SOUTH;
        if(this==SOUTH) return WEST;
        if(this==WEST) return NORTH;
        return null;
    }
    public MapDirection previous()
    {
        if(this==NORTH) return WEST;
        if(this==WEST) return SOUTH;
        if(this==SOUTH) return EAST;
        if(this==EAST) return NORTH;
        return null;
    }

    public Vector2d toUnitVector() {
        if (this == NORTH)
            return new Vector2d(0, 1);
        if (this == EAST)
            return new Vector2d(1, 0);
        if (this == SOUTH)
            return new Vector2d(0, -1);
        if (this == WEST)
            return new Vector2d(-1, 0);
        return null;
    }

    }
