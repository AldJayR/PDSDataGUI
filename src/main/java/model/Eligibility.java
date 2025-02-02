package model;

public class Eligibility {

    private String careerService;
    private String rating;
    private String dateOfExamination;
    private String placeOfExamination;
    private String licenseNumber;
    private String licenseDateOfValidity;

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

    public String getDateOfExamination() {
        return dateOfExamination;
    }

    public void setDateOfExamination(String dateOfExamination) {
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

    public String getLicenseDateOfValidity() {
        return licenseDateOfValidity;
    }

    public void setLicenseDateOfValidity(String licenseDateOfValidity) {
        this.licenseDateOfValidity = licenseDateOfValidity;
    }
}
