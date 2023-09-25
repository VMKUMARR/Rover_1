package com.example.rover1;

public class ExampleUnit {

    private final int[] coordinates = {0, 0, 0}; // coordinates
    private String direction = "N"; // Initial direction:
    private  String prevdirection = "N";



    public int[] getCoordinates() {

        return coordinates;
    }
    public String getDirection(){
        return direction;
    }
//    public void setDirection(String direction){
//        this.direction = direction;
//    }

    public void move(String command) {
        int step = command.equals("f") ? 1 : -1;

        switch (direction) {
            case "N":
            case "S":
                coordinates[1] += step;
                break;
            case "E":
            case "W":
                coordinates[0] += step;
                break;
            case "Up":
            case "Down":
                coordinates[2] += step;
                break;
        }
    }

    public void turn(String command){
        if(command.equals("r")){
            switch (direction){
                case "N":

                    direction = "E";
                    break;
                case "E":
                    direction = "S";
                    break;
                case "S":
                    direction = "W";
                    break;
                case "W":
                    direction = "N";
                    break;
                case "Up":
                    switch (prevdirection){
                        case "N":

                            direction = "E";
                            break;
                        case "E":
                            direction = "S";
                            break;
                        case "S":
                            direction = "W";
                            break;
                        case "W":
                            direction = "N";
                            break;
                    }

                    break;
            }

        }else if(command.equals("l")){
            switch (direction){
                case "N":
                    direction = "W";
                    break;
                case "W":
                    direction = "S";
                    break;
                case "S":
                    direction = "E";
                    break;
                case "E":
                    direction = "N";
                    break;
                case "Up":
                    switch (prevdirection){
                        case "N":
                            direction = "W";
                            break;
                        case "W":
                            direction = "S";
                            break;
                        case "S":
                            direction = "E";
                            break;
                        case "E":
                            direction = "N";
                            break;
                    }
                    break;
            }
        }
    }

    public void angle(String command){
        if(command.equals("u")){
            prevdirection = getDirection();
            direction ="Up";
        }else if(command.equals("d")){
            prevdirection = getDirection();
            direction  = "Down";
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
