package controller;

import model.PDSData;
import model.Child;
import model.Education;
import model.Eligibility;
import model.WorkExperience;
import model.VoluntaryWork;
import model.Training;
import model.Reference;
import view.PDSNewForm;
import view.EducationPanel;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PDSController {

    private PDSData model;
    private PDSNewForm view;

    public PDSController(PDSData model, PDSNewForm view) {
        this.model = model;
        this.view = view;
    }

    public void handleSubmit() {
        // Retrieve data from all panels and update the model
        updateModelFromPersonalInfoPanel();
        updateModelFromFamilyBackgroundPanel();
        updateModelFromEducationPanel();
        updateModelFromEligibilityPanel();
        updateModelFromWorkExperiencePanel();
        updateModelFromVoluntaryWorkPanel();
        updateModelFromTrainingPanel();
        updateModelFromOtherInfoPanel();

        if (!validateData()) {
            return; 
        }
        String summary = formatSummary();

        view.displaySummary(summary);

       // Switch to the Summary tab
        int summaryTabIndex = view.getSummaryTabIndex();
        view.switchToTab(summaryTabIndex);
        view.scrollToTop();
    }

    private void updateModelFromPersonalInfoPanel() {
        // view.getPersonalInfoPanel().refreshData();
        model.setSurname(view.getPersonalInfoPanel().getSurname());
        model.setFirstName(view.getPersonalInfoPanel().getFirstName());
        model.setMiddleName(view.getPersonalInfoPanel().getMiddleName());
        model.setNameExtension(view.getPersonalInfoPanel().getNameExtension());
        model.setDateOfBirth(view.getPersonalInfoPanel().getDateOfBirth());
        model.setPlaceOfBirth(view.getPersonalInfoPanel().getPlaceOfBirth());
        model.setSex(view.getPersonalInfoPanel().getSex());
        model.setCivilStatus(view.getPersonalInfoPanel().getCivilStatus());
        model.setHeight(view.getPersonalInfoPanel().getHeightInput());
        model.setWeight(view.getPersonalInfoPanel().getWeight());
        model.setBloodType(view.getPersonalInfoPanel().getBloodType());
        model.setGsisIdNo(view.getPersonalInfoPanel().getGsisIdNo());
        model.setPagibigIdNo(view.getPersonalInfoPanel().getPagibigIdNo());
        model.setPhilhealthNo(view.getPersonalInfoPanel().getPhilhealthNo());
        model.setSssNo(view.getPersonalInfoPanel().getSssNo());
        model.setTinNo(view.getPersonalInfoPanel().getTinNo());
        model.setAgencyEmployeeNo(view.getPersonalInfoPanel().getAgencyEmployeeNo());
        model.setCitizenship(view.getPersonalInfoPanel().getCitizenship());
        model.setDualCitizenship(view.getPersonalInfoPanel().isDualCitizen());
        model.setDualCitizenshipType(view.getPersonalInfoPanel().getDualCitizenshipType());
        model.setDualCitizenshipCountry(view.getPersonalInfoPanel().getCountry());
        model.setResidentialHouseBlockLot(view.getPersonalInfoPanel().getResidentialHouseBlockLot());
        model.setResidentialStreet(view.getPersonalInfoPanel().getResidentialStreet());
        model.setResidentialSubdivisionVillage(view.getPersonalInfoPanel().getResidentialSubdivisionVillage());
        model.setResidentialBarangay(view.getPersonalInfoPanel().getResidentialBarangay());
        model.setResidentialCityMunicipality(view.getPersonalInfoPanel().getResidentialCityMunicipality());
        model.setResidentialProvince(view.getPersonalInfoPanel().getResidentialProvince());
        model.setResidentialZipCode(view.getPersonalInfoPanel().getResidentialZipCode());
        model.setPermanentHouseBlockLot(view.getPersonalInfoPanel().getPermanentHouseBlockLot());
        model.setPermanentStreet(view.getPersonalInfoPanel().getPermanentStreet());
        model.setPermanentSubdivisionVillage(view.getPersonalInfoPanel().getPermanentSubdivisionVillage());
        model.setPermanentBarangay(view.getPersonalInfoPanel().getPermanentBarangay());
        model.setPermanentCityMunicipality(view.getPersonalInfoPanel().getPermanentCityMunicipality());
        model.setPermanentProvince(view.getPersonalInfoPanel().getPermanentProvince());
        model.setPermanentZipCode(view.getPersonalInfoPanel().getPermanentZipCode());
        model.setTelephoneNo(view.getPersonalInfoPanel().getTelephoneNo());
        model.setMobileNo(view.getPersonalInfoPanel().getMobileNo());
        model.setEmailAddress(view.getPersonalInfoPanel().getEmailAddress());
    }

    private void updateModelFromFamilyBackgroundPanel() {
        // view.getFamilyBackgroundPanel().refreshData();
        model.setSpouseSurname(view.getFamilyBackgroundPanel().getSpouseSurname());
        model.setSpouseFirstName(view.getFamilyBackgroundPanel().getSpouseFirstName());
        model.setSpouseMiddleName(view.getFamilyBackgroundPanel().getSpouseMiddleName());
        model.setSpouseNameExtension(view.getFamilyBackgroundPanel().getSpouseNameExtension());
        model.setSpouseOccupation(view.getFamilyBackgroundPanel().getSpouseOccupation());
        model.setSpouseEmployerBusinessName(view.getFamilyBackgroundPanel().getSpouseEmployerBusinessName());
        model.setSpouseBusinessAddress(view.getFamilyBackgroundPanel().getSpouseBusinessAddress());
        model.setSpouseTelephoneNo(view.getFamilyBackgroundPanel().getSpouseTelephoneNo());
        model.setFatherSurname(view.getFamilyBackgroundPanel().getFatherSurname());
        model.setFatherFirstName(view.getFamilyBackgroundPanel().getFatherFirstName());
        model.setFatherMiddleName(view.getFamilyBackgroundPanel().getFatherMiddleName());
        model.setFatherNameExtension(view.getFamilyBackgroundPanel().getFatherNameExtension());
        model.setMotherMaidenName(view.getFamilyBackgroundPanel().getMotherMaidenName());
        model.setMotherSurname(view.getFamilyBackgroundPanel().getMotherSurname());
        model.setMotherFirstName(view.getFamilyBackgroundPanel().getMotherFirstName());
        model.setMotherMiddleName(view.getFamilyBackgroundPanel().getMotherMiddleName());

        // Handling the list of children
        List<Child> children = new ArrayList<>();
        for (int i = 0; i < view.getFamilyBackgroundPanel().getChildrenCount(); i++) {
            Child child = new Child();
            child.setName(view.getFamilyBackgroundPanel().getChildName(i));
            child.setDateOfBirth(view.getFamilyBackgroundPanel().getChildDateOfBirth(i));
            children.add(child);
        }
        model.setChildren(children);
    }

    private void updateModelFromEducationPanel() {
        // Get a reference to the EducationPanel
        EducationPanel ep = view.getEducationPanel();
        // Create a new list to hold Education objects
        List<Education> educationList = new ArrayList<>();

        // Elementary Education
        if (!ep.getElementarySchool().trim().isEmpty()) {
            Education elementary = new Education();
            elementary.setLevel("Elementary");
            elementary.setSchoolName(ep.getElementarySchool());
            elementary.setDegreeCourse(ep.getElementaryCourse());
            elementary.setYearFrom(ep.getElementaryAttendFrom());  // Assumes Education.yearFrom is of type LocalDate
            elementary.setYearTo(ep.getElementaryAttendTo());
            elementary.setHighestLevelUnitsEarned(ep.getElementaryHighestLevel());
            elementary.setYearGraduated(ep.getElementaryYearGraduated());
            elementary.setAcademicHonorsReceived(ep.getElementaryScholarship());
            educationList.add(elementary);
        }

        // Secondary Education
        if (!ep.getSecondarySchool().trim().isEmpty()) {
            Education secondary = new Education();
            secondary.setLevel("Secondary");
            secondary.setSchoolName(ep.getSecondarySchool());
            secondary.setDegreeCourse(ep.getSecondaryCourse());
            secondary.setYearFrom(ep.getSecondaryAttendFrom());
            secondary.setYearTo(ep.getSecondaryAttendTo());
            secondary.setHighestLevelUnitsEarned(ep.getSecondaryHighestLevel());
            secondary.setYearGraduated(ep.getSecondaryYearGraduated());
            secondary.setAcademicHonorsReceived(ep.getSecondaryScholarship());
            educationList.add(secondary);
        }

        // Vocational Education
        if (!ep.getVocationalSchool().trim().isEmpty()) {
            Education vocational = new Education();
            vocational.setLevel("Vocational");
            vocational.setSchoolName(ep.getVocationalSchool());
            vocational.setDegreeCourse(ep.getVocationalCourse());
            vocational.setYearFrom(ep.getVocationalAttendFrom());
            vocational.setYearTo(ep.getVocationalAttendTo());
            vocational.setHighestLevelUnitsEarned(ep.getVocationalHighestLevel());
            vocational.setYearGraduated(ep.getVocationalYearGraduated());
            vocational.setAcademicHonorsReceived(ep.getVocationalScholarship());
            educationList.add(vocational);
        }

        // College Education
        if (!ep.getCollegeSchool().trim().isEmpty()) {
            Education college = new Education();
            college.setLevel("College");
            college.setSchoolName(ep.getCollegeSchool());
            college.setDegreeCourse(ep.getCollegeCourse());
            college.setYearFrom(ep.getCollegeAttendFrom());
            college.setYearTo(ep.getCollegeAttendTo());
            college.setHighestLevelUnitsEarned(ep.getCollegeHighestLevel());
            college.setYearGraduated(ep.getCollegeYearGraduated());
            college.setAcademicHonorsReceived(ep.getCollegeScholarship());
            educationList.add(college);
        }

        // Graduate Studies Education
        if (!ep.getGraduateSchool().trim().isEmpty()) {
            Education graduate = new Education();
            graduate.setLevel("Graduate Studies");
            graduate.setSchoolName(ep.getGraduateSchool());
            graduate.setDegreeCourse(ep.getGraduateCourse());
            graduate.setYearFrom(ep.getGraduateAttendFrom());
            graduate.setYearTo(ep.getGraduateAttendTo());
            graduate.setHighestLevelUnitsEarned(ep.getGraduateHighestLevel());
            graduate.setYearGraduated(ep.getGraduateYearGraduated());
            graduate.setAcademicHonorsReceived(ep.getGraduateScholarship());
            educationList.add(graduate);
        }

        model.setEducationList(educationList);
    }

    private void updateModelFromEligibilityPanel() {
        // view.getEligibilityPanel().refreshData();
        List<Eligibility> eligibilityList = new ArrayList<>();
        for (int i = 0; i < view.getEligibilityPanel().getEligibilityCount(); i++) {
            Eligibility eligibility = new Eligibility();
            eligibility.setCareerService(view.getEligibilityPanel().getCareerService(i));
            eligibility.setRating(view.getEligibilityPanel().getRating(i));
            eligibility.setDateOfExamination(view.getEligibilityPanel().getDateOfExamination(i));
            eligibility.setPlaceOfExamination(view.getEligibilityPanel().getPlaceOfExamination(i));
            eligibility.setLicenseNumber(view.getEligibilityPanel().getLicenseNumber(i));
            eligibility.setLicenseDateOfValidity(view.getEligibilityPanel().getLicenseDateOfValidity(i));
            eligibilityList.add(eligibility);
        }
        model.setEligibilityList(eligibilityList);
    }

    private void updateModelFromWorkExperiencePanel() {
        // view.getWorkExperiencePanel().refreshData();
        List<WorkExperience> workExperienceList = new ArrayList<>();
        for (int i = 0; i < view.getWorkExperiencePanel().getWorkExperienceCount(); i++) {
            WorkExperience workExperience = new WorkExperience();
            workExperience.setDateFrom(view.getWorkExperiencePanel().getDateFrom(i));
            workExperience.setDateTo(view.getWorkExperiencePanel().getDateTo(i));
            workExperience.setPositionTitle(view.getWorkExperiencePanel().getPositionTitle(i));
            workExperience.setDepartmentAgencyOfficeCompany(view.getWorkExperiencePanel().getDepartmentAgencyOfficeCompany(i));
            workExperience.setMonthlySalary(view.getWorkExperiencePanel().getMonthlySalary(i));
            workExperience.setSalaryGradeStepIncrement(view.getWorkExperiencePanel().getSalaryGradeStepIncrement(i));
            workExperience.setStatusOfAppointment(view.getWorkExperiencePanel().getStatusOfAppointment(i));
            workExperience.setGovernmentService(view.getWorkExperiencePanel().isGovernmentService(i));
            workExperienceList.add(workExperience);
        }
        model.setWorkExperienceList(workExperienceList);
    }

    private void updateModelFromVoluntaryWorkPanel() {
        // view.getVoluntaryWorkPanel().refreshData();
        List<VoluntaryWork> voluntaryWorkList = new ArrayList<>();
        for (int i = 0; i < view.getVoluntaryWorkPanel().getVoluntaryWorkCount(); i++) {
            VoluntaryWork voluntaryWork = new VoluntaryWork();
            voluntaryWork.setOrganizationName(view.getVoluntaryWorkPanel().getOrganizationName(i));
            voluntaryWork.setOrganizationAddress(view.getVoluntaryWorkPanel().getOrganizationAddress(i));
            voluntaryWork.setDateFrom(view.getVoluntaryWorkPanel().getDateFrom(i));
            voluntaryWork.setDateTo(view.getVoluntaryWorkPanel().getDateTo(i));
            voluntaryWork.setNumberOfHours(view.getVoluntaryWorkPanel().getNumberOfHours(i));
            voluntaryWork.setPositionNatureOfWork(view.getVoluntaryWorkPanel().getPositionNatureOfWork(i));
            voluntaryWorkList.add(voluntaryWork);
        }
        model.setVoluntaryWorkList(voluntaryWorkList);
    }

    private void updateModelFromTrainingPanel() {
        // view.getTrainingPanel().refreshData();
        List<Training> trainingList = new ArrayList<>();
        for (int i = 0; i < view.getTrainingPanel().getTrainingCount(); i++) {
            Training training = new Training();
            training.setTitle(view.getTrainingPanel().getTitle(i));
            training.setDateFrom(view.getTrainingPanel().getDateFrom(i));
            training.setDateTo(view.getTrainingPanel().getDateTo(i));
            training.setNumberOfHours(view.getTrainingPanel().getNumberOfHours(i));
            training.setTypeOfLd(view.getTrainingPanel().getTypeOfLd(i));
            training.setConductedBy(view.getTrainingPanel().getConductedBy(i));
            trainingList.add(training);
        }
        model.setTrainingList(trainingList);
    }

    private void updateModelFromOtherInfoPanel() {
        // view.getOtherInfoPanel().refreshData();
        model.setSpecialSkillsHobbies(view.getOtherInfoPanel().getSpecialSkillsHobbies());
        model.setNonAcademicDistinctionsRecognition(view.getOtherInfoPanel().getNonAcademicDistinctionsRecognition());
        model.setMembershipInAssociationsOrganizations(view.getOtherInfoPanel().getMembershipInAssociationsOrganizations());

        List<Reference> references = new ArrayList<>();
        for (int i = 0; i < view.getOtherInfoPanel().getReferencesCount(); i++) {
            Reference reference = new Reference();
            reference.setName(view.getOtherInfoPanel().getReferenceName(i));
            reference.setAddress(view.getOtherInfoPanel().getReferenceAddress(i));
            reference.setTelephoneNo(view.getOtherInfoPanel().getReferenceTelephoneNo(i));
            references.add(reference);
        }
        model.setReferences(references);

        model.setThirdDegreeRelationship(view.getOtherInfoPanel().getThirdDegreeRelationship());
        model.setFourthDegreeRelationship(view.getOtherInfoPanel().getFourthDegreeRelationship());
        model.setAdminOffense(view.getOtherInfoPanel().getAdminOffense());
        model.setAdminOffenseDetails(view.getOtherInfoPanel().getAdminOffenseDetails());
        model.setCriminallyCharged(view.getOtherInfoPanel().getCriminallyCharged());
        model.setCriminallyChargedDate(view.getOtherInfoPanel().getCriminallyChargedDate());
        model.setCriminallyChargedStatus(view.getOtherInfoPanel().getCriminallyChargedStatus());
        model.setConvicted(view.getOtherInfoPanel().getConvicted());
        model.setConvictedDetails(view.getOtherInfoPanel().getConvictedDetails());
        model.setSeparatedService(view.getOtherInfoPanel().getSeparatedService());
        model.setSeparatedServiceDetails(view.getOtherInfoPanel().getSeparatedServiceDetails());
        model.setElectionCandidate(view.getOtherInfoPanel().getElectionCandidate());
        model.setElectionCandidateDetails(view.getOtherInfoPanel().getElectionCandidateDetails());
        model.setResignedGovt(view.getOtherInfoPanel().getResignedGovt());
        model.setResignedGovtDetails(view.getOtherInfoPanel().getResignedGovtDetails());
        model.setImmigrant(view.getOtherInfoPanel().getImmigrant());
        model.setImmigrantCountry(view.getOtherInfoPanel().getImmigrantCountry());
        model.setIndigenous(view.getOtherInfoPanel().getIndigenous());
        model.setIndigenousDetails(view.getOtherInfoPanel().getIndigenousDetails());
        model.setPwd(view.getOtherInfoPanel().getPwd());
        model.setPwdDetails(view.getOtherInfoPanel().getPwdDetails());
        model.setSoloParent(view.getOtherInfoPanel().getSoloParent());
        model.setSoloParentDetails(view.getOtherInfoPanel().getSoloParentDetails());
    }

    private boolean validateData() {
        // Implement your validation logic here
        if (model.getSurname() == null || model.getSurname().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Surname is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // ... (add more validation checks) ...
        return true; // Return true if all validation passes
    }

    private String formatSummary() {
        StringBuilder summary = new StringBuilder();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Personal Information
        summary.append("I. PERSONAL INFORMATION\n");
        summary.append("Surname: ").append(model.getSurname()).append("\n");
        summary.append("First Name: ").append(model.getFirstName()).append("\n");
        summary.append("Middle Name: ").append(model.getMiddleName()).append("\n");
        summary.append("Name Extension: ").append(model.getNameExtension()).append("\n");
        summary.append("Date of Birth: ").append(model.getDateOfBirth() != null ? model.getDateOfBirth().format(dateFormatter) : "").append("\n");
        summary.append("Place of Birth: ").append(model.getPlaceOfBirth()).append("\n");
        summary.append("Sex: ").append(model.getSex() != null ? model.getSex().name() : "").append("\n");
        summary.append("Civil Status: ").append(model.getCivilStatus() != null ? model.getCivilStatus().name() : "").append("\n");
        summary.append("Height: ").append(model.getHeight()).append("\n");
        summary.append("Weight: ").append(model.getWeight()).append("\n");
        summary.append("Blood Type: ").append(model.getBloodType()).append("\n");
        summary.append("GSIS ID No.: ").append(model.getGsisIdNo()).append("\n");
        summary.append("PAG-IBIG ID No.: ").append(model.getPagibigIdNo()).append("\n");
        summary.append("PHILHEALTH No.: ").append(model.getPhilhealthNo()).append("\n");
        summary.append("SSS No.: ").append(model.getSssNo()).append("\n");
        summary.append("TIN No.: ").append(model.getTinNo()).append("\n");
        summary.append("Agency Employee No.: ").append(model.getAgencyEmployeeNo()).append("\n");
        summary.append("Citizenship: ").append(model.getCitizenship()).append("\n");
        summary.append("Dual Citizenship: ").append(model.isDualCitizenship() ? "Yes" : "No").append("\n");
        if (model.isDualCitizenship()) {
            summary.append("Dual Citizenship Type: ").append(model.getDualCitizenshipType()).append("\n");
            summary.append("Dual Citizenship Country: ").append(model.getDualCitizenshipCountry()).append("\n");
        }
        summary.append("Residential Address:\n");
        summary.append("  House/Block/Lot No.: ").append(model.getResidentialHouseBlockLot()).append("\n");
        summary.append("  Street: ").append(model.getResidentialStreet()).append("\n");
        summary.append("  Subdivision/Village: ").append(model.getResidentialSubdivisionVillage()).append("\n");
        summary.append("  Barangay: ").append(model.getResidentialBarangay()).append("\n");
        summary.append("  City/Municipality: ").append(model.getResidentialCityMunicipality()).append("\n");
        summary.append("  Province: ").append(model.getResidentialProvince()).append("\n");
        summary.append("  Zip Code: ").append(model.getResidentialZipCode()).append("\n");
        summary.append("Permanent Address:\n");
        summary.append("  House/Block/Lot No.: ").append(model.getPermanentHouseBlockLot()).append("\n");
        summary.append("  Street: ").append(model.getPermanentStreet()).append("\n");
        summary.append("  Subdivision/Village: ").append(model.getPermanentSubdivisionVillage()).append("\n");
        summary.append("  Barangay: ").append(model.getPermanentBarangay()).append("\n");
        summary.append("  City/Municipality: ").append(model.getPermanentCityMunicipality()).append("\n");
        summary.append("  Province: ").append(model.getPermanentProvince()).append("\n");
        summary.append("  Zip Code: ").append(model.getPermanentZipCode()).append("\n");
        summary.append("Telephone No.: ").append(model.getTelephoneNo()).append("\n");
        summary.append("Mobile No.: ").append(model.getMobileNo()).append("\n");
        summary.append("Email Address: ").append(model.getEmailAddress()).append("\n\n");

        // Family Background
        summary.append("II. FAMILY BACKGROUND\n");
        summary.append("Spouse's Surname: ").append(model.getSpouseSurname()).append("\n");
        summary.append("Spouse's First Name: ").append(model.getSpouseFirstName()).append("\n");
        summary.append("Spouse's Middle Name: ").append(model.getSpouseMiddleName()).append("\n");
        summary.append("Spouse's Name Extension: ").append(model.getSpouseNameExtension()).append("\n");
        summary.append("Spouse's Occupation: ").append(model.getSpouseOccupation()).append("\n");
        summary.append("Spouse's Employer/Business Name: ").append(model.getSpouseEmployerBusinessName()).append("\n");
        summary.append("Spouse's Business Address: ").append(model.getSpouseBusinessAddress()).append("\n");
        summary.append("Spouse's Telephone No.: ").append(model.getSpouseTelephoneNo()).append("\n");
        summary.append("Father's Surname: ").append(model.getFatherSurname()).append("\n");
        summary.append("Father's First Name: ").append(model.getFatherFirstName()).append("\n");
        summary.append("Father's Middle Name: ").append(model.getFatherMiddleName()).append("\n");
        summary.append("Father's Name Extension: ").append(model.getFatherNameExtension()).append("\n");
        summary.append("Mother's Maiden Name: ").append(model.getMotherMaidenName()).append("\n");
        summary.append("Mother's Surname: ").append(model.getMotherSurname()).append("\n");
        summary.append("Mother's First Name: ").append(model.getMotherFirstName()).append("\n");
        summary.append("Mother's Middle Name: ").append(model.getMotherMiddleName()).append("\n");

        List<Child> children = model.getChildren();
        if (!children.isEmpty()) {
            summary.append("Children:\n");
            for (Child child : children) {
                summary.append("  Name: ").append(child.getName()).append("\n");
                summary.append("  Date of Birth: ").append(child.getDateOfBirth() != null ? child.getDateOfBirth().format(dateFormatter) : "").append("\n");
            }
        }
        summary.append("\n");

        // Educational Background
        summary.append("III. EDUCATIONAL BACKGROUND\n");
        List<Education> educationList = model.getEducationList();
        if (!educationList.isEmpty()) {
            for (Education education : educationList) {
                summary.append("Level: ").append(education.getLevel()).append("\n");
                summary.append("School Name: ").append(education.getSchoolName()).append("\n");
                summary.append("Degree Course: ").append(education.getDegreeCourse()).append("\n");
                summary.append("Year From: ").append(education.getYearFrom() != null ? education.getYearFrom().format(dateFormatter) : "").append("\n");
                summary.append("Year To: ").append(education.getYearTo() != null ? education.getYearTo().format(dateFormatter) : "").append("\n");
                summary.append("Highest Level/Units Earned: ").append(education.getHighestLevelUnitsEarned()).append("\n");
                summary.append("Year Graduated: ").append(education.getYearGraduated()).append("\n");
                summary.append("Academic Honors Received: ").append(education.getAcademicHonorsReceived()).append("\n\n");
            }
        }

        // Civil Service Eligibility
        summary.append("IV. CIVIL SERVICE ELIGIBILITY\n");
        if (!model.getEligibilityList().isEmpty()) {
            for (Eligibility eligibility : model.getEligibilityList()) {
                summary.append("Career Service: ").append(eligibility.getCareerService()).append("\n");
                summary.append("Rating: ").append(eligibility.getRating()).append("\n");
                summary.append("Date of Examination: ").append(eligibility.getDateOfExamination() != null ? eligibility.getDateOfExamination() : "").append("\n");
                summary.append("Place of Examination: ").append(eligibility.getPlaceOfExamination()).append("\n");
                summary.append("License Number: ").append(eligibility.getLicenseNumber()).append("\n");
                summary.append("License Date of Validity: ").append(eligibility.getLicenseDateOfValidity() != null ? eligibility.getLicenseDateOfValidity() : "").append("\n\n");
            }
        } else {
            summary.append("No Civil Service Eligibility entries.\n\n");
        }

        // Work Experience
        summary.append("V. WORK EXPERIENCE\n");
        List<WorkExperience> workExperienceList = model.getWorkExperienceList();
        if (!workExperienceList.isEmpty()) {
            for (WorkExperience workExperience : workExperienceList) {
                summary.append("Date From: ").append(workExperience.getDateFrom() != null ? workExperience.getDateFrom().format(dateFormatter) : "").append("\n");
                summary.append("Date To: ").append(workExperience.getDateTo() != null ? workExperience.getDateTo().format(dateFormatter) : "").append("\n");
                summary.append("Position Title: ").append(workExperience.getPositionTitle()).append("\n");
                summary.append("Department/Agency/Office/Company: ").append(workExperience.getDepartmentAgencyOfficeCompany()).append("\n");
                summary.append("Monthly Salary: ").append(workExperience.getMonthlySalary()).append("\n");
                summary.append("Salary Grade & Step Increment: ").append(workExperience.getSalaryGradeStepIncrement()).append("\n");
                summary.append("Status of Appointment: ").append(workExperience.getStatusOfAppointment()).append("\n");
                summary.append("Government Service: ").append(workExperience.isGovernmentService() ? "Yes" : "No").append("\n\n");
            }
        } else {
            summary.append("No Work Experience entries.\n\n");
        }

        // Voluntary Work
        summary.append("VI. VOLUNTARY WORK OR INVOLVEMENT IN CIVIC / NON-GOVERNMENT / PEOPLE / VOLUNTARY ORGANIZATIONS\n");
        List<VoluntaryWork> voluntaryWorkList = model.getVoluntaryWorkList();
        if (!voluntaryWorkList.isEmpty()) {
            for (VoluntaryWork voluntaryWork : voluntaryWorkList) {
                summary.append("Name & Address of Organization: ").append(voluntaryWork.getOrganizationName()).append(", ").append(voluntaryWork.getOrganizationAddress()).append("\n");
                summary.append("Date From: ").append(voluntaryWork.getDateFrom() != null ? voluntaryWork.getDateFrom().format(dateFormatter) : "").append("\n");
                summary.append("Date To: ").append(voluntaryWork.getDateTo() != null ? voluntaryWork.getDateTo().format(dateFormatter) : "").append("\n");
                summary.append("Number of Hours: ").append(voluntaryWork.getNumberOfHours()).append("\n");
                summary.append("Position/Nature of Work: ").append(voluntaryWork.getPositionNatureOfWork()).append("\n\n");
            }
        } else {
            summary.append("No Voluntary Work entries.\n\n");
        }

        // Training
        summary.append("VII. LEARNING AND DEVELOPMENT (L&D) INTERVENTIONS/TRAINING PROGRAMS ATTENDED\n");
        List<Training> trainingList = model.getTrainingList();
        if (!trainingList.isEmpty()) {
            for (Training training : trainingList) {
                summary.append("Title: ").append(training.getTitle()).append("\n");
                summary.append("Date From: ").append(training.getDateFrom() != null ? training.getDateFrom().format(dateFormatter) : "").append("\n");
                summary.append("Date To: ").append(training.getDateTo() != null ? training.getDateTo().format(dateFormatter) : "").append("\n");
                summary.append("Number of Hours: ").append(training.getNumberOfHours()).append("\n");
                summary.append("Type of LD: ").append(training.getTypeOfLd()).append("\n");
                summary.append("Conducted/Sponsored By: ").append(training.getConductedBy()).append("\n\n");
            }
        } else {
            summary.append("No Learning and Development entries.\n\n");
        }

        // Other Information
        summary.append("VIII. OTHER INFORMATION\n");
        summary.append("Special Skills/Hobbies:\n");
        if (model.getSpecialSkillsHobbies() != null && !model.getSpecialSkillsHobbies().isEmpty()) {
            for (String skill : model.getSpecialSkillsHobbies()) {
                summary.append("- ").append(skill).append("\n");
            }
        } else {
            summary.append("None\n");
        }

        summary.append("\nNon-Academic Distinctions/Recognition:\n");
        if (model.getNonAcademicDistinctionsRecognition() != null && !model.getNonAcademicDistinctionsRecognition().isEmpty()) {
            for (String distinction : model.getNonAcademicDistinctionsRecognition()) {
                summary.append("- ").append(distinction).append("\n");
            }
        } else {
            summary.append("None\n");
        }

        summary.append("\nMembership in Association/Organization:\n");
        if (model.getMembershipInAssociationsOrganizations() != null && !model.getMembershipInAssociationsOrganizations().isEmpty()) {
            for (String membership : model.getMembershipInAssociationsOrganizations()) {
                summary.append("- ").append(membership).append("\n");
            }
        } else {
            summary.append("None\n");
        }

        // References
        summary.append("\nIX. REFERENCES\n");
        List<Reference> references = model.getReferences();
        if (!references.isEmpty()) {
            for (Reference reference : references) {
                summary.append("Name: ").append(reference.getName()).append("\n");
                summary.append("Address: ").append(reference.getAddress()).append("\n");
                summary.append("Telephone No.: ").append(reference.getTelephoneNo()).append("\n\n");
            }
        } else {
            summary.append("No References entries.\n\n");
        }

        // Other Questions
        summary.append("X. OTHER QUESTIONS\n");
        summary.append("34. Are you related by consanguinity or affinity to the appointing or recommending authority, or to the chief of bureau or office or to the person who has immediate supervision over you in the Office, Bureau or Department where you will be appointed,\n");
        summary.append("a. within the third degree? ").append(model.isThirdDegreeRelationship() ? "Yes" : "No").append("\n");
        summary.append("b. within the fourth degree (for Local Government Unit - Career Employees)? ").append(model.isFourthDegreeRelationship() ? "Yes" : "No").append("\n");

        summary.append("35. a. Have you ever been found guilty of any administrative offense? ").append(model.isAdminOffense() ? "Yes" : "No").append("\n");
        if (model.isAdminOffense()) {
            summary.append("   If YES, give details: ").append(model.getAdminOffenseDetails()).append("\n");
        }

        summary.append("b. Have you been criminally charged before any court? ").append(model.isCriminallyCharged() ? "Yes" : "No").append("\n");
        if (model.isCriminallyCharged()) {
            summary.append("   Date Filed: ").append(model.getCriminallyChargedDate() != null ? model.getCriminallyChargedDate().format(dateFormatter) : "").append("\n");
            summary.append("   Status of Case/s: ").append(model.getCriminallyChargedStatus()).append("\n");
        }

        summary.append("36. Have you ever been convicted of any crime or violation of any law, decree, ordinance or regulation by any court or tribunal? ").append(model.isConvicted() ? "Yes" : "No").append("\n");
        if (model.isConvicted()) {
            summary.append("   If YES, give details: ").append(model.getConvictedDetails()).append("\n");
        }

        summary.append("37. Have you ever been separated from the service in any of the following modes: resignation, retirement, dropped from the rolls, dismissal, termination, end of term, finished contract or phased out (abolition) in the public or private sector? ").append(model.isSeparatedService() ? "Yes" : "No").append("\n");
        if (model.isSeparatedService()) {
            summary.append("   If YES, give details: ").append(model.getSeparatedServiceDetails()).append("\n");
        }

        summary.append("38. a. Have you ever been a candidate in a national or local election held within the last year (except Barangay election)? ").append(model.isElectionCandidate() ? "Yes" : "No").append("\n");
        if (model.isElectionCandidate()) {
            summary.append("   If YES, give details: ").append(model.getElectionCandidateDetails()).append("\n");
        }

        summary.append("b. Have you resigned from the government service during the three (3)-month period before the last election to promote/actively campaign for a national or local candidate? ").append(model.isResignedGovt() ? "Yes" : "No").append("\n");
        if (model.isResignedGovt()) {
            summary.append("   If YES, give details: ").append(model.getResignedGovtDetails()).append("\n");
        }

        summary.append("39. Have you acquired the status of an immigrant or permanent resident of another country? ").append(model.isImmigrant() ? "Yes" : "No").append("\n");
        if (model.isImmigrant()) {
            summary.append("   If YES, give details (country): ").append(model.getImmigrantCountry()).append("\n");
        }

        summary.append("40. Pursuant to: (a) Indigenous People's Act (RA 8371); (b) Magna Carta for Disabled Persons (RA 7277); and (c) Solo Parents Welfare Act of 2000 (RA 8972), please answer the following items:\n");
        summary.append("a. Are you a member of any indigenous group? ").append(model.isIndigenous() ? "Yes" : "No").append("\n");
        if (model.isIndigenous()) {
            summary.append("   If YES, please specify: ").append(model.getIndigenousDetails()).append("\n");
        }

        summary.append("b. Are you a person with disability? ").append(model.isPwd() ? "Yes" : "No").append("\n");
        if (model.isPwd()) {
            summary.append("   If YES, please specify ID No: ").append(model.getPwdDetails()).append("\n");
        }

        summary.append("c. Are you a solo parent? ").append(model.isSoloParent() ? "Yes" : "No").append("\n");
        if (model.isSoloParent()) {
            summary.append("   If YES, please specify ID No: ").append(model.getSoloParentDetails()).append("\n");
        }

        summary.append("\n");

        return summary.toString();
    }

}
