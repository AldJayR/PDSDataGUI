package model;

import java.time.LocalDate;

public class Training {

    private String title;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int numberOfHours;
    private String typeOfLd;
    private String conductedBy;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getTypeOfLd() {
        return typeOfLd;
    }

    public void setTypeOfLd(String typeOfLd) {
        this.typeOfLd = typeOfLd;
    }

    public String getConductedBy() {
        return conductedBy;
    }

    public void setConductedBy(String conductedBy) {
        this.conductedBy = conductedBy;
    }
}
