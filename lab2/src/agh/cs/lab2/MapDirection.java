package agh.cs.lab2;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST;

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
}
