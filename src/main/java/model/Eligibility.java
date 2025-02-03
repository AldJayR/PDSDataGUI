package model;

import java.time.LocalDate;

public class Eligibility {

    private String careerService;
    private String rating;
    private LocalDate dateOfExamination; 
    private String placeOfExamination;
    private String licenseNumber;
    private LocalDate licenseDateOfValidity;

    // Constructor
    public Eligibility() {
    }

    // Getters and Setters
    public String getCareerService() {
        return careerService;
    }

    public void setCareerService(String careerService) {
        this.careerService = careerService;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public LocalDate getDateOfExamination() {
        return dateOfExamination;
    }

    public void setDateOfExamination(LocalDate dateOfExamination) {
        this.dateOfExamination = dateOfExamination;
    }

    public String getPlaceOfExamination() {
        return placeOfExamination;
    }

    public void setPlaceOfExamination(String placeOfExamination) {
        this.placeOfExamination = placeOfExamination;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public LocalDate getLicenseDateOfValidity() {
        return licenseDateOfValidity;
    }

    public void setLicenseDateOfValidity(LocalDate licenseDateOfValidity) {
        this.licenseDateOfValidity = licenseDateOfValidity;
    }
}
