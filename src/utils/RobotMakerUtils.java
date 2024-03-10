package utils;

import models.Scientist;
import robot.RobotPart;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Constant.COUNT_OF_ROBOT_PART;
import static utils.Utils.checkingMessage;

public class RobotMakerUtils {

    private static final Logger LOGGER = Logger.getLogger(RobotMakerUtils.class.getName());

    public static void makeRobot(Set<RobotPart> tempRobot, Scientist scientist){
        if (tempRobot.size() == COUNT_OF_ROBOT_PART) {
            scientist.setCountOfRobots(scientist.getCountOfRobots()+1);
            LOGGER.log(Level.INFO, checkingMessage(scientist.getMessage(), scientist.getName(), scientist.getCountOfRobots()));
            tempRobot.clear();
        }
    }
    public static void checking(List<RobotPart> storage, Set<RobotPart> tempRobot, Scientist scientist) {
        for (int i = 0; i < storage.size() - 1; i++) {
            if (!tempRobot.contains(storage.get(i))) {
                tempRobot.add(storage.remove(i));
            }
            makeRobot(tempRobot,scientist);
        }
    }
}
