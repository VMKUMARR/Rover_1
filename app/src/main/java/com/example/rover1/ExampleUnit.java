package com.example.rover1;

public class ExampleUnit {

    private int[] coordinates = {0, 0, 0}; // coordinates
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

    public void turn(String command) {
        if (command.equals("l")) {
            if (direction.equals("N")) direction = "W";
            else if (direction.equals("W")) direction = "S";
            else if (direction.equals("S")) direction = "E";
            else if (direction.equals("E")) direction = "N";
        } else if (command.equals("r")) {
            if (direction.equals("N")) direction = "E";
            else if (direction.equals("E")) direction = "S";
            else if (direction.equals("S")) direction = "W";
            else if (direction.equals("W")) direction = "N";
        }
    }

    public void angle(String command) {
        if ("u".equals(command)) {
            direction = "Up";
        } else if ("d".equals(command)) {
            direction = "Down";
        } else {
            // Handle invalid angle
        }
    }


    public void executeCommands(String[] commands) {
        for (String command : commands) {
            if ("f".equals(command) || "b".equals(command)) {
                move(command);
            } else if ("l".equals(command) || "r".equals(command)) {
                turn(command);
            } else if ("u".equals(command) || "d".equals(command)) {
                angle(command);
            }
        }
    }

}
