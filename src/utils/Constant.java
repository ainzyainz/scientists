package utils;

import robot.RobotPart;

import java.util.Random;

public class Constant {

    public static final int COUNT_OF_ROBOT_PART = RobotPart.values().length;
    public static final int MAX_NUMBER_OF_THROWS_ROBOT_PART = 4;
    public static final int COUNT_OF_NIGHT = 100;
    public static final int DELAY_FOR_THROW_DETAILS = 100;
    public static final Random RANDOM = new Random();

    public static final int DELAY_FOR_FINISH = 100;
    public static final int START_COUNT_OF_ROBOTS_IN_DUMP = 20;
    public static final int START_COUNT_OF_ROBOTS = 0;
    public static final String FINISH_MESSAGE = "!!!Program finished!!!";
    public static final String NAME_OF_FIRST_SCIENTIST = "First Scientist";
    public static final String NAME_OF_SECOND_SCIENTIST = "Second Scientist";
    public static final String FIRST_SCIENTIST_MESSAGE_COLOR = "[32m";
    public static final String SECOND_SCIENTIST_MESSAGE_COLOR = "[36m";

    public static final String MAIN_START = "Начало работы метода main";
    public static final String MAIN_END = "Конец работы метода main";

    private Constant() {
    }
}
