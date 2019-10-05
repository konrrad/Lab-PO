package agh.cs.lab1;//jak w instrukcji
//package po.lab1 według zajęć

import static  java.lang.System.out;    //można tak i wtedy nie trzeba pisać System.out.println();

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class World {

    public static void main(String[] args) {
        System.out.print("Start\n");
        Direction[] directions=new Direction[args.length];
        run(stringToEnum(directions,args));
        out.print("Stop\n");
    }
    public static void run(List<Direction> directions)
    {

        directions.stream().forEach(d->{if(d!=null) {d.write();}});
    }
    public static List<Direction> stringToEnum(Direction[] directions,String[] args)
    {
    	
    	return Arrays.stream(args).map(element->{
    		return Direction.convert(element);})
    			.collect(Collectors.toList());
    }
   
}
