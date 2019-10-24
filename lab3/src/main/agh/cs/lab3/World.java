package agh.cs.lab3;
import agh.cs.lab3.Animal;
import agh.cs.lab3.ParseOptions;

import java.util.Arrays;


public class World {

    public static void main(String[] args) {

        final Animal animal = new Animal();
        final MoveDirection[] directions = ParseOptions.parse(args);
        for (MoveDirection direction : directions) {
            animal.move(direction);
            System.out.println(animal);
        }


    }
}
