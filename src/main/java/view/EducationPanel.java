/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import model.Education;
import java.time.format.DateTimeFormatter;
import java.time.DateTimeException;
import java.time.Year;
import javax.swing.JOptionPane;

public class EducationPanel extends javax.swing.JPanel {

    /**
     * Creates new form EducationPanel
     */
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    public EducationPanel() {
        initComponents();
    }

    public String getElementarySchool() {
        return elementarySchoolTextField.getText();
    }

    public String getElementaryCourse() {
        return elementaryCourseTextField.getText();
    }

    public Year getElementaryAttendFrom() {
        return parseYear(elementaryAttendFromTextField.getText(), "Elementary Attend From");
    }

    public Year getElementaryAttendTo() {
        return parseYear(elementaryAttendToTextField.getText(), "Elementary Attend To");
    }

    public String getElementaryHighestLevel() {
        return elementaryHighestTextField.getText();
    }

    public String getElementaryYearGraduated() {
        return elementaryYearGraduatedTextField.getText();
    }

    public String getElementaryScholarship() {
        return elementaryScholarshipTextField.getText();
    }

    // Getters for Secondary
    public String getSecondarySchool() {
        return secondarySchoolTextField.getText();
    }

    public String getSecondaryCourse() {
        return secondaryCourseTextField.getText();
    }

    public Year getSecondaryAttendFrom() {
        return parseYear(secondaryAttendFromTextField.getText(), "Secondary Attend From");
    }

    public Year getSecondaryAttendTo() {
        return parseYear(secondaryAttendToTextField.getText(), "Secondary Attend To");
    }

    public String getSecondaryHighestLevel() {
        return secondaryHighestTextField.getText();
    }

    public String getSecondaryYearGraduated() {
        return secondaryYearGraduatedTextField.getText();
    }

    public String getSecondaryScholarship() {
        return secondaryScholarshipTextField.getText();
    }

    // Getters for Vocational
    public String getVocationalSchool() {
        return vocationalSchoolTextField.getText();
    }

    public String getVocationalCourse() {
        return vocationalCourseTextField.getText();
    }

    public Year getVocationalAttendFrom() {
        return parseYear(vocationalAttendFromTextField.getText(), "Vocational Attend From");
    }

    public Year getVocationalAttendTo() {
        return parseYear(vocationalAttendToTextField.getText(), "Vocational Attend To");
    }

    public String getVocationalHighestLevel() {
        return vocationalHighestTextField.getText();
    }

    public String getVocationalYearGraduated() {
        return vocationalYearGraduatedTextField.getText();
    }

    public String getVocationalScholarship() {
        return vocationalScholarshipTextField.getText();
    }

    // Getters for College
    public String getCollegeSchool() {
        return collegeSchoolTextField.getText();
    }

    public String getCollegeCourse() {
        return collegeCourseTextField.getText();
    }

    public Year getCollegeAttendFrom() {
        return parseYear(collegeAttendFromTextField.getText(), "College Attend From");
    }

    public Year getCollegeAttendTo() {
        return parseYear(collegeAttendToTextField.getText(), "College Attend To");
    }

    public String getCollegeHighestLevel() {
        return collegeHighestTextField.getText();
    }

    public String getCollegeYearGraduated() {
        return collegeYearGraduatedTextField.getText();
    }

    public String getCollegeScholarship() {
        return collegeScholarshipTextField.getText();
    }

    // Getters for Graduate Studies
    public String getGraduateSchool() {
        return graduateSchoolTextField.getText();
    }

    public String getGraduateCourse() {
        return graduateCourseTextField.getText();
    }

    public Year getGraduateAttendFrom() {
        return parseYear(graduateAttendFromTextField.getText(), "Graduate Studies Attend From");
    }

    public Year getGraduateAttendTo() {
        return parseYear(graduateAttendToTextField.getText(), "Graduate Studies Attend To");
    }

    public String getGraduateHighestLevel() {
        return graduateHighestTextField.getText();
    }

    public String getGraduateYearGraduated() {
        return graduateYearGraduatedTextField1.getText();
    }

    public String getGraduateScholarship() {
        return graduateScholarshipTextField.getText();
    }

    private Year parseYear(String yearString, String fieldName) {
        try {
            return Year.parse(yearString);
        } catch (DateTimeException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid year format for " + fieldName + ". Use YYYY.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void refreshData() {
        // Clear Elementary fields
        elementarySchoolTextField.setText("");
        elementaryCourseTextField.setText("");
        elementaryAttendFromTextField.setText("");
        elementaryAttendToTextField.setText("");
        elementaryHighestTextField.setText("");
        elementaryYearGraduatedTextField.setText("");
        elementaryScholarshipTextField.setText("");

        // Clear Secondary fields
        secondarySchoolTextField.setText("");
        secondaryCourseTextField.setText("");
        secondaryAttendFromTextField.setText("");
        secondaryAttendToTextField.setText("");
        secondaryHighestTextField.setText("");
        secondaryYearGraduatedTextField.setText("");
        secondaryScholarshipTextField.setText("");

        // Clear Vocational fields
        vocationalSchoolTextField.setText("");
        vocationalCourseTextField.setText("");
        vocationalAttendFromTextField.setText("");
        vocationalAttendToTextField.setText("");
        vocationalHighestTextField.setText("");
        vocationalYearGraduatedTextField.setText("");
        vocationalScholarshipTextField.setText("");

        // Clear College fields
        collegeSchoolTextField.setText("");
        collegeCourseTextField.setText("");
        collegeAttendFromTextField.setText("");
        collegeAttendToTextField.setText("");
        collegeHighestTextField.setText("");
        collegeYearGraduatedTextField.setText("");
        collegeScholarshipTextField.setText("");

        // Clear Graduate Studies fields
        graduateSchoolTextField.setText("");
        graduateCourseTextField.setText("");
        graduateAttendFromTextField.setText("");
        graduateAttendToTextField.setText("");
        graduateHighestTextField.setText("");
        graduateYearGraduatedTextField1.setText("");
        graduateScholarshipTextField.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        elementarySchoolTextField = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        elementaryCourseTextField = new javax.swing.JTextField();
        middleNameLabel = new javax.swing.JLabel();
        elementaryAttendFromTextField = new javax.swing.JTextField();
        elementaryAttendToTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        elementaryYearGraduatedTextField = new javax.swing.JTextField();
        firstNameLabel1 = new javax.swing.JLabel();
        elementaryHighestTextField = new javax.swing.JTextField();
        firstNameLabel2 = new javax.swing.JLabel();
        elementaryScholarshipTextField = new javax.swing.JTextField();
        firstNameLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        firstNameLabel4 = new javax.swing.JLabel();
        middleNameLabel1 = new javax.swing.JLabel();
        secondaryAttendFromTextField = new javax.swing.JTextField();
        secondaryScholarshipTextField = new javax.swing.JTextField();
        secondaryAttendToTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        surnameLabel1 = new javax.swing.JLabel();
        secondaryYearGraduatedTextField = new javax.swing.JTextField();
        secondarySchoolTextField = new javax.swing.JTextField();
        firstNameLabel5 = new javax.swing.JLabel();
        firstNameLabel6 = new javax.swing.JLabel();
        secondaryHighestTextField = new javax.swing.JTextField();
        secondaryCourseTextField = new javax.swing.JTextField();
        firstNameLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        firstNameLabel8 = new javax.swing.JLabel();
        vocationalHighestTextField = new javax.swing.JTextField();
        vocationalCourseTextField = new javax.swing.JTextField();
        firstNameLabel9 = new javax.swing.JLabel();
        middleNameLabel2 = new javax.swing.JLabel();
        vocationalAttendFromTextField = new javax.swing.JTextField();
        vocationalScholarshipTextField = new javax.swing.JTextField();
        vocationalAttendToTextField = new javax.swing.JTextField();
        firstNameLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        surnameLabel2 = new javax.swing.JLabel();
        vocationalYearGraduatedTextField = new javax.swing.JTextField();
        vocationalSchoolTextField = new javax.swing.JTextField();
        firstNameLabel11 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        firstNameLabel12 = new javax.swing.JLabel();
        collegeHighestTextField = new javax.swing.JTextField();
        collegeCourseTextField = new javax.swing.JTextField();
        firstNameLabel13 = new javax.swing.JLabel();
        middleNameLabel3 = new javax.swing.JLabel();
        collegeAttendFromTextField = new javax.swing.JTextField();
        collegeScholarshipTextField = new javax.swing.JTextField();
        collegeAttendToTextField = new javax.swing.JTextField();
        firstNameLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        surnameLabel3 = new javax.swing.JLabel();
        collegeYearGraduatedTextField = new javax.swing.JTextField();
        collegeSchoolTextField = new javax.swing.JTextField();
        firstNameLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        graduateHighestTextField = new javax.swing.JTextField();
        graduateCourseTextField = new javax.swing.JTextField();
        firstNameLabel16 = new javax.swing.JLabel();
        middleNameLabel4 = new javax.swing.JLabel();
        graduateAttendFromTextField = new javax.swing.JTextField();
        graduateScholarshipTextField = new javax.swing.JTextField();
        graduateAttendToTextField = new javax.swing.JTextField();
        firstNameLabel17 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        surnameLabel4 = new javax.swing.JLabel();
        firstNameLabel18 = new javax.swing.JLabel();
        graduateSchoolTextField = new javax.swing.JTextField();
        graduateYearGraduatedTextField1 = new javax.swing.JTextField();
        firstNameLabel19 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(243, 244, 246));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Educational Background");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Elementary");

        surnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel.setText("Name of School");

        elementarySchoolTextField.setBackground(new java.awt.Color(250, 250, 250));
        elementarySchoolTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                elementarySchoolTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                elementarySchoolTextFieldFocusLost(evt);
            }
        });
        elementarySchoolTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementarySchoolTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel.setText("Basic Education/Degree/Course");

        elementaryCourseTextField.setBackground(new java.awt.Color(250, 250, 250));
        elementaryCourseTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                elementaryCourseTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                elementaryCourseTextFieldFocusLost(evt);
            }
        });
        elementaryCourseTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementaryCourseTextFieldActionPerformed(evt);
            }
        });

        middleNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        middleNameLabel.setText("Period of Attendance");

        elementaryAttendFromTextField.setBackground(new java.awt.Color(250, 250, 250));
        elementaryAttendFromTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                elementaryAttendFromTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                elementaryAttendFromTextFieldFocusLost(evt);
            }
        });
        elementaryAttendFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementaryAttendFromTextFieldActionPerformed(evt);
            }
        });

        elementaryAttendToTextField.setBackground(new java.awt.Color(250, 250, 250));
        elementaryAttendToTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                elementaryAttendToTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                elementaryAttendToTextFieldFocusLost(evt);
            }
        });
        elementaryAttendToTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementaryAttendToTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("From");

        jLabel4.setText("To");

        elementaryYearGraduatedTextField.setBackground(new java.awt.Color(250, 250, 250));
        elementaryYearGraduatedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                elementaryYearGraduatedTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                elementaryYearGraduatedTextFieldFocusLost(evt);
            }
        });
        elementaryYearGraduatedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementaryYearGraduatedTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel1.setText("Highest Level/Units Earned");

        elementaryHighestTextField.setBackground(new java.awt.Color(250, 250, 250));
        elementaryHighestTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                elementaryHighestTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                elementaryHighestTextFieldFocusLost(evt);
            }
        });
        elementaryHighestTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementaryHighestTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel2.setText("Year Graduated");

        elementaryScholarshipTextField.setBackground(new java.awt.Color(250, 250, 250));
        elementaryScholarshipTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                elementaryScholarshipTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                elementaryScholarshipTextFieldFocusLost(evt);
            }
        });
        elementaryScholarshipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elementaryScholarshipTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel3.setText("Scholarship/Academic Honors");

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Secondary");

        firstNameLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel4.setText("Year Graduated");

        middleNameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        middleNameLabel1.setText("Period of Attendance");

        secondaryAttendFromTextField.setBackground(new java.awt.Color(250, 250, 250));
        secondaryAttendFromTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                secondaryAttendFromTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                secondaryAttendFromTextFieldFocusLost(evt);
            }
        });
        secondaryAttendFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondaryAttendFromTextFieldActionPerformed(evt);
            }
        });

        secondaryScholarshipTextField.setBackground(new java.awt.Color(250, 250, 250));
        secondaryScholarshipTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                secondaryScholarshipTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                secondaryScholarshipTextFieldFocusLost(evt);
            }
        });
        secondaryScholarshipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondaryScholarshipTextFieldActionPerformed(evt);
            }
        });

        secondaryAttendToTextField.setBackground(new java.awt.Color(250, 250, 250));
        secondaryAttendToTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                secondaryAttendToTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                secondaryAttendToTextFieldFocusLost(evt);
            }
        });
        secondaryAttendToTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondaryAttendToTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("From");

        jLabel8.setText("To");

        surnameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel1.setText("Name of School");

        secondaryYearGraduatedTextField.setBackground(new java.awt.Color(250, 250, 250));
        secondaryYearGraduatedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                secondaryYearGraduatedTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                secondaryYearGraduatedTextFieldFocusLost(evt);
            }
        });
        secondaryYearGraduatedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondaryYearGraduatedTextFieldActionPerformed(evt);
            }
        });

        secondarySchoolTextField.setBackground(new java.awt.Color(250, 250, 250));
        secondarySchoolTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                secondarySchoolTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                secondarySchoolTextFieldFocusLost(evt);
            }
        });
        secondarySchoolTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondarySchoolTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel5.setText("Highest Level/Units Earned");

        firstNameLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel6.setText("Basic Education/Degree/Course");

        secondaryHighestTextField.setBackground(new java.awt.Color(250, 250, 250));
        secondaryHighestTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                secondaryHighestTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                secondaryHighestTextFieldFocusLost(evt);
            }
        });
        secondaryHighestTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondaryHighestTextFieldActionPerformed(evt);
            }
        });

        secondaryCourseTextField.setBackground(new java.awt.Color(250, 250, 250));
        secondaryCourseTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                secondaryCourseTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                secondaryCourseTextFieldFocusLost(evt);
            }
        });
        secondaryCourseTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secondaryCourseTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel7.setText("Scholarship/Academic Honors");

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setText("Vocational/Trade Course");

        firstNameLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel8.setText("Basic Education/Degree/Course");

        vocationalHighestTextField.setBackground(new java.awt.Color(250, 250, 250));
        vocationalHighestTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vocationalHighestTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vocationalHighestTextFieldFocusLost(evt);
            }
        });
        vocationalHighestTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vocationalHighestTextFieldActionPerformed(evt);
            }
        });

        vocationalCourseTextField.setBackground(new java.awt.Color(250, 250, 250));
        vocationalCourseTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vocationalCourseTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vocationalCourseTextFieldFocusLost(evt);
            }
        });
        vocationalCourseTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vocationalCourseTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel9.setText("Year Graduated");

        middleNameLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        middleNameLabel2.setText("Period of Attendance");

        vocationalAttendFromTextField.setBackground(new java.awt.Color(250, 250, 250));
        vocationalAttendFromTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vocationalAttendFromTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vocationalAttendFromTextFieldFocusLost(evt);
            }
        });
        vocationalAttendFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vocationalAttendFromTextFieldActionPerformed(evt);
            }
        });

        vocationalScholarshipTextField.setBackground(new java.awt.Color(250, 250, 250));
        vocationalScholarshipTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vocationalScholarshipTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vocationalScholarshipTextFieldFocusLost(evt);
            }
        });
        vocationalScholarshipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vocationalScholarshipTextFieldActionPerformed(evt);
            }
        });

        vocationalAttendToTextField.setBackground(new java.awt.Color(250, 250, 250));
        vocationalAttendToTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vocationalAttendToTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vocationalAttendToTextFieldFocusLost(evt);
            }
        });
        vocationalAttendToTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vocationalAttendToTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel10.setText("Scholarship/Academic Honors");

        jLabel9.setText("From");

        jLabel10.setText("To");

        surnameLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel2.setText("Name of School");

        vocationalYearGraduatedTextField.setBackground(new java.awt.Color(250, 250, 250));
        vocationalYearGraduatedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vocationalYearGraduatedTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vocationalYearGraduatedTextFieldFocusLost(evt);
            }
        });
        vocationalYearGraduatedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vocationalYearGraduatedTextFieldActionPerformed(evt);
            }
        });

        vocationalSchoolTextField.setBackground(new java.awt.Color(250, 250, 250));
        vocationalSchoolTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                vocationalSchoolTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                vocationalSchoolTextFieldFocusLost(evt);
            }
        });
        vocationalSchoolTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vocationalSchoolTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel11.setText("Highest Level/Units Earned");

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel11.setText("College");

        firstNameLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel12.setText("Basic Education/Degree/Course");

        collegeHighestTextField.setBackground(new java.awt.Color(250, 250, 250));
        collegeHighestTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                collegeHighestTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                collegeHighestTextFieldFocusLost(evt);
            }
        });
        collegeHighestTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeHighestTextFieldActionPerformed(evt);
            }
        });

        collegeCourseTextField.setBackground(new java.awt.Color(250, 250, 250));
        collegeCourseTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                collegeCourseTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                collegeCourseTextFieldFocusLost(evt);
            }
        });
        collegeCourseTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeCourseTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel13.setText("Year Graduated");

        middleNameLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        middleNameLabel3.setText("Period of Attendance");

        collegeAttendFromTextField.setBackground(new java.awt.Color(250, 250, 250));
        collegeAttendFromTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                collegeAttendFromTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                collegeAttendFromTextFieldFocusLost(evt);
            }
        });
        collegeAttendFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeAttendFromTextFieldActionPerformed(evt);
            }
        });

        collegeScholarshipTextField.setBackground(new java.awt.Color(250, 250, 250));
        collegeScholarshipTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                collegeScholarshipTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                collegeScholarshipTextFieldFocusLost(evt);
            }
        });
        collegeScholarshipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeScholarshipTextFieldActionPerformed(evt);
            }
        });

        collegeAttendToTextField.setBackground(new java.awt.Color(250, 250, 250));
        collegeAttendToTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                collegeAttendToTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                collegeAttendToTextFieldFocusLost(evt);
            }
        });
        collegeAttendToTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeAttendToTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel14.setText("Scholarship/Academic Honors");

        jLabel12.setText("From");

        jLabel13.setText("To");

        surnameLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel3.setText("Name of School");

        collegeYearGraduatedTextField.setBackground(new java.awt.Color(250, 250, 250));
        collegeYearGraduatedTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                collegeYearGraduatedTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                collegeYearGraduatedTextFieldFocusLost(evt);
            }
        });
        collegeYearGraduatedTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeYearGraduatedTextFieldActionPerformed(evt);
            }
        });

        collegeSchoolTextField.setBackground(new java.awt.Color(250, 250, 250));
        collegeSchoolTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                collegeSchoolTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                collegeSchoolTextFieldFocusLost(evt);
            }
        });
        collegeSchoolTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collegeSchoolTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel15.setText("Highest Level/Units Earned");

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel14.setText("Graduate Studies");

        graduateHighestTextField.setBackground(new java.awt.Color(250, 250, 250));
        graduateHighestTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                graduateHighestTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                graduateHighestTextFieldFocusLost(evt);
            }
        });
        graduateHighestTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduateHighestTextFieldActionPerformed(evt);
            }
        });

        graduateCourseTextField.setBackground(new java.awt.Color(250, 250, 250));
        graduateCourseTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                graduateCourseTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                graduateCourseTextFieldFocusLost(evt);
            }
        });
        graduateCourseTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduateCourseTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel16.setText("Year Graduated");

        middleNameLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        middleNameLabel4.setText("Period of Attendance");

        graduateAttendFromTextField.setBackground(new java.awt.Color(250, 250, 250));
        graduateAttendFromTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                graduateAttendFromTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                graduateAttendFromTextFieldFocusLost(evt);
            }
        });
        graduateAttendFromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduateAttendFromTextFieldActionPerformed(evt);
            }
        });

        graduateScholarshipTextField.setBackground(new java.awt.Color(250, 250, 250));
        graduateScholarshipTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                graduateScholarshipTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                graduateScholarshipTextFieldFocusLost(evt);
            }
        });
        graduateScholarshipTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduateScholarshipTextFieldActionPerformed(evt);
            }
        });

        graduateAttendToTextField.setBackground(new java.awt.Color(250, 250, 250));
        graduateAttendToTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                graduateAttendToTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                graduateAttendToTextFieldFocusLost(evt);
            }
        });
        graduateAttendToTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduateAttendToTextFieldActionPerformed(evt);
            }
        });

        firstNameLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel17.setText("Scholarship/Academic Honors");

        jLabel15.setText("From");

        jLabel16.setText("To");

        surnameLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel4.setText("Name of School");

        firstNameLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel18.setText("Highest Level/Units Earned");

        graduateSchoolTextField.setBackground(new java.awt.Color(250, 250, 250));
        graduateSchoolTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                graduateSchoolTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                graduateSchoolTextFieldFocusLost(evt);
            }
        });
        graduateSchoolTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduateSchoolTextFieldActionPerformed(evt);
            }
        });

        graduateYearGraduatedTextField1.setBackground(new java.awt.Color(250, 250, 250));
        graduateYearGraduatedTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                graduateYearGraduatedTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                graduateYearGraduatedTextField1FocusLost(evt);
            }
        });
        graduateYearGraduatedTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graduateYearGraduatedTextField1ActionPerformed(evt);
            }
        });

        firstNameLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel19.setText("Basic Education/Degree/Course");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vocationalSchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(surnameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel8)
                                    .addComponent(vocationalCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel9)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel10))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(middleNameLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(vocationalAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(vocationalAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(vocationalHighestTextField))
                                    .addComponent(firstNameLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vocationalYearGraduatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel10)
                                    .addComponent(vocationalScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(elementarySchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5))
                                        .addGap(21, 21, 21)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(firstNameLabel)
                                            .addComponent(elementaryCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addComponent(jLabel3)
                                                .addGap(40, 40, 40)
                                                .addComponent(jLabel4))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(middleNameLabel)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(9, 9, 9)
                                                        .addComponent(elementaryAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(elementaryAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(elementaryHighestTextField))
                                            .addComponent(firstNameLabel1))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(elementaryYearGraduatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(firstNameLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(firstNameLabel3)
                                            .addComponent(elementaryScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(secondarySchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(surnameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(firstNameLabel6)
                                        .addComponent(secondaryCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(35, 35, 35)
                                            .addComponent(jLabel7)
                                            .addGap(43, 43, 43)
                                            .addComponent(jLabel8))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(middleNameLabel1)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(9, 9, 9)
                                                    .addComponent(secondaryAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(secondaryAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(secondaryHighestTextField))
                                        .addComponent(firstNameLabel5))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(secondaryYearGraduatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(firstNameLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(firstNameLabel7)
                                        .addComponent(secondaryScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(4, 4, 4)))
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(673, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(graduateSchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(surnameLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel19)
                                    .addComponent(graduateCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel15)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel16))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(middleNameLabel4)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(graduateAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(graduateAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(graduateHighestTextField))
                                    .addComponent(firstNameLabel18))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(graduateYearGraduatedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameLabel16))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel17)
                                    .addComponent(graduateScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel14)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 1216, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(collegeSchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(surnameLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel12)
                                    .addComponent(collegeCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel12)
                                        .addGap(43, 43, 43)
                                        .addComponent(jLabel13))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(middleNameLabel3)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(collegeAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(collegeAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(collegeHighestTextField))
                                    .addComponent(firstNameLabel15))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(collegeYearGraduatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(firstNameLabel13))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(firstNameLabel14)
                                    .addComponent(collegeScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel11)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 1216, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(middleNameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(surnameLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(firstNameLabel)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(elementarySchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(elementaryCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(elementaryAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(elementaryAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(firstNameLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(elementaryYearGraduatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(elementaryScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameLabel1)
                            .addComponent(firstNameLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(elementaryHighestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(firstNameLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(secondaryScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(secondaryYearGraduatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstNameLabel5)
                                    .addComponent(firstNameLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(secondaryHighestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(surnameLabel1)
                            .addGap(6, 6, 6)
                            .addComponent(secondarySchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(middleNameLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8)
                                .addComponent(firstNameLabel6))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(secondaryCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondaryAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(secondaryAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(firstNameLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vocationalScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(vocationalYearGraduatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstNameLabel11)
                                    .addComponent(firstNameLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vocationalHighestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(surnameLabel2)
                            .addGap(6, 6, 6)
                            .addComponent(vocationalSchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(middleNameLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(jLabel10)
                                .addComponent(firstNameLabel8))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(vocationalCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vocationalAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(vocationalAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(firstNameLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(collegeScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(collegeYearGraduatedTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstNameLabel15)
                                    .addComponent(firstNameLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(collegeHighestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(surnameLabel3)
                            .addGap(6, 6, 6)
                            .addComponent(collegeSchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(middleNameLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel12)
                                .addComponent(jLabel13)
                                .addComponent(firstNameLabel12))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(collegeCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(collegeAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(collegeAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(26, 26, 26)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(firstNameLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(graduateScholarshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(graduateYearGraduatedTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(firstNameLabel18)
                                    .addComponent(firstNameLabel16))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(graduateHighestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(surnameLabel4)
                            .addGap(6, 6, 6)
                            .addComponent(graduateSchoolTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(middleNameLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(jLabel16)
                                .addComponent(firstNameLabel19))
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(graduateCourseTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(graduateAttendFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(graduateAttendToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(233, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void elementarySchoolTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementarySchoolTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_elementarySchoolTextFieldFocusGained

    private void elementarySchoolTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementarySchoolTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_elementarySchoolTextFieldFocusLost

    private void elementarySchoolTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementarySchoolTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elementarySchoolTextFieldActionPerformed

    private void elementaryCourseTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryCourseTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryCourseTextFieldFocusGained

    private void elementaryCourseTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryCourseTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryCourseTextFieldFocusLost

    private void elementaryCourseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementaryCourseTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryCourseTextFieldActionPerformed

    private void elementaryAttendFromTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryAttendFromTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryAttendFromTextFieldFocusGained

    private void elementaryAttendFromTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryAttendFromTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryAttendFromTextFieldFocusLost

    private void elementaryAttendFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementaryAttendFromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryAttendFromTextFieldActionPerformed

    private void elementaryAttendToTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryAttendToTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryAttendToTextFieldFocusGained

    private void elementaryAttendToTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryAttendToTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryAttendToTextFieldFocusLost

    private void elementaryAttendToTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementaryAttendToTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryAttendToTextFieldActionPerformed

    private void elementaryYearGraduatedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryYearGraduatedTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryYearGraduatedTextFieldFocusGained

    private void elementaryYearGraduatedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryYearGraduatedTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryYearGraduatedTextFieldFocusLost

    private void elementaryYearGraduatedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementaryYearGraduatedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryYearGraduatedTextFieldActionPerformed

    private void elementaryHighestTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryHighestTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryHighestTextFieldFocusGained

    private void elementaryHighestTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryHighestTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryHighestTextFieldFocusLost

    private void elementaryHighestTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementaryHighestTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryHighestTextFieldActionPerformed

    private void elementaryScholarshipTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryScholarshipTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryScholarshipTextFieldFocusGained

    private void elementaryScholarshipTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_elementaryScholarshipTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryScholarshipTextFieldFocusLost

    private void elementaryScholarshipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elementaryScholarshipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_elementaryScholarshipTextFieldActionPerformed

    private void secondaryAttendFromTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryAttendFromTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryAttendFromTextFieldFocusGained

    private void secondaryAttendFromTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryAttendFromTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryAttendFromTextFieldFocusLost

    private void secondaryAttendFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondaryAttendFromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryAttendFromTextFieldActionPerformed

    private void secondaryScholarshipTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryScholarshipTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryScholarshipTextFieldFocusGained

    private void secondaryScholarshipTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryScholarshipTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryScholarshipTextFieldFocusLost

    private void secondaryScholarshipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondaryScholarshipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryScholarshipTextFieldActionPerformed

    private void secondaryAttendToTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryAttendToTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryAttendToTextFieldFocusGained

    private void secondaryAttendToTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryAttendToTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryAttendToTextFieldFocusLost

    private void secondaryAttendToTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondaryAttendToTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryAttendToTextFieldActionPerformed

    private void secondaryYearGraduatedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryYearGraduatedTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryYearGraduatedTextFieldFocusGained

    private void secondaryYearGraduatedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryYearGraduatedTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryYearGraduatedTextFieldFocusLost

    private void secondaryYearGraduatedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondaryYearGraduatedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryYearGraduatedTextFieldActionPerformed

    private void secondarySchoolTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondarySchoolTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_secondarySchoolTextFieldFocusGained

    private void secondarySchoolTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondarySchoolTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_secondarySchoolTextFieldFocusLost

    private void secondarySchoolTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondarySchoolTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondarySchoolTextFieldActionPerformed

    private void secondaryHighestTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryHighestTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryHighestTextFieldFocusGained

    private void secondaryHighestTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryHighestTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryHighestTextFieldFocusLost

    private void secondaryHighestTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondaryHighestTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryHighestTextFieldActionPerformed

    private void secondaryCourseTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryCourseTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryCourseTextFieldFocusGained

    private void secondaryCourseTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_secondaryCourseTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryCourseTextFieldFocusLost

    private void secondaryCourseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secondaryCourseTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secondaryCourseTextFieldActionPerformed

    private void vocationalHighestTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalHighestTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalHighestTextFieldFocusGained

    private void vocationalHighestTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalHighestTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalHighestTextFieldFocusLost

    private void vocationalHighestTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vocationalHighestTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalHighestTextFieldActionPerformed

    private void vocationalCourseTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalCourseTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalCourseTextFieldFocusGained

    private void vocationalCourseTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalCourseTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalCourseTextFieldFocusLost

    private void vocationalCourseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vocationalCourseTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalCourseTextFieldActionPerformed

    private void vocationalAttendFromTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalAttendFromTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalAttendFromTextFieldFocusGained

    private void vocationalAttendFromTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalAttendFromTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalAttendFromTextFieldFocusLost

    private void vocationalAttendFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vocationalAttendFromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalAttendFromTextFieldActionPerformed

    private void vocationalScholarshipTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalScholarshipTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalScholarshipTextFieldFocusGained

    private void vocationalScholarshipTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalScholarshipTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalScholarshipTextFieldFocusLost

    private void vocationalScholarshipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vocationalScholarshipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalScholarshipTextFieldActionPerformed

    private void vocationalAttendToTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalAttendToTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalAttendToTextFieldFocusGained

    private void vocationalAttendToTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalAttendToTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalAttendToTextFieldFocusLost

    private void vocationalAttendToTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vocationalAttendToTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalAttendToTextFieldActionPerformed

    private void vocationalYearGraduatedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalYearGraduatedTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalYearGraduatedTextFieldFocusGained

    private void vocationalYearGraduatedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalYearGraduatedTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalYearGraduatedTextFieldFocusLost

    private void vocationalYearGraduatedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vocationalYearGraduatedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalYearGraduatedTextFieldActionPerformed

    private void vocationalSchoolTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalSchoolTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalSchoolTextFieldFocusGained

    private void vocationalSchoolTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_vocationalSchoolTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalSchoolTextFieldFocusLost

    private void vocationalSchoolTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vocationalSchoolTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vocationalSchoolTextFieldActionPerformed

    private void collegeHighestTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeHighestTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeHighestTextFieldFocusGained

    private void collegeHighestTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeHighestTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeHighestTextFieldFocusLost

    private void collegeHighestTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeHighestTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeHighestTextFieldActionPerformed

    private void collegeCourseTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeCourseTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeCourseTextFieldFocusGained

    private void collegeCourseTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeCourseTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeCourseTextFieldFocusLost

    private void collegeCourseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeCourseTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeCourseTextFieldActionPerformed

    private void collegeAttendFromTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeAttendFromTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeAttendFromTextFieldFocusGained

    private void collegeAttendFromTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeAttendFromTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeAttendFromTextFieldFocusLost

    private void collegeAttendFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeAttendFromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeAttendFromTextFieldActionPerformed

    private void collegeScholarshipTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeScholarshipTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeScholarshipTextFieldFocusGained

    private void collegeScholarshipTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeScholarshipTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeScholarshipTextFieldFocusLost

    private void collegeScholarshipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeScholarshipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeScholarshipTextFieldActionPerformed

    private void collegeAttendToTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeAttendToTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeAttendToTextFieldFocusGained

    private void collegeAttendToTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeAttendToTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeAttendToTextFieldFocusLost

    private void collegeAttendToTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeAttendToTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeAttendToTextFieldActionPerformed

    private void collegeYearGraduatedTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeYearGraduatedTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeYearGraduatedTextFieldFocusGained

    private void collegeYearGraduatedTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeYearGraduatedTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeYearGraduatedTextFieldFocusLost

    private void collegeYearGraduatedTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeYearGraduatedTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeYearGraduatedTextFieldActionPerformed

    private void collegeSchoolTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeSchoolTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeSchoolTextFieldFocusGained

    private void collegeSchoolTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_collegeSchoolTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeSchoolTextFieldFocusLost

    private void collegeSchoolTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collegeSchoolTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_collegeSchoolTextFieldActionPerformed

    private void graduateHighestTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateHighestTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateHighestTextFieldFocusGained

    private void graduateHighestTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateHighestTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateHighestTextFieldFocusLost

    private void graduateHighestTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduateHighestTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateHighestTextFieldActionPerformed

    private void graduateCourseTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateCourseTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateCourseTextFieldFocusGained

    private void graduateCourseTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateCourseTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateCourseTextFieldFocusLost

    private void graduateCourseTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduateCourseTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateCourseTextFieldActionPerformed

    private void graduateAttendFromTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateAttendFromTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateAttendFromTextFieldFocusGained

    private void graduateAttendFromTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateAttendFromTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateAttendFromTextFieldFocusLost

    private void graduateAttendFromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduateAttendFromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateAttendFromTextFieldActionPerformed

    private void graduateScholarshipTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateScholarshipTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateScholarshipTextFieldFocusGained

    private void graduateScholarshipTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateScholarshipTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateScholarshipTextFieldFocusLost

    private void graduateScholarshipTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduateScholarshipTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateScholarshipTextFieldActionPerformed

    private void graduateAttendToTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateAttendToTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateAttendToTextFieldFocusGained

    private void graduateAttendToTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateAttendToTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateAttendToTextFieldFocusLost

    private void graduateAttendToTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduateAttendToTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateAttendToTextFieldActionPerformed

    private void graduateSchoolTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateSchoolTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateSchoolTextFieldFocusGained

    private void graduateSchoolTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateSchoolTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateSchoolTextFieldFocusLost

    private void graduateSchoolTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduateSchoolTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateSchoolTextFieldActionPerformed

    private void graduateYearGraduatedTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateYearGraduatedTextField1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateYearGraduatedTextField1FocusGained

    private void graduateYearGraduatedTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_graduateYearGraduatedTextField1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateYearGraduatedTextField1FocusLost

    private void graduateYearGraduatedTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graduateYearGraduatedTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_graduateYearGraduatedTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField collegeAttendFromTextField;
    private javax.swing.JTextField collegeAttendToTextField;
    private javax.swing.JTextField collegeCourseTextField;
    private javax.swing.JTextField collegeHighestTextField;
    private javax.swing.JTextField collegeScholarshipTextField;
    private javax.swing.JTextField collegeSchoolTextField;
    private javax.swing.JTextField collegeYearGraduatedTextField;
    private javax.swing.JTextField elementaryAttendFromTextField;
    private javax.swing.JTextField elementaryAttendToTextField;
    private javax.swing.JTextField elementaryCourseTextField;
    private javax.swing.JTextField elementaryHighestTextField;
    private javax.swing.JTextField elementaryScholarshipTextField;
    private javax.swing.JTextField elementarySchoolTextField;
    private javax.swing.JTextField elementaryYearGraduatedTextField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel firstNameLabel1;
    private javax.swing.JLabel firstNameLabel10;
    private javax.swing.JLabel firstNameLabel11;
    private javax.swing.JLabel firstNameLabel12;
    private javax.swing.JLabel firstNameLabel13;
    private javax.swing.JLabel firstNameLabel14;
    private javax.swing.JLabel firstNameLabel15;
    private javax.swing.JLabel firstNameLabel16;
    private javax.swing.JLabel firstNameLabel17;
    private javax.swing.JLabel firstNameLabel18;
    private javax.swing.JLabel firstNameLabel19;
    private javax.swing.JLabel firstNameLabel2;
    private javax.swing.JLabel firstNameLabel3;
    private javax.swing.JLabel firstNameLabel4;
    private javax.swing.JLabel firstNameLabel5;
    private javax.swing.JLabel firstNameLabel6;
    private javax.swing.JLabel firstNameLabel7;
    private javax.swing.JLabel firstNameLabel8;
    private javax.swing.JLabel firstNameLabel9;
    private javax.swing.JTextField graduateAttendFromTextField;
    private javax.swing.JTextField graduateAttendToTextField;
    private javax.swing.JTextField graduateCourseTextField;
    private javax.swing.JTextField graduateHighestTextField;
    private javax.swing.JTextField graduateScholarshipTextField;
    private javax.swing.JTextField graduateSchoolTextField;
    private javax.swing.JTextField graduateYearGraduatedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JLabel middleNameLabel1;
    private javax.swing.JLabel middleNameLabel2;
    private javax.swing.JLabel middleNameLabel3;
    private javax.swing.JLabel middleNameLabel4;
    private javax.swing.JTextField secondaryAttendFromTextField;
    private javax.swing.JTextField secondaryAttendToTextField;
    private javax.swing.JTextField secondaryCourseTextField;
    private javax.swing.JTextField secondaryHighestTextField;
    private javax.swing.JTextField secondaryScholarshipTextField;
    private javax.swing.JTextField secondarySchoolTextField;
    private javax.swing.JTextField secondaryYearGraduatedTextField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel surnameLabel1;
    private javax.swing.JLabel surnameLabel2;
    private javax.swing.JLabel surnameLabel3;
    private javax.swing.JLabel surnameLabel4;
    private javax.swing.JTextField vocationalAttendFromTextField;
    private javax.swing.JTextField vocationalAttendToTextField;
    private javax.swing.JTextField vocationalCourseTextField;
    private javax.swing.JTextField vocationalHighestTextField;
    private javax.swing.JTextField vocationalScholarshipTextField;
    private javax.swing.JTextField vocationalSchoolTextField;
    private javax.swing.JTextField vocationalYearGraduatedTextField;
    // End of variables declaration//GEN-END:variables
}
