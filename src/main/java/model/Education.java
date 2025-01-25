package model;

import java.time.LocalDate;

public class Education {

    private String level;
    private String schoolName;
    private String degreeCourse;
    private LocalDate yearFrom;
    private LocalDate yearTo;
    private String highestLevelUnitsEarned;
    private String yearGraduated;
    private String academicHonorsReceived;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getDegreeCourse() {
        return degreeCourse;
    }

    public void setDegreeCourse(String degreeCourse) {
        this.degreeCourse = degreeCourse;
    }

    public LocalDate getYearFrom() {
        return yearFrom;
    }

    public void setYearFrom(LocalDate yearFrom) {
        this.yearFrom = yearFrom;
    }

    public LocalDate getYearTo() {
        return yearTo;
    }

    public void setYearTo(LocalDate yearTo) {
        this.yearTo = yearTo;
    }

    public String getHighestLevelUnitsEarned() {
        return highestLevelUnitsEarned;
    }

    public void setHighestLevelUnitsEarned(String highestLevelUnitsEarned) {
        this.highestLevelUnitsEarned = highestLevelUnitsEarned;
    }

    public String getYearGraduated() {
        return yearGraduated;
    }

    public void setYearGraduated(String yearGraduated) {
        this.yearGraduated = yearGraduated;
    }

    public String getAcademicHonorsReceived() {
        return academicHonorsReceived;
    }

    public void setAcademicHonorsReceived(String academicHonorsReceived) {
        this.academicHonorsReceived = academicHonorsReceived;
    }
    
    
}
