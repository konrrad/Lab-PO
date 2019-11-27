package agh.cs.lab7;


public class World {

    public static void main(String[] args) {

        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            GrassField map = new GrassField(5);
            Animal a1 = new Animal(map, new Vector2d(2, 2));
            map.place(a1);
            //a1.addObserver(map);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            a1.move(MoveDirection.FORWARD);
            System.out.println(map.objectAt(a1.getPosition()));
            System.out.println(a1.getPosition());
            System.out.println(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("wyjatek");
            System.exit(-1);
        }
    }
}
