package model;

import java.time.LocalDate;

public class WorkExperience {

    private LocalDate dateFrom;
    private LocalDate dateTo;
    private String positionTitle;
    private String departmentAgencyOfficeCompany;
    private String monthlySalary;
    private String salaryGradeStepIncrement;
    private String statusOfAppointment;
    private boolean governmentService;

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

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getDepartmentAgencyOfficeCompany() {
        return departmentAgencyOfficeCompany;
    }

    public void setDepartmentAgencyOfficeCompany(String departmentAgencyOfficeCompany) {
        this.departmentAgencyOfficeCompany = departmentAgencyOfficeCompany;
    }

    public String getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(String monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public String getSalaryGradeStepIncrement() {
        return salaryGradeStepIncrement;
    }

    public void setSalaryGradeStepIncrement(String salaryGradeStepIncrement) {
        this.salaryGradeStepIncrement = salaryGradeStepIncrement;
    }

    public String getStatusOfAppointment() {
        return statusOfAppointment;
    }

    public void setStatusOfAppointment(String statusOfAppointment) {
        this.statusOfAppointment = statusOfAppointment;
    }

    public boolean isGovernmentService() {
        return governmentService;
    }

    public void setGovernmentService(boolean governmentService) {
        this.governmentService = governmentService;
    }
}
