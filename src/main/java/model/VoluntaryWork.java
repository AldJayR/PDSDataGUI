package model;

import java.time.LocalDate;

public class VoluntaryWork {

    private String organizationName;
    private String organizationAddress;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int numberOfHours;
    private String positionNatureOfWork;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationAddress() {
        return organizationAddress;
    }

    public void setOrganizationAddress(String organizationAddress) {
        this.organizationAddress = organizationAddress;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public String getPositionNatureOfWork() {
        return positionNatureOfWork;
    }

    public void setPositionNatureOfWork(String positionNatureOfWork) {
        this.positionNatureOfWork = positionNatureOfWork;
    }
}
