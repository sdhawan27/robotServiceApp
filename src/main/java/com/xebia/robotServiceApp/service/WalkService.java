package com.xebia.robotServiceApp.service;

import com.xebia.robotServiceApp.domain.Robot;
import com.xebia.robotServiceApp.domain.RobotResponse;
import com.xebia.robotServiceApp.entity.RobotEntity;
import com.xebia.robotServiceApp.exception.RobotException;
import com.xebia.robotServiceApp.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class WalkService {

    @Autowired
    private RobotRepository rRepo;

    public RobotResponse walk(final Robot robot) throws Exception {

        int batteryRemaining = robot.getBatteryRemaining();
        double distanceTravelled = 0.0;

        RobotEntity robotEntity = null;
        RobotResponse response = null;

        try {
            robotEntity = rRepo.findById(robot.getRobotId()).get();
            int minBattery = robotEntity.getMinBattery();

            if (minBattery > batteryRemaining) {
                throw new RobotException("Low Battery");
            } else {
                int walkPerCharge = robotEntity.getWalkPerCharge();
                distanceTravelled = (walkPerCharge * batteryRemaining) / 100;

                response = new RobotResponse();
                response.setRobotId(robot.getRobotId());
                response.setMessage("Robot walked for" + distanceTravelled + "kms");
            }
        }
        catch (NoSuchElementException e){
            throw new RobotException("No Robot Available");
        }
            return response;
    }
}
