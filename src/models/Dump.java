package models;

import robot.RobotPart;

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
        for (int i = 0; i < START_COUNT_OF_ROBOTS_IN_DUMP; i++) {
            throwRobotParts();
        }
    }

    @Override
    public void run() {
        int start = 0;
        while (start != COUNT_OF_NIGHT) {
            start++;
            LOGGER.log(Level.INFO, getNightNumber(start));
            int randomValue = RANDOM.nextInt(MAX_NUMBER_OF_THROWS_ROBOT_PART)+1;
            for (int l = 0; l < randomValue; l++) {
                throwRobotParts();
            }
            try {
                Thread.sleep(DELAY_FOR_THROW_DETAILS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        finishing();
    }

    private void finishing() {
        LOGGER.log(Level.INFO, FINISH_MESSAGE);
        FLAG = true;
        Thread.currentThread().interrupt();
    }

    private void throwRobotParts() {
        dump.add(RobotPart.values()[RANDOM.nextInt((RobotPart.values().length))]);
    }
}
