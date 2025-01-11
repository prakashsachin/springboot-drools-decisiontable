package com.drools.example.model;

import java.util.List;

public class EligibilityResponse {
    private List<String> eligibleRoles;
    private int salaryPerAnnum;

    public List<String> getEligibleRoles() {
        return eligibleRoles;
    }

    public void setEligibleRoles(List<String> eligibleRoles) {
        this.eligibleRoles = eligibleRoles;
    }

    public int getSalaryPerAnnum() {
        return salaryPerAnnum;
    }

    public void setSalaryPerAnnum(int salaryPerAnnum) {
        this.salaryPerAnnum = salaryPerAnnum;
    }
}
