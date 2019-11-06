package agh.cs.lab4;


public class World {

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        map.place(new Animal(map));
        Animal a1 = new Animal(map, new Vector2d(3, 4));
        map.place(a1);
        map.run(directions);
        System.out.println(a1);
        System.out.println(map);

    }
}
