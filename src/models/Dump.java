package models;

import robot.RobotPart;
import utils.Utils;

import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Constant.*;
import static utils.Utils.*;

public class Dump implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(Dump.class.getName());
    private final BlockingQueue<RobotPart> dump;

    public Dump(BlockingQueue<RobotPart> dump) {
        this.dump = dump;
        throwRobotParts(START_COUNT_OF_ROBOTS_IN_DUMP);
    }

    @Override
    public void run() {
        int start = 0;
        while (start != COUNT_OF_NIGHT) {
            start++;
            LOGGER.log(Level.INFO, getNightNumber(start));
            int randomValue = RANDOM.nextInt(MAX_NUMBER_OF_THROWS_ROBOT_PART) + 1;
            throwRobotParts(randomValue);
            Utils.delay();
        }
        finishing();
    }

    private void finishing() {
        LOGGER.log(Level.INFO, FINISH_MESSAGE);
        FLAG = true;
    }

    private void throwRobotParts(int counter) {
        for (int l = 0; l < counter; l++) {
            dump.add(RobotPart.values()[RANDOM.nextInt((RobotPart.values().length))]);
        }
    }
}

