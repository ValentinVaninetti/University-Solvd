package com.solvd.entities.university;

import org.apache.logging.log4j.LogManager;

import java.util.LinkedList;
import java.util.List;

public class PublicUniversity extends University {

    private static final int MONTHLY_STATE_SUBSIDY = 30000;
    private static final String COIN_TYPE = "USD";
    private LinkedList<String> benefits;

    public PublicUniversity(String name, String location, List<Department> departmentList, LinkedList<String> benefits) {
        super(name, location, departmentList);
        this.benefits = benefits;
        this.LOGGER = LogManager.getLogger(PublicUniversity.class);
    }

    public LinkedList<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(LinkedList<String> benefits) {
        this.benefits = benefits;
    }

}
