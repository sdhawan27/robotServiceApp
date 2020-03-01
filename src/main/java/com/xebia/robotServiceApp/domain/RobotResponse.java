package com.xebia.robotServiceApp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RobotResponse {
    private Long robotId;

    private String message;

    private String exceptionMessage;

}
