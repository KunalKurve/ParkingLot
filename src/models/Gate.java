package models;

import models.enums.GateStatus;
import models.enums.GateType;

public class Gate extends BaseEntity{

    private Long gateNo;
    private GateType gateType;
    private GateStatus gateStatus;
    // if not kept operator, then while creating Ticket from where we will get it
    private Operator currentOperator;

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }

    public Long getGateNo() {
        return gateNo;
    }

    public void setGateNo(Long gateNo) {
        this.gateNo = gateNo;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }
}
