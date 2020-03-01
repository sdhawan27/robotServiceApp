package com.xebia.robotServiceApp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name="robot")
public class RobotEntity {

    @Column(name="robot_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="min_battery")
    private Integer minBattery;

    @Column(name="max_weight")
    private Integer maxWeight;

    @Column(name="battery_per_kg")
    private Integer batteryPerKg;

    @Column(name="walk_per_charge")
    private Integer walkPerCharge;

}
