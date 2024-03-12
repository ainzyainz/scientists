package utils;

import models.Scientist;

import java.util.logging.Level;
import java.util.logging.Logger;

import static utils.Utils.resultOfCompetition;
import static utils.Utils.tieResultOfCompetition;


public class ResultUtils {

    private static final Logger LOGGER = Logger.getLogger(ResultUtils.class.getName());

    private ResultUtils() {
    }

    public static void getResults(Scientist sc1, Scientist sc2) {
        if (sc1.getCountOfRobots() < sc2.getCountOfRobots()) {
            LOGGER.log(Level.INFO, resultOfCompetition(sc2.getName(), sc2.getCountOfRobots()));
        } else if (sc1.getCountOfRobots() > sc2.getCountOfRobots()) {
            LOGGER.log(Level.INFO, resultOfCompetition(sc1.getName(), sc1.getCountOfRobots()));
        } else {
            LOGGER.log(Level.INFO, tieResultOfCompetition(sc1.getCountOfRobots()));
        }
    }
}
