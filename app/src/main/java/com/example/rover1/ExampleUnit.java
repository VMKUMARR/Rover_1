package com.example.rover1;

public class ExampleUnit {

    private int[] coordinates = {0, 0, 0}; // x, y, z coordinates
    private String direction = "N"; // Initial direction: N

    public int[] getCoordinates() {
        return coordinates;
    }
    public String getDirection(){
        return direction;
    }
    public void setDirection(String direction){
        this.direction = direction;
    }

    public void move(String command) {
        int step = command.equals("f") ? 1 : -1;

        if (direction.equals("N") || direction.equals("S")) {
            coordinates[1] += step;
        } else if (direction.equals("E") || direction.equals("W")) {
            coordinates[0] += step;
        } else if (direction.equals("Up") || direction.equals("Down")) {
            coordinates[2] += step;
        }
    }

}
