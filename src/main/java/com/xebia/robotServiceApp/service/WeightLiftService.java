
package com.xebia.robotServiceApp.service;

import com.xebia.robotServiceApp.domain.Robot;
import com.xebia.robotServiceApp.domain.RobotResponse;
import com.xebia.robotServiceApp.entity.RobotEntity;
import com.xebia.robotServiceApp.exception.RobotException;
import com.xebia.robotServiceApp.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WeightLiftService {

    @Autowired
    RobotRepository rRepo;

    public RobotResponse lift(Robot robot) throws RobotException {

        RobotResponse rResponse = new RobotResponse();
        rResponse.setRobotId(robot.getRobotId());

        try {
            Optional<RobotEntity> robotEntity = rRepo.findById(robot.getRobotId());

            int minBattery = robotEntity.map(r -> r.getMinBattery()).get();
            int batteryRemaining = robot.getBatteryRemaining();

            if (minBattery > batteryRemaining) {
                throw new RobotException("Low Battery");
            }


            int batterRemainingUpdated = robot.getBatteryRemaining();
            int inputWeight = robot.getInputWeight();

            int maxWeightAllowed = robotEntity.map(r -> r.getMaxWeight()).get();
            if (maxWeightAllowed < inputWeight) {
                throw new RobotException("Overweight");
            } else {
                int batteryPerKg = robotEntity.map(r -> r.getBatteryPerKg()).get();
                batterRemainingUpdated = batteryRemaining - (batteryPerKg * inputWeight);
                if (batterRemainingUpdated > 0) {
                    rResponse.setMessage("Weight Lifted" + inputWeight);
                } else {
                    rResponse.setMessage(" all weight couldnot be lifted as battery finished before lifting");
                }
            }
        }catch(NoSuchElementException e){
            throw new RobotException("No Robot Available");
        }
        return rResponse;
    }
}
