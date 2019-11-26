package agh.cs.lab6;

import java.util.Arrays;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args) throws IllegalArgumentException {
        MoveDirection[] directions = new MoveDirection[args.length];
        //int i = 0;
        for (int i=0;i<args.length;i++) {
            String s=args[i];
            if (s.equals("f") || s.equals("forward")) {
                directions[i++] = MoveDirection.FORWARD;
            } else if (s.equals("b") || s.equals("backward")) {
                directions[i++] = MoveDirection.BACKWARD;
            } else if (s.equals("r") || s.equals("right")) {
                directions[i++] = MoveDirection.RIGHT;
            } else if (s.equals("l") || s.equals("left")) {
                directions[i++] = MoveDirection.LEFT;
            } else
            {
                throw new IllegalArgumentException(s+" is an illegal argument.");
            }

        }
        return directions;
    }
}

