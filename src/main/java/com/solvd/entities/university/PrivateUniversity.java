package com.solvd.entities.university;

import org.apache.logging.log4j.LogManager;

import java.util.List;

public class PrivateUniversity extends University {
    private int monthlyFee;
    private String coinType = "USD";

    public PrivateUniversity(String name, String location, List<Department> departmentList, int fee, String coinType) {
        super(name, location, departmentList);
        this.monthlyFee = fee;
        this.coinType = coinType;
        this.LOGGER = LogManager.getLogger(PrivateUniversity.class);
    }

    public PrivateUniversity(String name, String location, List<Department> departmentList, int fee) {
        super(name, location, departmentList);
        this.monthlyFee = fee;
        this.LOGGER = LogManager.getLogger(PrivateUniversity.class);
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public String getCoinType() {
        return coinType;
    }

    public void setCoinType(String coinType) {
        this.coinType = coinType;
    }
}
