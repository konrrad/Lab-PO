package agh.cs.lab1;//jak w instrukcji
//package po.lab1 według zajęć

import static  java.lang.System.out;    //można tak i wtedy nie trzeba pisać System.out.println();

public class World {

    public static void main(String[] args) {
        System.out.print("Start");
        run(stringToEnum(args));
        out.print("\nStop\n");
    }
    public static void run(Direction[] directions)
    {

        for(int i=0;i<directions.length;i++)
        {
            if(directions[i]==Direction.FORWARD)
            {
                out.print("\nZwierzak idzie do przodu");
            }
            else if(directions[i]==Direction.LEFT)
            {
                out.print("\nZwierzak idzie w lewo");
            }
            else if(directions[i]==Direction.RIGHT)
            {
                out.print("\nZwierzak idzie w prawo");
            }
            else if(directions[i]==Direction.BACKWARD)
            {
                out.print("\nZwierzak idzie do tyłu");
            }
            else
            {
            	continue;
            }
        }

    }
    public static Direction[] stringToEnum(String[] args)
    {
    	Direction[] directions=new Direction[args.length];
    	for(int i=0;i<args.length;i++)
        {
            if(args[i].equals("f"))
            {
            	directions[i]=Direction.FORWARD;
            }
            else if(args[i].equals("l"))
            {
                directions[i]=Direction.LEFT;
            }
            else if(args[i].equals("r"))
            {
                directions[i]=Direction.RIGHT;
            }
            else if(args[i].equals("b"))
            {
                directions[i]=Direction.BACKWARD;
            }
        }
    	return directions;
    }
}