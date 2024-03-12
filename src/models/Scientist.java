package models;

import robot.RobotPart;
import utils.RobotMakerUtils;
import utils.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Constant.*;
import static utils.Utils.*;

public class Scientist implements Runnable {

    private static final Logger LOGGER = Logger.getLogger(Scientist.class.getName());

    private final List<RobotPart> storage = new ArrayList<>();
    private final BlockingQueue<RobotPart> dump;
    private final String name;
    private final String message;

    private int countOfRobots = START_COUNT_OF_ROBOTS;
    private final Set<RobotPart> tempRobot = new HashSet<>();


    public Scientist(String name, BlockingQueue<RobotPart> dump, String message) {
        this.name = name;
        this.dump = dump;
        this.message = message;
    }

    @Override
    public void run() {
        while (!FLAG) {
            int randomValue = RANDOM.nextInt(MAX_NUMBER_OF_THROWS_ROBOT_PART) + 1;
            for (int l = 0; l < randomValue; l++) {
                try {
                    removing();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                RobotMakerUtils.checking(storage, tempRobot, this);
            }
            Utils.delay();
        }
        LOGGER.log(Level.INFO, getFinalCountOfCreatedRobots(message, name, countOfRobots));
    }

    public void setCountOfRobots(int countOfRobots) {
        this.countOfRobots = countOfRobots;
    }

    public void removing() throws InterruptedException {
        if (dump.isEmpty()) {
            return;
        }
        RobotPart temp = dump.poll(DELAY_FOR_THROW_DETAILS, TimeUnit.MILLISECONDS);
        if (temp != null) {
            storage.add(temp);
            LOGGER.log(Level.INFO, getRobotPart(name, temp));
        }
    }

    public int getCountOfRobots() {
        return countOfRobots;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
