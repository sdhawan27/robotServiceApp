package com.xebia.robotServiceApp.controller;

import com.xebia.robotServiceApp.domain.Robot;
import com.xebia.robotServiceApp.domain.RobotResponse;
import com.xebia.robotServiceApp.service.ProductPriceService;
import com.xebia.robotServiceApp.service.WalkService;
import com.xebia.robotServiceApp.service.WeightLiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@RestController("/robot")
public class RController {

    @Autowired
    private ProductPriceService ppService;

    @Autowired
    private WalkService walkService;

    @Autowired
    private WeightLiftService weightLiftService;

    /**
     * This service tests if robot has enough battery to walk , if no throws exception
     * else returns walked for those many kms.
     * @param robot
     * @return
     * @throws Exception
     */
    @PostMapping(path="/walk", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RobotResponse> walkingService(@RequestBody Robot robot) throws Exception{
        return ResponseEntity.ok(walkService.walk(robot));
    }

    @PostMapping(path="/liftWeight", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RobotResponse> liftWeight(@RequestBody Robot robot) throws Exception{
        return ResponseEntity.ok(weightLiftService.lift(robot));
    }


    /**
     * This service assumes bc is bar code generated by Scan Service already available.
     * @param robot
     * @return
     * @throws Exception
     */
    @PostMapping(path="/scan", consumes = "application/json", produces = "application/json")
    public ResponseEntity<RobotResponse> displayPrice(@RequestBody Robot robot) throws Exception{
        return ResponseEntity.ok(ppService.getProductPrice(robot));
    }

}
