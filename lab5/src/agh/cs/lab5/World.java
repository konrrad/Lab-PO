package agh.cs.lab5;


public class World {

    public static void main(String[] args) {

        MoveDirection[] directions = new OptionsParser().parse(args);
        GrassField map = new GrassField(5);

        System.out.println(map);
    }
}
