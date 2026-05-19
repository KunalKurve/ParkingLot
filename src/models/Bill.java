package models;

import models.enums.BillStatus;

import java.util.Date;
import java.util.List;

public class Bill extends BaseEntity{

    private Date exitTime;
    private List<Payment> payments;
    private Operator operator;
    private Gate exitGate;
    private Ticket ticket;
    private Double totalAmount;
    private BillStatus billStatus;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public void setExitGate(Gate exitGate) {
        this.exitGate = exitGate;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double amount) {
        this.totalAmount = amount;
    }
}
