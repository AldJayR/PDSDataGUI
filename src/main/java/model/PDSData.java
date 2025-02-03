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

    // IV. Civil Service Eligibility
    private List<Eligibility> eligibilityList;

    // V. Work Experience
    private List<WorkExperience> workExperienceList;

    // VI. Voluntary Work
    private List<VoluntaryWork> voluntaryWorkList;

    // VII. Learning and Development
    private List<Training> trainingList;
    
        // VIII. Other Information
    private List<String> specialSkillsHobbies;
    private List<String> nonAcademicDistinctionsRecognition;
    private List<String> membershipInAssociationsOrganizations;
    
    // IX. Other Questions
    private boolean thirdDegreeRelationship;
    private boolean fourthDegreeRelationship;
    private boolean adminOffense;
    private String adminOffenseDetails;
    private boolean criminallyCharged;
    private LocalDate criminallyChargedDate;
    private String criminallyChargedStatus;
    private boolean convicted;
    private String convictedDetails;
    private boolean separatedService;
    private String separatedServiceDetails;
    private boolean electionCandidate;
    private String electionCandidateDetails;
    private boolean resignedGovt;
    private String resignedGovtDetails;
    private boolean immigrant;
    private String immigrantCountry;
    private boolean indigenous;
    private String indigenousDetails;
    private boolean pwd;
    private String pwdDetails;
    private boolean soloParent;
    private String soloParentDetails;

    // X. References
    private List<Reference> references;

    

    // Constructor
    public PDSData() {
        educationList = new ArrayList<>();
        children = new ArrayList<>();
        eligibilityList = new ArrayList<>();
        workExperienceList = new ArrayList<>();
        voluntaryWorkList = new ArrayList<>();
        trainingList = new ArrayList<>();
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

    public List<Eligibility> getEligibilityList() {
        return eligibilityList;
    }

    public void setEligibilityList(List<Eligibility> eligibilityList) {
        this.eligibilityList = eligibilityList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<Training> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(List<Training> trainingList) {
        this.trainingList = trainingList;
    }

    public List<VoluntaryWork> getVoluntaryWorkList() {
        return voluntaryWorkList;
    }

    public void setVoluntaryWorkList(List<VoluntaryWork> voluntaryWorkList) {
        this.voluntaryWorkList = voluntaryWorkList;
    }

    public List<String> getSpecialSkillsHobbies() {
        return specialSkillsHobbies;
    }

    public void setSpecialSkillsHobbies(List<String> specialSkillsHobbies) {
        this.specialSkillsHobbies = specialSkillsHobbies;
    }

    public List<String> getNonAcademicDistinctionsRecognition() {
        return nonAcademicDistinctionsRecognition;
    }

    public void setNonAcademicDistinctionsRecognition(List<String> nonAcademicDistinctionsRecognition) {
        this.nonAcademicDistinctionsRecognition = nonAcademicDistinctionsRecognition;
    }

    public List<String> getMembershipInAssociationsOrganizations() {
        return membershipInAssociationsOrganizations;
    }

    public void setMembershipInAssociationsOrganizations(List<String> membershipInAssociationsOrganizations) {
        this.membershipInAssociationsOrganizations = membershipInAssociationsOrganizations;
    }

    public boolean isThirdDegreeRelationship() {
        return thirdDegreeRelationship;
    }

    public void setThirdDegreeRelationship(boolean thirdDegreeRelationship) {
        this.thirdDegreeRelationship = thirdDegreeRelationship;
    }

    public boolean isFourthDegreeRelationship() {
        return fourthDegreeRelationship;
    }

    public void setFourthDegreeRelationship(boolean fourthDegreeRelationship) {
        this.fourthDegreeRelationship = fourthDegreeRelationship;
    }

    public boolean isAdminOffense() {
        return adminOffense;
    }

    public void setAdminOffense(boolean adminOffense) {
        this.adminOffense = adminOffense;
    }

    public String getAdminOffenseDetails() {
        return adminOffenseDetails;
    }

    public void setAdminOffenseDetails(String adminOffenseDetails) {
        this.adminOffenseDetails = adminOffenseDetails;
    }

    public boolean isCriminallyCharged() {
        return criminallyCharged;
    }

    public void setCriminallyCharged(boolean criminallyCharged) {
        this.criminallyCharged = criminallyCharged;
    }

    public LocalDate getCriminallyChargedDate() {
        return criminallyChargedDate;
    }

    public void setCriminallyChargedDate(LocalDate criminallyChargedDate) {
        this.criminallyChargedDate = criminallyChargedDate;
    }

    public String getCriminallyChargedStatus() {
        return criminallyChargedStatus;
    }

    public void setCriminallyChargedStatus(String criminallyChargedStatus) {
        this.criminallyChargedStatus = criminallyChargedStatus;
    }

    public boolean isConvicted() {
        return convicted;
    }

    public void setConvicted(boolean convicted) {
        this.convicted = convicted;
    }

    public String getConvictedDetails() {
        return convictedDetails;
    }

    public void setConvictedDetails(String convictedDetails) {
        this.convictedDetails = convictedDetails;
    }

    public boolean isSeparatedService() {
        return separatedService;
    }

    public void setSeparatedService(boolean separatedService) {
        this.separatedService = separatedService;
    }

    public String getSeparatedServiceDetails() {
        return separatedServiceDetails;
    }

    public void setSeparatedServiceDetails(String separatedServiceDetails) {
        this.separatedServiceDetails = separatedServiceDetails;
    }

    public boolean isElectionCandidate() {
        return electionCandidate;
    }

    public void setElectionCandidate(boolean electionCandidate) {
        this.electionCandidate = electionCandidate;
    }

    public String getElectionCandidateDetails() {
        return electionCandidateDetails;
    }

    public void setElectionCandidateDetails(String electionCandidateDetails) {
        this.electionCandidateDetails = electionCandidateDetails;
    }

    public boolean isResignedGovt() {
        return resignedGovt;
    }

    public void setResignedGovt(boolean resignedGovt) {
        this.resignedGovt = resignedGovt;
    }

    public String getResignedGovtDetails() {
        return resignedGovtDetails;
    }

    public void setResignedGovtDetails(String resignedGovtDetails) {
        this.resignedGovtDetails = resignedGovtDetails;
    }

    public boolean isImmigrant() {
        return immigrant;
    }

    public void setImmigrant(boolean immigrant) {
        this.immigrant = immigrant;
    }

    public String getImmigrantCountry() {
        return immigrantCountry;
    }

    public void setImmigrantCountry(String immigrantCountry) {
        this.immigrantCountry = immigrantCountry;
    }

    public boolean isIndigenous() {
        return indigenous;
    }

    public void setIndigenous(boolean indigenous) {
        this.indigenous = indigenous;
    }

    public String getIndigenousDetails() {
        return indigenousDetails;
    }

    public void setIndigenousDetails(String indigenousDetails) {
        this.indigenousDetails = indigenousDetails;
    }

    public boolean isPwd() {
        return pwd;
    }

    public void setPwd(boolean pwd) {
        this.pwd = pwd;
    }

    public String getPwdDetails() {
        return pwdDetails;
    }

    public void setPwdDetails(String pwdDetails) {
        this.pwdDetails = pwdDetails;
    }

    public boolean isSoloParent() {
        return soloParent;
    }

    public void setSoloParent(boolean soloParent) {
        this.soloParent = soloParent;
    }

    public String getSoloParentDetails() {
        return soloParentDetails;
    }

    public void setSoloParentDetails(String soloParentDetails) {
        this.soloParentDetails = soloParentDetails;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }
    
    
}
