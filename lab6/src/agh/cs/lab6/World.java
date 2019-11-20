package agh.cs.lab6;


public class World {

    public static void main(String[] args) {

        try
        {
            MoveDirection[] directions = new OptionsParser().parse(args);
            RectangularMap map = new RectangularMap(5,5);
            Animal a1=new Animal(map,new Vector2d(2,2));
            Animal a2=new Animal(map,new Vector2d(2,2));
            map.place(a1);
            map.place(a2);
            System.out.println(map);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}
