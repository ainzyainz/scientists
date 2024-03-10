package utils;

import robot.RobotPart;

public class Utils {

    public static boolean FLAG = false;

    private Utils() {
    }

    public static String  getNightNumber(int start) {
   return String.format("%s%s%d%s%s%s", (char) 27,  "[34mNight ", start, " started", (char) 27, "[0m");
    }

    public static String getFinalCountOfCreatedRobots(String message, String name, int countOfRobot) {
        return String.format("%s%s%s%s%d%s%s", (char) 27, message, name, " ", countOfRobot, (char) 27, "[0m");
    }

    public static String getRobotPart(String name, RobotPart temp) {
        return String.format("%s%s%s", name, " got detail ", temp);
    }

    public static String checkingMessage(String message, String name, int countOfRobot) {
        return String.format("%s%s%s%s%d%s%s%s", (char) 27, message, name, " created ", countOfRobot, " robots ",
                (char) 27, "[0m"
        );
    }

    public static String resultOfCompetition(String name, int countOfRobot) {
        return String.format("%s%s%s%s%d%s%s%s", (char) 27, "[33m", name , " won with ", countOfRobot, " robots",
                (char) 27, "[0m"
                );
    }

    public static String tieResultOfCompetition(int countOfRobot) {
        return  String.format("%s%s%d%s%s%s",(char) 27, "[31mIt's a tie! Nobody won with ", countOfRobot, " robots",
                (char) 27, "[0m"
                );
    }
}
