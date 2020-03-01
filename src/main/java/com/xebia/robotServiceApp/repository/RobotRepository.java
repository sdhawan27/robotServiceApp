package com.xebia.robotServiceApp.repository;

import com.xebia.robotServiceApp.entity.RobotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RobotRepository extends JpaRepository<RobotEntity,Long> {
}
