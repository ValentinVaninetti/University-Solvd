package com.solvd.entities.university;

import com.solvd.utils.CommonUtils;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class PublicUniversity extends University {

    private static final String SRC_MAIN_RESOURCES = "src/main/resources/";
    private static final String CONFIGURATION_PROPERTIES = "configuration.properties";
    private final int MONTHLY_STATE_SUBSIDY;
    private final String COIN_TYPE;
    private LinkedList<String> benefits;

    public PublicUniversity(String name, String location, List<Department> departmentList, LinkedList<String> benefits) throws IOException {
        super(name, location, departmentList);
        this.benefits = benefits;
        this.MONTHLY_STATE_SUBSIDY = Integer.parseInt(CommonUtils.readPropertiesFile(SRC_MAIN_RESOURCES + CONFIGURATION_PROPERTIES, "MONTHLY_STATE_SUBSIDY"));
        this.COIN_TYPE = CommonUtils.readPropertiesFile(SRC_MAIN_RESOURCES + CONFIGURATION_PROPERTIES, "COIN_TYPE");
        this.LOGGER = LogManager.getLogger(PublicUniversity.class);
    }

    public int getMonthlyStateSubsidy() {
        return MONTHLY_STATE_SUBSIDY;
    }

    public String getCoinType() {
        return COIN_TYPE;
    }

    public LinkedList<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(LinkedList<String> benefits) {
        this.benefits = benefits;
    }

}
