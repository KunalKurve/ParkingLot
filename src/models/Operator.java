package models;

import models.enums.OperatorStatus;

import java.time.Duration;
import java.util.Date;

public class Operator extends BaseEntity{

    private String name;
    private Duration shiftTime;
    private OperatorStatus operatorStatus;
    //private Long empId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(Duration shiftTime) {
        this.shiftTime = shiftTime;
    }

    public OperatorStatus getOperatorStatus() {
        return operatorStatus;
    }

    public void setOperatorStatus(OperatorStatus operatorStatus) {
        this.operatorStatus = operatorStatus;
    }
}
