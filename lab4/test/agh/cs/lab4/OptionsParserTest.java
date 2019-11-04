package agh.cs.lab4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionsParserTest {
    @Test
    public void totallyWrongInput() {
        String[] input =
                {
                        "Hello",
                        "World",
                        "xasd",
                        "t"
                };
        MoveDirection[] parsed = OptionsParser.parse(input);
        assertTrue(parsed.length == 0);
    }

    @Test
    public void oneLetterInput() {
        String[] input =
                {
                        "f",
                        "b",
                        "r",
                        "l"
                };
        MoveDirection[] result = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT
        };
        assertEquals(result, OptionsParser.parse(input));
    }

    @Test
    public void fullWordInput() {
        String[] input =
                {
                        "forward",
                        "backward",
                        "right",
                        "left",
                        "forward",
                        "backward"
                };
        MoveDirection[] result = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD
        };
        assertEquals(result, OptionsParser.parse(input));
    }

    @Test
    public void badInputBegEnd() {
        String[] input =
                {
                        "asdsasdwq",
                        "p",
                        "safdgdss",
                        "forward",
                        "backward",
                        "right",
                        "left",
                        "forward",
                        "backward",
                        "asfja",
                        "o"
                };
        MoveDirection[] result = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD
        };
        assertEquals(result, OptionsParser.parse(input));
    }

    @Test
    public void mixedInput() {
        String[] input =
                {
                        "asdsasdwq",
                        "p",
                        "safdgdss",
                        "f",
                        "b",
                        "forward",
                        "backward",
                        "right",
                        "left",
                        "forward",
                        "backward",
                        "asfja",
                        "o"
                };
        MoveDirection[] result = {
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD,
                MoveDirection.RIGHT,
                MoveDirection.LEFT,
                MoveDirection.FORWARD,
                MoveDirection.BACKWARD
        };
        assertEquals(result, OptionsParser.parse(input));
    }

}
