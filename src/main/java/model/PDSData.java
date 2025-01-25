package model;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class PDSData {

    // I. Personal Information
    private String surname;
    private String firstName;
    private String middleName;
    private String nameExtension;
    private LocalDate dateOfBirth;
    private String placeOfBirth;
    private Sex sex; // Enum
    private CivilStatus civilStatus; // Enum
    private double height; // In meters
    private double weight; // In kilograms
    private String bloodType;
    private String gsisIdNo;
    private String pagibigIdNo;
    private String philhealthNo;
    private String sssNo;
    private String tinNo;
    private String agencyEmployeeNo;
    private String citizenship;
    private boolean dualCitizenship;
    private String dualCitizenshipType; // by birth, by naturalization
    private String dualCitizenshipCountry;
    private String residentialHouseBlockLot;
    private String residentialStreet;
    private String residentialSubdivisionVillage;
    private String residentialBarangay;
    private String residentialCityMunicipality;
    private String residentialProvince;
    private String residentialZipCode;
    private String permanentHouseBlockLot;
    private String permanentStreet;
    private String permanentSubdivisionVillage;
    private String permanentBarangay;
    private String permanentCityMunicipality;
    private String permanentProvince;
    private String permanentZipCode;
    private String telephoneNo;
    private String mobileNo;
    private String emailAddress;

    // II. Family Background
    private String spouseSurname;
    private String spouseFirstName;
    private String spouseMiddleName;
    private String spouseNameExtension;
    private String spouseOccupation;
    private String spouseEmployerBusinessName;
    private String spouseBusinessAddress;
    private String spouseTelephoneNo;
    private String fatherSurname;
    private String fatherFirstName;
    private String fatherMiddleName;
    private String fatherNameExtension;
    private String motherMaidenName;
    private String motherSurname;
    private String motherFirstName;
    private String motherMiddleName;
    private List<Child> children;

    // III. Educational Background
    private List<Education> educationList;

    // Constructor
    public PDSData() {
        educationList = new ArrayList<>();
        children = new ArrayList<>();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getNameExtension() {
        return nameExtension;
    }

    public void setNameExtension(String nameExtension) {
        this.nameExtension = nameExtension;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public CivilStatus getCivilStatus() {
        return civilStatus;
    }

    public void setCivilStatus(CivilStatus civilStatus) {
        this.civilStatus = civilStatus;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getGsisIdNo() {
        return gsisIdNo;
    }

    public void setGsisIdNo(String gsisIdNo) {
        this.gsisIdNo = gsisIdNo;
    }

    public String getPagibigIdNo() {
        return pagibigIdNo;
    }

    public void setPagibigIdNo(String pagibigIdNo) {
        this.pagibigIdNo = pagibigIdNo;
    }

    public String getPhilhealthNo() {
        return philhealthNo;
    }

    public void setPhilhealthNo(String philhealthNo) {
        this.philhealthNo = philhealthNo;
    }

    public String getSssNo() {
        return sssNo;
    }

    public void setSssNo(String sssNo) {
        this.sssNo = sssNo;
    }

    public String getTinNo() {
        return tinNo;
    }

    public void setTinNo(String tinNo) {
        this.tinNo = tinNo;
    }

    public String getAgencyEmployeeNo() {
        return agencyEmployeeNo;
    }

    public void setAgencyEmployeeNo(String agencyEmployeeNo) {
        this.agencyEmployeeNo = agencyEmployeeNo;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public boolean isDualCitizenship() {
        return dualCitizenship;
    }

    public void setDualCitizenship(boolean dualCitizenship) {
        this.dualCitizenship = dualCitizenship;
    }

    public String getDualCitizenshipType() {
        return dualCitizenshipType;
    }

    public void setDualCitizenshipType(String dualCitizenshipType) {
        this.dualCitizenshipType = dualCitizenshipType;
    }

    public String getDualCitizenshipCountry() {
        return dualCitizenshipCountry;
    }

    public void setDualCitizenshipCountry(String dualCitizenshipCountry) {
        this.dualCitizenshipCountry = dualCitizenshipCountry;
    }

    public String getResidentialHouseBlockLot() {
        return residentialHouseBlockLot;
    }

    public void setResidentialHouseBlockLot(String residentialHouseBlockLot) {
        this.residentialHouseBlockLot = residentialHouseBlockLot;
    }

    public String getResidentialStreet() {
        return residentialStreet;
    }

    public void setResidentialStreet(String residentialStreet) {
        this.residentialStreet = residentialStreet;
    }

    public String getResidentialSubdivisionVillage() {
        return residentialSubdivisionVillage;
    }

    public void setResidentialSubdivisionVillage(String residentialSubdivisionVillage) {
        this.residentialSubdivisionVillage = residentialSubdivisionVillage;
    }

    public String getResidentialBarangay() {
        return residentialBarangay;
    }

    public void setResidentialBarangay(String residentialBarangay) {
        this.residentialBarangay = residentialBarangay;
    }

    public String getResidentialCityMunicipality() {
        return residentialCityMunicipality;
    }

    public void setResidentialCityMunicipality(String residentialCityMunicipality) {
        this.residentialCityMunicipality = residentialCityMunicipality;
    }

    public String getResidentialProvince() {
        return residentialProvince;
    }

    public void setResidentialProvince(String residentialProvince) {
        this.residentialProvince = residentialProvince;
    }

    public String getResidentialZipCode() {
        return residentialZipCode;
    }

    public void setResidentialZipCode(String residentialZipCode) {
        this.residentialZipCode = residentialZipCode;
    }

    public String getPermanentHouseBlockLot() {
        return permanentHouseBlockLot;
    }

    public void setPermanentHouseBlockLot(String permanentHouseBlockLot) {
        this.permanentHouseBlockLot = permanentHouseBlockLot;
    }

    public String getPermanentStreet() {
        return permanentStreet;
    }

    public void setPermanentStreet(String permanentStreet) {
        this.permanentStreet = permanentStreet;
    }

    public String getPermanentSubdivisionVillage() {
        return permanentSubdivisionVillage;
    }

    public void setPermanentSubdivisionVillage(String permanentSubdivisionVillage) {
        this.permanentSubdivisionVillage = permanentSubdivisionVillage;
    }

    public String getPermanentBarangay() {
        return permanentBarangay;
    }

    public void setPermanentBarangay(String permanentBarangay) {
        this.permanentBarangay = permanentBarangay;
    }

    public String getPermanentCityMunicipality() {
        return permanentCityMunicipality;
    }

    public void setPermanentCityMunicipality(String permanentCityMunicipality) {
        this.permanentCityMunicipality = permanentCityMunicipality;
    }

    public String getPermanentProvince() {
        return permanentProvince;
    }

    public void setPermanentProvince(String permanentProvince) {
        this.permanentProvince = permanentProvince;
    }

    public String getPermanentZipCode() {
        return permanentZipCode;
    }

    public void setPermanentZipCode(String permanentZipCode) {
        this.permanentZipCode = permanentZipCode;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSpouseSurname() {
        return spouseSurname;
    }

    public void setSpouseSurname(String spouseSurname) {
        this.spouseSurname = spouseSurname;
    }

    public String getSpouseFirstName() {
        return spouseFirstName;
    }

    public void setSpouseFirstName(String spouseFirstName) {
        this.spouseFirstName = spouseFirstName;
    }

    public String getSpouseMiddleName() {
        return spouseMiddleName;
    }

    public void setSpouseMiddleName(String spouseMiddleName) {
        this.spouseMiddleName = spouseMiddleName;
    }

    public String getSpouseNameExtension() {
        return spouseNameExtension;
    }

    public void setSpouseNameExtension(String spouseNameExtension) {
        this.spouseNameExtension = spouseNameExtension;
    }

    public String getSpouseOccupation() {
        return spouseOccupation;
    }

    public void setSpouseOccupation(String spouseOccupation) {
        this.spouseOccupation = spouseOccupation;
    }

    public String getSpouseEmployerBusinessName() {
        return spouseEmployerBusinessName;
    }

    public void setSpouseEmployerBusinessName(String spouseEmployerBusinessName) {
        this.spouseEmployerBusinessName = spouseEmployerBusinessName;
    }

    public String getSpouseBusinessAddress() {
        return spouseBusinessAddress;
    }

    public void setSpouseBusinessAddress(String spouseBusinessAddress) {
        this.spouseBusinessAddress = spouseBusinessAddress;
    }

    public String getSpouseTelephoneNo() {
        return spouseTelephoneNo;
    }

    public void setSpouseTelephoneNo(String spouseTelephoneNo) {
        this.spouseTelephoneNo = spouseTelephoneNo;
    }

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getFatherFirstName() {
        return fatherFirstName;
    }

    public void setFatherFirstName(String fatherFirstName) {
        this.fatherFirstName = fatherFirstName;
    }

    public String getFatherMiddleName() {
        return fatherMiddleName;
    }

    public void setFatherMiddleName(String fatherMiddleName) {
        this.fatherMiddleName = fatherMiddleName;
    }

    public String getFatherNameExtension() {
        return fatherNameExtension;
    }

    public void setFatherNameExtension(String fatherNameExtension) {
        this.fatherNameExtension = fatherNameExtension;
    }

    public String getMotherMaidenName() {
        return motherMaidenName;
    }

    public void setMotherMaidenName(String motherMaidenName) {
        this.motherMaidenName = motherMaidenName;
    }

    public String getMotherSurname() {
        return motherSurname;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    public String getMotherFirstName() {
        return motherFirstName;
    }

    public void setMotherFirstName(String motherFirstName) {
        this.motherFirstName = motherFirstName;
    }

    public String getMotherMiddleName() {
        return motherMiddleName;
    }

    public void setMotherMiddleName(String motherMiddleName) {
        this.motherMiddleName = motherMiddleName;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }
    
    
}
