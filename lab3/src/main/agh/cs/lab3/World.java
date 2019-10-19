package agh.cs.lab3;
import agh.cs.lab3.Animal;
import agh.cs.lab3.ParseOptions;



public class World {

    public static void main(String[] args) {

        final Animal animal=new Animal();
        final MoveDirection[] directions = ParseOptions.parse(args);
        try
        {
            for(MoveDirection direction:directions)
            {
                animal.move(direction);
                System.out.println(animal);
            }
        }catch (Exception e)
        {
            System.out.println("No arguments provided.");
        }


    }
}
