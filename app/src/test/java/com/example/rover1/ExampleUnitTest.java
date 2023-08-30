package com.example.rover1;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class ExampleUnitTest {

    private ExampleUnit rover;

    @Before
    public void setUp() {
        rover = new ExampleUnit();
    }

    @Test
    public void testMoveForward() {
        rover.move("f");
        int[] expectedCoordinates = {0, 1, 0};
        assertArrayEquals(expectedCoordinates, rover.getCoordinates());
    }

    @Test
    public void testMoveBackward() {
        rover.move("b");
        int[] expectedCoordinates = {0, -1, 0};
        assertArrayEquals(expectedCoordinates, rover.getCoordinates());
    }

}