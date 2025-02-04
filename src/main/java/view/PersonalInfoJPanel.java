/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import javax.swing.JOptionPane;
import model.CivilStatus;
import model.Sex;

public class PersonalInfoJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PersonalInfoJPanel
     */
    public PersonalInfoJPanel() {
        initComponents();
    }

    public String getSurname() {
        return surnameTextField.getText();
    }

    public String getFirstName() {
        return firstNameTextField1.getText();
    }

    public String getMiddleName() {
        return middleNameTextField.getText();
    }

    public String getNameExtension() {
        return nameExtensionTextField.getText();
    }

    public LocalDate getDateOfBirth() {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("M/d/yyyy");
            Date date = dateFormat.parse(dateOfBirthTextField.getText());
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Invalid date format. Please use MM/dd/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public String getPlaceOfBirth() {
        return placeOfBirthTextField.getText();
    }

    public Sex getSex() {
        if (maleButton.isSelected()) {
            return Sex.MALE;
        } else if (femaleButton.isSelected()) {
            return Sex.FEMALE;
        } else if (otherButton.isSelected()) {
            return Sex.OTHER;
        } else {
            return null;
        }
    }

    public CivilStatus getCivilStatus() {
        if (singleButton.isSelected()) {
            return CivilStatus.SINGLE;
        } else if (marriedButton.isSelected()) {
            return CivilStatus.MARRIED;
        } else if (widowedButton.isSelected()) {
            return CivilStatus.WIDOWED;
        } else if (separateButton.isSelected()) {
            return CivilStatus.SEPARATED;
        } else {
            return null;
        }
    }

    public double getHeightInput() {
        try {
            return Double.parseDouble(heightTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid height format.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0.0; // Or a default value
        }
    }

    public double getWeight() {
        try {
            return Double.parseDouble(weightTextField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid weight format.", "Error", JOptionPane.ERROR_MESSAGE);
            return 0.0; // Or a default value
        }
    }

    public String getBloodType() {
        return bloodTypeTextField.getText();
    }

    public String getGsisIdNo() {
        return gsisIdNoTextField.getText();
    }

    public String getPagibigIdNo() {
        return pagIbigIdNoTextField.getText();
    }

    public String getPhilhealthNo() {
        return philHealthNo.getText();
    }

    public String getSssNo() {
        return sssNoTextField.getText();
    }

    public String getTinNo() {
        return tinNoTextField.getText();
    }

    public String getAgencyEmployeeNo() {
        return agencyEmployeeNoTextField.getText();
    }

    public String getCitizenship() {
        if (filipinoButton.isSelected()) {
            return "Filipino";
        } else if (dualCitizenshipButton.isSelected()) {
            return "Dual Citizenship";
        } else {
            return "";
        }
    }

    public boolean isDualCitizen() {
        return dualCitizenshipButton.isSelected();
    }

    public String getDualCitizenshipType() {
        if (citizenshipByBirthRadioButton.isSelected()) {
            return "By Birth";
        } else if (citizenshipByNaturalizationRadioButton.isSelected()) {
            return "By Naturalization";
        } else {
            return "";
        }
    }

    public String getCountry() {
        return countryTextField.getText();
    }

    // Getters for Residential Address
    public String getResidentialHouseBlockLot() {
        return residentialHouseBlockLotTextField.getText();
    }

    public String getResidentialStreet() {
        return residentialStreetTextField.getText();
    }

    public String getResidentialSubdivisionVillage() {
        return residentialSubdivisionVillageTextField.getText();
    }

    public String getResidentialBarangay() {
        return residentialBarangayTextField.getText();
    }

    public String getResidentialCityMunicipality() {
        return residentialCityMunicipalityTextField.getText();
    }

    public String getResidentialProvince() {
        return residentialProvinceTextField.getText();
    }

    public String getResidentialZipCode() {
        return residentialZipCodeTextField.getText();
    }

    // Getters for Permanent Address
    public String getPermanentHouseBlockLot() {
        return permanentHouseBlockLotTextField.getText();
    }

    public String getPermanentStreet() {
        return permanentStreetTextField.getText();
    }

    public String getPermanentSubdivisionVillage() {
        return permanentSubdivisionVillageTextField.getText();
    }

    public String getPermanentBarangay() {
        return permanentBarangayTextField.getText();
    }

    public String getPermanentCityMunicipality() {
        return permanentCityMunicipalityTextField.getText();
    }

    public String getPermanentProvince() {
        return permanentProvinceTextField.getText();
    }

    public String getPermanentZipCode() {
        return permanentZipCodeTextField.getText();
    }

    public String getTelephoneNo() {
        return telephoneNoTextField.getText();
    }

    public String getMobileNo() {
        return mobileNoTextField.getText();
    }

    public String getEmailAddress() {
        return emailAddressTextField.getText();
    }

    public void refreshData() {
        surnameTextField.setText("");
        firstNameTextField1.setText("");
        middleNameTextField.setText("");
        nameExtensionTextField.setText("");
        dateOfBirthTextField.setValue(null);
        placeOfBirthTextField.setText("");

        sexButtonGroup.clearSelection();
        civilStatusButtonGroup.clearSelection();
        citizenshipButtonGroup.clearSelection();

        heightTextField.setText("");
        weightTextField.setText("");
        bloodTypeTextField.setText("");
        gsisIdNoTextField.setText("");
        pagIbigIdNoTextField.setText("");
        philHealthNo.setText("");
        sssNoTextField.setText("");
        tinNoTextField.setText("");
        agencyEmployeeNoTextField.setText("");
        dualCitizenshipButton.setSelected(false);

        citizenshipByBirthRadioButton.setEnabled(false);
        citizenshipByNaturalizationRadioButton.setEnabled(false);
        countryTextField.setEnabled(false);
        citizenshipButtonGroup.clearSelection();
        countryTextField.setText("");

        residentialHouseBlockLotTextField.setText("");
        residentialStreetTextField.setText("");
        residentialSubdivisionVillageTextField.setText("");
        residentialBarangayTextField.setText("");
        residentialCityMunicipalityTextField.setText("");
        residentialProvinceTextField.setText("");
        residentialZipCodeTextField.setText("");

        permanentHouseBlockLotTextField.setText("");
        permanentStreetTextField.setText("");
        permanentSubdivisionVillageTextField.setText("");
        permanentBarangayTextField.setText("");
        permanentCityMunicipalityTextField.setText("");
        permanentProvinceTextField.setText("");
        permanentZipCodeTextField.setText("");

        telephoneNoTextField.setText("");
        mobileNoTextField.setText("");
        emailAddressTextField.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexButtonGroup = new javax.swing.ButtonGroup();
        civilStatusButtonGroup = new javax.swing.ButtonGroup();
        citizenshipButtonGroup = new javax.swing.ButtonGroup();
        citizenButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        surnameLabel = new javax.swing.JLabel();
        surnameTextField = new javax.swing.JTextField();
        firstNameTextField1 = new javax.swing.JTextField();
        firstNameLabel = new javax.swing.JLabel();
        middleNameLabel = new javax.swing.JLabel();
        middleNameTextField = new javax.swing.JTextField();
        nameExtensionLabel = new javax.swing.JLabel();
        nameExtensionTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dobLabel = new javax.swing.JLabel();
        dateOfBirthTextField = new javax.swing.JFormattedTextField();
        dobLabel1 = new javax.swing.JLabel();
        placeOfBirthTextField = new javax.swing.JTextField();
        dobLabel2 = new javax.swing.JLabel();
        heightTextField = new javax.swing.JTextField();
        nameExtensionLabel1 = new javax.swing.JLabel();
        weightTextField = new javax.swing.JTextField();
        nameExtensionLabel2 = new javax.swing.JLabel();
        bloodTypeTextField = new javax.swing.JTextField();
        femaleButton = new javax.swing.JRadioButton();
        maleButton = new javax.swing.JRadioButton();
        surnameLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        singleButton = new javax.swing.JRadioButton();
        marriedButton = new javax.swing.JRadioButton();
        widowedButton = new javax.swing.JRadioButton();
        separateButton = new javax.swing.JRadioButton();
        otherButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        nameExtensionLabel3 = new javax.swing.JLabel();
        gsisIdNoTextField = new javax.swing.JTextField();
        nameExtensionLabel4 = new javax.swing.JLabel();
        pagIbigIdNoTextField = new javax.swing.JTextField();
        nameExtensionLabel5 = new javax.swing.JLabel();
        philHealthNo = new javax.swing.JTextField();
        nameExtensionLabel6 = new javax.swing.JLabel();
        sssNoTextField = new javax.swing.JTextField();
        nameExtensionLabel7 = new javax.swing.JLabel();
        tinNoTextField = new javax.swing.JTextField();
        nameExtensionLabel8 = new javax.swing.JLabel();
        agencyEmployeeNoTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        surnameLabel2 = new javax.swing.JLabel();
        filipinoButton = new javax.swing.JRadioButton();
        dualCitizenshipButton = new javax.swing.JRadioButton();
        citizenshipByBirthRadioButton = new javax.swing.JRadioButton();
        citizenshipByNaturalizationRadioButton = new javax.swing.JRadioButton();
        surnameLabel3 = new javax.swing.JLabel();
        countryTextField = new javax.swing.JTextField();
        surnameLabel5 = new javax.swing.JLabel();
        surnameLabel4 = new javax.swing.JLabel();
        residentialHouseBlockLotTextField = new javax.swing.JTextField();
        surnameLabel6 = new javax.swing.JLabel();
        residentialStreetTextField = new javax.swing.JTextField();
        surnameLabel7 = new javax.swing.JLabel();
        residentialSubdivisionVillageTextField = new javax.swing.JTextField();
        barangayLabel = new javax.swing.JLabel();
        residentialBarangayTextField = new javax.swing.JTextField();
        barangayLabel1 = new javax.swing.JLabel();
        residentialCityMunicipalityTextField = new javax.swing.JTextField();
        residentialProvinceTextField = new javax.swing.JTextField();
        barangayLabel2 = new javax.swing.JLabel();
        barangayLabel3 = new javax.swing.JLabel();
        residentialZipCodeTextField = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        permanentZipCodeTextField = new javax.swing.JTextField();
        surnameLabel12 = new javax.swing.JLabel();
        permanentHouseBlockLotTextField = new javax.swing.JTextField();
        surnameLabel13 = new javax.swing.JLabel();
        surnameLabel14 = new javax.swing.JLabel();
        permanentStreetTextField = new javax.swing.JTextField();
        surnameLabel15 = new javax.swing.JLabel();
        permanentSubdivisionVillageTextField = new javax.swing.JTextField();
        barangayLabel8 = new javax.swing.JLabel();
        permanentBarangayTextField = new javax.swing.JTextField();
        barangayLabel9 = new javax.swing.JLabel();
        permanentCityMunicipalityTextField = new javax.swing.JTextField();
        barangayLabel10 = new javax.swing.JLabel();
        permanentProvinceTextField = new javax.swing.JTextField();
        barangayLabel11 = new javax.swing.JLabel();
        surnameLabel16 = new javax.swing.JLabel();
        telephoneNoTextField = new javax.swing.JTextField();
        surnameLabel17 = new javax.swing.JLabel();
        mobileNoTextField = new javax.swing.JTextField();
        surnameLabel18 = new javax.swing.JLabel();
        emailAddressTextField = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(243, 244, 246));
        setVerifyInputWhenFocusTarget(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Personal Information");

        surnameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel.setText("Surname");

        surnameTextField.setBackground(new java.awt.Color(250, 250, 250));
        surnameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                surnameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                surnameTextFieldFocusLost(evt);
            }
        });
        surnameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameTextFieldActionPerformed(evt);
            }
        });

        firstNameTextField1.setBackground(new java.awt.Color(250, 250, 250));
        firstNameTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                firstNameTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                firstNameTextField1FocusLost(evt);
            }
        });
        firstNameTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextField1ActionPerformed(evt);
            }
        });

        firstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        firstNameLabel.setText("First Name");

        middleNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        middleNameLabel.setText("Middle Name");

        middleNameTextField.setBackground(new java.awt.Color(250, 250, 250));
        middleNameTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                middleNameTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                middleNameTextFieldFocusLost(evt);
            }
        });
        middleNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleNameTextFieldActionPerformed(evt);
            }
        });

        nameExtensionLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel.setText("Ext.");

        nameExtensionTextField.setBackground(new java.awt.Color(250, 250, 250));
        nameExtensionTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nameExtensionTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nameExtensionTextFieldFocusLost(evt);
            }
        });
        nameExtensionTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameExtensionTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel2.setText("Basic Information");

        dobLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dobLabel.setText("Date of Birth (mm/dd/yy)");
        dobLabel.setToolTipText("");

        dateOfBirthTextField.setBackground(new java.awt.Color(250, 250, 250));
        dateOfBirthTextField.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("M/d/yyyy"))));

        dobLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dobLabel1.setText("Place of Birth");
        dobLabel1.setToolTipText("");

        placeOfBirthTextField.setBackground(new java.awt.Color(250, 250, 250));
        placeOfBirthTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                placeOfBirthTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                placeOfBirthTextFieldFocusLost(evt);
            }
        });
        placeOfBirthTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                placeOfBirthTextFieldActionPerformed(evt);
            }
        });

        dobLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dobLabel2.setText("Height (m)");
        dobLabel2.setToolTipText("");

        heightTextField.setBackground(new java.awt.Color(250, 250, 250));
        heightTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                heightTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                heightTextFieldFocusLost(evt);
            }
        });
        heightTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightTextFieldActionPerformed(evt);
            }
        });

        nameExtensionLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel1.setText("Weight (kg)");

        weightTextField.setBackground(new java.awt.Color(250, 250, 250));
        weightTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                weightTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                weightTextFieldFocusLost(evt);
            }
        });
        weightTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightTextFieldActionPerformed(evt);
            }
        });

        nameExtensionLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel2.setText("Blood Type");

        bloodTypeTextField.setBackground(new java.awt.Color(250, 250, 250));
        bloodTypeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                bloodTypeTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                bloodTypeTextFieldFocusLost(evt);
            }
        });
        bloodTypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bloodTypeTextFieldActionPerformed(evt);
            }
        });

        sexButtonGroup.add(femaleButton);
        femaleButton.setText("Female");
        femaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleButtonActionPerformed(evt);
            }
        });

        sexButtonGroup.add(maleButton);
        maleButton.setText("Male");
        maleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleButtonActionPerformed(evt);
            }
        });

        surnameLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel1.setText("Sex");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Civil Status");

        civilStatusButtonGroup.add(singleButton);
        singleButton.setText("Single");
        singleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singleButtonActionPerformed(evt);
            }
        });

        civilStatusButtonGroup.add(marriedButton);
        marriedButton.setText("Married");
        marriedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                marriedButtonActionPerformed(evt);
            }
        });

        civilStatusButtonGroup.add(widowedButton);
        widowedButton.setText("Widowed");
        widowedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                widowedButtonActionPerformed(evt);
            }
        });

        civilStatusButtonGroup.add(separateButton);
        separateButton.setText("Separate");
        separateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                separateButtonActionPerformed(evt);
            }
        });

        civilStatusButtonGroup.add(otherButton);
        otherButton.setText("Other/s");
        otherButton.setToolTipText("");
        otherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                otherButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel4.setText("Government IDs/Citizenship");

        nameExtensionLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel3.setText("GSIS ID No.");

        gsisIdNoTextField.setBackground(new java.awt.Color(250, 250, 250));
        gsisIdNoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gsisIdNoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                gsisIdNoTextFieldFocusLost(evt);
            }
        });
        gsisIdNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gsisIdNoTextFieldActionPerformed(evt);
            }
        });

        nameExtensionLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel4.setText("PAG-IBIG ID No.");

        pagIbigIdNoTextField.setBackground(new java.awt.Color(250, 250, 250));
        pagIbigIdNoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pagIbigIdNoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pagIbigIdNoTextFieldFocusLost(evt);
            }
        });
        pagIbigIdNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagIbigIdNoTextFieldActionPerformed(evt);
            }
        });

        nameExtensionLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel5.setText("PhilHealth No.");

        philHealthNo.setBackground(new java.awt.Color(250, 250, 250));
        philHealthNo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                philHealthNoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                philHealthNoFocusLost(evt);
            }
        });
        philHealthNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                philHealthNoActionPerformed(evt);
            }
        });

        nameExtensionLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel6.setText("SSS No.");

        sssNoTextField.setBackground(new java.awt.Color(250, 250, 250));
        sssNoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                sssNoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                sssNoTextFieldFocusLost(evt);
            }
        });
        sssNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sssNoTextFieldActionPerformed(evt);
            }
        });

        nameExtensionLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel7.setText("TIN No.");

        tinNoTextField.setBackground(new java.awt.Color(250, 250, 250));
        tinNoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tinNoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tinNoTextFieldFocusLost(evt);
            }
        });
        tinNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tinNoTextFieldActionPerformed(evt);
            }
        });

        nameExtensionLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nameExtensionLabel8.setText("Agency Employee No.");

        agencyEmployeeNoTextField.setBackground(new java.awt.Color(250, 250, 250));
        agencyEmployeeNoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                agencyEmployeeNoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                agencyEmployeeNoTextFieldFocusLost(evt);
            }
        });
        agencyEmployeeNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agencyEmployeeNoTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel5.setText("Address/Contact Information");

        surnameLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel2.setText("Citizenship");

        citizenshipButtonGroup.add(filipinoButton);
        filipinoButton.setText("Filipino");
        filipinoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filipinoButtonActionPerformed(evt);
            }
        });

        citizenshipButtonGroup.add(dualCitizenshipButton);
        dualCitizenshipButton.setText("Dual Citizenship");
        dualCitizenshipButton.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                dualCitizenshipButtonItemStateChanged(evt);
            }
        });
        dualCitizenshipButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dualCitizenshipButtonActionPerformed(evt);
            }
        });

        citizenButtonGroup.add(citizenshipByBirthRadioButton);
        citizenshipByBirthRadioButton.setText("by birth");
        citizenshipByBirthRadioButton.setEnabled(false);
        citizenshipByBirthRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citizenshipByBirthRadioButtonActionPerformed(evt);
            }
        });

        citizenButtonGroup.add(citizenshipByNaturalizationRadioButton);
        citizenshipByNaturalizationRadioButton.setText("by naturalization");
        citizenshipByNaturalizationRadioButton.setEnabled(false);
        citizenshipByNaturalizationRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citizenshipByNaturalizationRadioButtonActionPerformed(evt);
            }
        });

        surnameLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel3.setText("Country (if dual citizenship)");

        countryTextField.setBackground(new java.awt.Color(250, 250, 250));
        countryTextField.setEnabled(false);
        countryTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                countryTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                countryTextFieldFocusLost(evt);
            }
        });
        countryTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryTextFieldActionPerformed(evt);
            }
        });

        surnameLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        surnameLabel5.setText("Residential Address");

        surnameLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel4.setText("House/Block/Lot No.");

        residentialHouseBlockLotTextField.setBackground(new java.awt.Color(250, 250, 250));
        residentialHouseBlockLotTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                residentialHouseBlockLotTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                residentialHouseBlockLotTextFieldFocusLost(evt);
            }
        });
        residentialHouseBlockLotTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialHouseBlockLotTextFieldActionPerformed(evt);
            }
        });

        surnameLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel6.setText("Street");

        residentialStreetTextField.setBackground(new java.awt.Color(250, 250, 250));
        residentialStreetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                residentialStreetTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                residentialStreetTextFieldFocusLost(evt);
            }
        });
        residentialStreetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialStreetTextFieldActionPerformed(evt);
            }
        });

        surnameLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel7.setText("Subdivision/Village");

        residentialSubdivisionVillageTextField.setBackground(new java.awt.Color(250, 250, 250));
        residentialSubdivisionVillageTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                residentialSubdivisionVillageTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                residentialSubdivisionVillageTextFieldFocusLost(evt);
            }
        });
        residentialSubdivisionVillageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialSubdivisionVillageTextFieldActionPerformed(evt);
            }
        });

        barangayLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangayLabel.setText("Barangay");

        residentialBarangayTextField.setBackground(new java.awt.Color(250, 250, 250));
        residentialBarangayTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                residentialBarangayTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                residentialBarangayTextFieldFocusLost(evt);
            }
        });
        residentialBarangayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialBarangayTextFieldActionPerformed(evt);
            }
        });

        barangayLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangayLabel1.setText("City/Municipality");

        residentialCityMunicipalityTextField.setBackground(new java.awt.Color(250, 250, 250));
        residentialCityMunicipalityTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                residentialCityMunicipalityTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                residentialCityMunicipalityTextFieldFocusLost(evt);
            }
        });
        residentialCityMunicipalityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialCityMunicipalityTextFieldActionPerformed(evt);
            }
        });

        residentialProvinceTextField.setBackground(new java.awt.Color(250, 250, 250));
        residentialProvinceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                residentialProvinceTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                residentialProvinceTextFieldFocusLost(evt);
            }
        });
        residentialProvinceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialProvinceTextFieldActionPerformed(evt);
            }
        });

        barangayLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangayLabel2.setText("Province");

        barangayLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangayLabel3.setText("ZIP Code");

        residentialZipCodeTextField.setBackground(new java.awt.Color(250, 250, 250));
        residentialZipCodeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                residentialZipCodeTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                residentialZipCodeTextFieldFocusLost(evt);
            }
        });
        residentialZipCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                residentialZipCodeTextFieldActionPerformed(evt);
            }
        });

        permanentZipCodeTextField.setBackground(new java.awt.Color(250, 250, 250));
        permanentZipCodeTextField.setMinimumSize(new java.awt.Dimension(64, 30));
        permanentZipCodeTextField.setPreferredSize(new java.awt.Dimension(77, 30));
        permanentZipCodeTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                permanentZipCodeTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                permanentZipCodeTextFieldFocusLost(evt);
            }
        });
        permanentZipCodeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanentZipCodeTextFieldActionPerformed(evt);
            }
        });

        surnameLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel12.setText("House/Block/Lot No.");

        permanentHouseBlockLotTextField.setBackground(new java.awt.Color(250, 250, 250));
        permanentHouseBlockLotTextField.setPreferredSize(new java.awt.Dimension(64, 30));
        permanentHouseBlockLotTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                permanentHouseBlockLotTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                permanentHouseBlockLotTextFieldFocusLost(evt);
            }
        });
        permanentHouseBlockLotTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanentHouseBlockLotTextFieldActionPerformed(evt);
            }
        });

        surnameLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        surnameLabel13.setText("Permanent Address");

        surnameLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel14.setText("Street");

        permanentStreetTextField.setBackground(new java.awt.Color(250, 250, 250));
        permanentStreetTextField.setPreferredSize(new java.awt.Dimension(64, 30));
        permanentStreetTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                permanentStreetTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                permanentStreetTextFieldFocusLost(evt);
            }
        });
        permanentStreetTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanentStreetTextFieldActionPerformed(evt);
            }
        });

        surnameLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel15.setText("Subdivision/Village");

        permanentSubdivisionVillageTextField.setBackground(new java.awt.Color(250, 250, 250));
        permanentSubdivisionVillageTextField.setPreferredSize(new java.awt.Dimension(64, 30));
        permanentSubdivisionVillageTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                permanentSubdivisionVillageTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                permanentSubdivisionVillageTextFieldFocusLost(evt);
            }
        });
        permanentSubdivisionVillageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanentSubdivisionVillageTextFieldActionPerformed(evt);
            }
        });

        barangayLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangayLabel8.setText("Barangay");

        permanentBarangayTextField.setBackground(new java.awt.Color(250, 250, 250));
        permanentBarangayTextField.setPreferredSize(new java.awt.Dimension(64, 30));
        permanentBarangayTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                permanentBarangayTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                permanentBarangayTextFieldFocusLost(evt);
            }
        });
        permanentBarangayTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanentBarangayTextFieldActionPerformed(evt);
            }
        });

        barangayLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangayLabel9.setText("City/Municipality");

        permanentCityMunicipalityTextField.setBackground(new java.awt.Color(250, 250, 250));
        permanentCityMunicipalityTextField.setPreferredSize(new java.awt.Dimension(64, 30));
        permanentCityMunicipalityTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                permanentCityMunicipalityTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                permanentCityMunicipalityTextFieldFocusLost(evt);
            }
        });
        permanentCityMunicipalityTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanentCityMunicipalityTextFieldActionPerformed(evt);
            }
        });

        barangayLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangayLabel10.setText("Province");

        permanentProvinceTextField.setBackground(new java.awt.Color(250, 250, 250));
        permanentProvinceTextField.setPreferredSize(new java.awt.Dimension(64, 30));
        permanentProvinceTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                permanentProvinceTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                permanentProvinceTextFieldFocusLost(evt);
            }
        });
        permanentProvinceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanentProvinceTextFieldActionPerformed(evt);
            }
        });

        barangayLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barangayLabel11.setText("ZIP Code");

        surnameLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel16.setText("Telephone No.");

        telephoneNoTextField.setBackground(new java.awt.Color(250, 250, 250));
        telephoneNoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                telephoneNoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                telephoneNoTextFieldFocusLost(evt);
            }
        });
        telephoneNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telephoneNoTextFieldActionPerformed(evt);
            }
        });

        surnameLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel17.setText("Mobile No.");

        mobileNoTextField.setBackground(new java.awt.Color(250, 250, 250));
        mobileNoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mobileNoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                mobileNoTextFieldFocusLost(evt);
            }
        });
        mobileNoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobileNoTextFieldActionPerformed(evt);
            }
        });

        surnameLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        surnameLabel18.setText("Email Address (if any)");

        emailAddressTextField.setBackground(new java.awt.Color(250, 250, 250));
        emailAddressTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailAddressTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailAddressTextFieldFocusLost(evt);
            }
        });
        emailAddressTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailAddressTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 949, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(surnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(firstNameLabel)
                .addGap(180, 180, 180)
                .addComponent(middleNameLabel)
                .addGap(158, 158, 158)
                .addComponent(nameExtensionLabel))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(firstNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(middleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(nameExtensionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(dobLabel)
                .addGap(95, 95, 95)
                .addComponent(dobLabel1)
                .addGap(166, 166, 166)
                .addComponent(dobLabel2)
                .addGap(175, 175, 175)
                .addComponent(nameExtensionLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(dateOfBirthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(placeOfBirthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameExtensionLabel2)
                    .addComponent(bloodTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLabel1)
                    .addComponent(maleButton))
                .addGap(18, 18, 18)
                .addComponent(femaleButton)
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(singleButton))
                .addGap(24, 24, 24)
                .addComponent(marriedButton)
                .addGap(26, 26, 26)
                .addComponent(widowedButton)
                .addGap(18, 18, 18)
                .addComponent(separateButton)
                .addGap(26, 26, 26)
                .addComponent(otherButton))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(nameExtensionLabel3)
                .addGap(179, 179, 179)
                .addComponent(nameExtensionLabel4)
                .addGap(136, 136, 136)
                .addComponent(nameExtensionLabel5)
                .addGap(155, 155, 155)
                .addComponent(nameExtensionLabel6))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(gsisIdNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pagIbigIdNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(philHealthNo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(sssNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameExtensionLabel7)
                    .addComponent(tinNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameExtensionLabel8)
                    .addComponent(agencyEmployeeNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(filipinoButton)
                        .addGap(18, 18, 18)
                        .addComponent(dualCitizenshipButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(citizenshipByBirthRadioButton)
                        .addGap(16, 16, 16)
                        .addComponent(citizenshipByNaturalizationRadioButton)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLabel3)
                    .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 960, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(surnameLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(surnameLabel4)
                .addGap(124, 124, 124)
                .addComponent(surnameLabel6)
                .addGap(214, 214, 214)
                .addComponent(surnameLabel7))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(residentialHouseBlockLotTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(residentialStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(residentialSubdivisionVillageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(barangayLabel)
                .addGap(193, 193, 193)
                .addComponent(barangayLabel1)
                .addGap(147, 147, 147)
                .addComponent(barangayLabel2)
                .addGap(198, 198, 198)
                .addComponent(barangayLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(residentialBarangayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(residentialCityMunicipalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(residentialProvinceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(residentialZipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(surnameLabel13))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(surnameLabel12)
                .addGap(121, 121, 121)
                .addComponent(surnameLabel14)
                .addGap(223, 223, 223)
                .addComponent(surnameLabel15))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(permanentHouseBlockLotTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(permanentStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(permanentSubdivisionVillageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(barangayLabel8)
                .addGap(190, 190, 190)
                .addComponent(barangayLabel9)
                .addGap(156, 156, 156)
                .addComponent(barangayLabel10)
                .addGap(191, 191, 191)
                .addComponent(barangayLabel11))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(permanentBarangayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(permanentCityMunicipalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(permanentProvinceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(permanentZipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(surnameLabel16)
                .addGap(162, 162, 162)
                .addComponent(surnameLabel17)
                .addGap(193, 193, 193)
                .addComponent(surnameLabel18))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(telephoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(mobileNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(emailAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLabel)
                    .addComponent(firstNameLabel)
                    .addComponent(middleNameLabel)
                    .addComponent(nameExtensionLabel))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstNameTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(middleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameExtensionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dobLabel2)
                    .addComponent(nameExtensionLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dobLabel)
                            .addComponent(dobLabel1))))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(weightTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateOfBirthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(placeOfBirthTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameExtensionLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(bloodTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(surnameLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(maleButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(femaleButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(singleButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(marriedButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(widowedButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(separateButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(otherButton)))
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameExtensionLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nameExtensionLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(nameExtensionLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nameExtensionLabel6)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sssNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(gsisIdNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pagIbigIdNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(philHealthNo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(nameExtensionLabel7)
                        .addGap(6, 6, 6)
                        .addComponent(tinNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(nameExtensionLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(agencyEmployeeNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(surnameLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filipinoButton)
                            .addComponent(dualCitizenshipButton))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(citizenshipByBirthRadioButton)
                            .addComponent(citizenshipByNaturalizationRadioButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(surnameLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(countryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addGap(2, 2, 2)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(surnameLabel5)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLabel4)
                    .addComponent(surnameLabel6)
                    .addComponent(surnameLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(residentialHouseBlockLotTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(residentialStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(residentialSubdivisionVillageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barangayLabel)
                    .addComponent(barangayLabel1)
                    .addComponent(barangayLabel2)
                    .addComponent(barangayLabel3))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(residentialBarangayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(residentialCityMunicipalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(residentialProvinceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(residentialZipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(surnameLabel13)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLabel12)
                    .addComponent(surnameLabel14)
                    .addComponent(surnameLabel15))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(permanentHouseBlockLotTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(permanentStreetTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permanentSubdivisionVillageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barangayLabel8)
                    .addComponent(barangayLabel9)
                    .addComponent(barangayLabel10)
                    .addComponent(barangayLabel11))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(permanentBarangayTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permanentCityMunicipalityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permanentProvinceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(permanentZipCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(surnameLabel16)
                    .addComponent(surnameLabel17)
                    .addComponent(surnameLabel18))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(telephoneNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mobileNoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void surnameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_surnameTextFieldFocusGained
        // TODO add your handling code here:

    }//GEN-LAST:event_surnameTextFieldFocusGained

    private void surnameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_surnameTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTextFieldFocusLost

    private void surnameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameTextFieldActionPerformed

    private void firstNameTextField1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameTextField1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextField1FocusGained

    private void firstNameTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_firstNameTextField1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextField1FocusLost

    private void firstNameTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextField1ActionPerformed

    private void middleNameTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middleNameTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_middleNameTextFieldFocusGained

    private void middleNameTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_middleNameTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_middleNameTextFieldFocusLost

    private void middleNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middleNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middleNameTextFieldActionPerformed

    private void nameExtensionTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameExtensionTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_nameExtensionTextFieldFocusGained

    private void nameExtensionTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nameExtensionTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_nameExtensionTextFieldFocusLost

    private void nameExtensionTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameExtensionTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameExtensionTextFieldActionPerformed

    private void placeOfBirthTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_placeOfBirthTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_placeOfBirthTextFieldFocusGained

    private void placeOfBirthTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_placeOfBirthTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_placeOfBirthTextFieldFocusLost

    private void placeOfBirthTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_placeOfBirthTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_placeOfBirthTextFieldActionPerformed

    private void heightTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_heightTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_heightTextFieldFocusGained

    private void heightTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_heightTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_heightTextFieldFocusLost

    private void heightTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heightTextFieldActionPerformed

    private void weightTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_weightTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_weightTextFieldFocusGained

    private void weightTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_weightTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_weightTextFieldFocusLost

    private void weightTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_weightTextFieldActionPerformed

    private void bloodTypeTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bloodTypeTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodTypeTextFieldFocusGained

    private void bloodTypeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_bloodTypeTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodTypeTextFieldFocusLost

    private void bloodTypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bloodTypeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bloodTypeTextFieldActionPerformed

    private void femaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleButtonActionPerformed

    private void maleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleButtonActionPerformed

    private void singleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singleButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_singleButtonActionPerformed

    private void marriedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_marriedButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_marriedButtonActionPerformed

    private void widowedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_widowedButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_widowedButtonActionPerformed

    private void separateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_separateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_separateButtonActionPerformed

    private void otherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_otherButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_otherButtonActionPerformed

    private void gsisIdNoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gsisIdNoTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_gsisIdNoTextFieldFocusGained

    private void gsisIdNoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gsisIdNoTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_gsisIdNoTextFieldFocusLost

    private void gsisIdNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gsisIdNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gsisIdNoTextFieldActionPerformed

    private void pagIbigIdNoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pagIbigIdNoTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_pagIbigIdNoTextFieldFocusGained

    private void pagIbigIdNoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pagIbigIdNoTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_pagIbigIdNoTextFieldFocusLost

    private void pagIbigIdNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagIbigIdNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagIbigIdNoTextFieldActionPerformed

    private void philHealthNoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_philHealthNoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_philHealthNoFocusGained

    private void philHealthNoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_philHealthNoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_philHealthNoFocusLost

    private void philHealthNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_philHealthNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_philHealthNoActionPerformed

    private void sssNoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sssNoTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_sssNoTextFieldFocusGained

    private void sssNoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_sssNoTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_sssNoTextFieldFocusLost

    private void sssNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sssNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sssNoTextFieldActionPerformed

    private void tinNoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tinNoTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tinNoTextFieldFocusGained

    private void tinNoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tinNoTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tinNoTextFieldFocusLost

    private void tinNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tinNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tinNoTextFieldActionPerformed

    private void agencyEmployeeNoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_agencyEmployeeNoTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_agencyEmployeeNoTextFieldFocusGained

    private void agencyEmployeeNoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_agencyEmployeeNoTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_agencyEmployeeNoTextFieldFocusLost

    private void agencyEmployeeNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agencyEmployeeNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_agencyEmployeeNoTextFieldActionPerformed

    private void filipinoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filipinoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filipinoButtonActionPerformed

    private void dualCitizenshipButtonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_dualCitizenshipButtonItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            citizenshipByBirthRadioButton.setEnabled(true);
            citizenshipByNaturalizationRadioButton.setEnabled(true);
            countryTextField.setEnabled(true);
        } else {
            citizenshipByBirthRadioButton.setEnabled(false);
            citizenshipByNaturalizationRadioButton.setEnabled(false);
            countryTextField.setEnabled(false);
            citizenshipButtonGroup.clearSelection(); // Clear the selection
            countryTextField.setText("");
        }
    }//GEN-LAST:event_dualCitizenshipButtonItemStateChanged

    private void dualCitizenshipButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dualCitizenshipButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dualCitizenshipButtonActionPerformed

    private void citizenshipByBirthRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citizenshipByBirthRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_citizenshipByBirthRadioButtonActionPerformed

    private void citizenshipByNaturalizationRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citizenshipByNaturalizationRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_citizenshipByNaturalizationRadioButtonActionPerformed

    private void countryTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_countryTextFieldFocusGained

    private void countryTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_countryTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_countryTextFieldFocusLost

    private void countryTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryTextFieldActionPerformed

    private void residentialHouseBlockLotTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialHouseBlockLotTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialHouseBlockLotTextFieldFocusGained

    private void residentialHouseBlockLotTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialHouseBlockLotTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialHouseBlockLotTextFieldFocusLost

    private void residentialHouseBlockLotTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialHouseBlockLotTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialHouseBlockLotTextFieldActionPerformed

    private void residentialStreetTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialStreetTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialStreetTextFieldFocusGained

    private void residentialStreetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialStreetTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialStreetTextFieldFocusLost

    private void residentialStreetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialStreetTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialStreetTextFieldActionPerformed

    private void residentialSubdivisionVillageTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialSubdivisionVillageTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialSubdivisionVillageTextFieldFocusGained

    private void residentialSubdivisionVillageTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialSubdivisionVillageTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialSubdivisionVillageTextFieldFocusLost

    private void residentialSubdivisionVillageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialSubdivisionVillageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialSubdivisionVillageTextFieldActionPerformed

    private void residentialBarangayTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialBarangayTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialBarangayTextFieldFocusGained

    private void residentialBarangayTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialBarangayTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialBarangayTextFieldFocusLost

    private void residentialBarangayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialBarangayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialBarangayTextFieldActionPerformed

    private void residentialCityMunicipalityTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialCityMunicipalityTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialCityMunicipalityTextFieldFocusGained

    private void residentialCityMunicipalityTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialCityMunicipalityTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialCityMunicipalityTextFieldFocusLost

    private void residentialCityMunicipalityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialCityMunicipalityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialCityMunicipalityTextFieldActionPerformed

    private void residentialProvinceTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialProvinceTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialProvinceTextFieldFocusGained

    private void residentialProvinceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialProvinceTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialProvinceTextFieldFocusLost

    private void residentialProvinceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialProvinceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialProvinceTextFieldActionPerformed

    private void residentialZipCodeTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialZipCodeTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialZipCodeTextFieldFocusGained

    private void residentialZipCodeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_residentialZipCodeTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialZipCodeTextFieldFocusLost

    private void residentialZipCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_residentialZipCodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_residentialZipCodeTextFieldActionPerformed

    private void permanentZipCodeTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentZipCodeTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentZipCodeTextFieldFocusGained

    private void permanentZipCodeTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentZipCodeTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentZipCodeTextFieldFocusLost

    private void permanentZipCodeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanentZipCodeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentZipCodeTextFieldActionPerformed

    private void permanentHouseBlockLotTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentHouseBlockLotTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentHouseBlockLotTextFieldFocusGained

    private void permanentHouseBlockLotTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentHouseBlockLotTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentHouseBlockLotTextFieldFocusLost

    private void permanentHouseBlockLotTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanentHouseBlockLotTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentHouseBlockLotTextFieldActionPerformed

    private void permanentStreetTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentStreetTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentStreetTextFieldFocusGained

    private void permanentStreetTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentStreetTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentStreetTextFieldFocusLost

    private void permanentStreetTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanentStreetTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentStreetTextFieldActionPerformed

    private void permanentSubdivisionVillageTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentSubdivisionVillageTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentSubdivisionVillageTextFieldFocusGained

    private void permanentSubdivisionVillageTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentSubdivisionVillageTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentSubdivisionVillageTextFieldFocusLost

    private void permanentSubdivisionVillageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanentSubdivisionVillageTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentSubdivisionVillageTextFieldActionPerformed

    private void permanentBarangayTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentBarangayTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentBarangayTextFieldFocusGained

    private void permanentBarangayTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentBarangayTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentBarangayTextFieldFocusLost

    private void permanentBarangayTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanentBarangayTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentBarangayTextFieldActionPerformed

    private void permanentCityMunicipalityTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentCityMunicipalityTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentCityMunicipalityTextFieldFocusGained

    private void permanentCityMunicipalityTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentCityMunicipalityTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentCityMunicipalityTextFieldFocusLost

    private void permanentCityMunicipalityTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanentCityMunicipalityTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentCityMunicipalityTextFieldActionPerformed

    private void permanentProvinceTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentProvinceTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentProvinceTextFieldFocusGained

    private void permanentProvinceTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_permanentProvinceTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentProvinceTextFieldFocusLost

    private void permanentProvinceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanentProvinceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentProvinceTextFieldActionPerformed

    private void telephoneNoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telephoneNoTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneNoTextFieldFocusGained

    private void telephoneNoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_telephoneNoTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneNoTextFieldFocusLost

    private void telephoneNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telephoneNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telephoneNoTextFieldActionPerformed

    private void mobileNoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileNoTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileNoTextFieldFocusGained

    private void mobileNoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mobileNoTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileNoTextFieldFocusLost

    private void mobileNoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobileNoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobileNoTextFieldActionPerformed

    private void emailAddressTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailAddressTextFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAddressTextFieldFocusGained

    private void emailAddressTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailAddressTextFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAddressTextFieldFocusLost

    private void emailAddressTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailAddressTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailAddressTextFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agencyEmployeeNoTextField;
    private javax.swing.JLabel barangayLabel;
    private javax.swing.JLabel barangayLabel1;
    private javax.swing.JLabel barangayLabel10;
    private javax.swing.JLabel barangayLabel11;
    private javax.swing.JLabel barangayLabel2;
    private javax.swing.JLabel barangayLabel3;
    private javax.swing.JLabel barangayLabel8;
    private javax.swing.JLabel barangayLabel9;
    private javax.swing.JTextField bloodTypeTextField;
    private javax.swing.ButtonGroup citizenButtonGroup;
    private javax.swing.ButtonGroup citizenshipButtonGroup;
    private javax.swing.JRadioButton citizenshipByBirthRadioButton;
    private javax.swing.JRadioButton citizenshipByNaturalizationRadioButton;
    private javax.swing.ButtonGroup civilStatusButtonGroup;
    private javax.swing.JTextField countryTextField;
    private javax.swing.JFormattedTextField dateOfBirthTextField;
    private javax.swing.JLabel dobLabel;
    private javax.swing.JLabel dobLabel1;
    private javax.swing.JLabel dobLabel2;
    private javax.swing.JRadioButton dualCitizenshipButton;
    private javax.swing.JTextField emailAddressTextField;
    private javax.swing.JRadioButton femaleButton;
    private javax.swing.JRadioButton filipinoButton;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField1;
    private javax.swing.JTextField gsisIdNoTextField;
    private javax.swing.JTextField heightTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton maleButton;
    private javax.swing.JRadioButton marriedButton;
    private javax.swing.JLabel middleNameLabel;
    private javax.swing.JTextField middleNameTextField;
    private javax.swing.JTextField mobileNoTextField;
    private javax.swing.JLabel nameExtensionLabel;
    private javax.swing.JLabel nameExtensionLabel1;
    private javax.swing.JLabel nameExtensionLabel2;
    private javax.swing.JLabel nameExtensionLabel3;
    private javax.swing.JLabel nameExtensionLabel4;
    private javax.swing.JLabel nameExtensionLabel5;
    private javax.swing.JLabel nameExtensionLabel6;
    private javax.swing.JLabel nameExtensionLabel7;
    private javax.swing.JLabel nameExtensionLabel8;
    private javax.swing.JTextField nameExtensionTextField;
    private javax.swing.JRadioButton otherButton;
    private javax.swing.JTextField pagIbigIdNoTextField;
    private javax.swing.JTextField permanentBarangayTextField;
    private javax.swing.JTextField permanentCityMunicipalityTextField;
    private javax.swing.JTextField permanentHouseBlockLotTextField;
    private javax.swing.JTextField permanentProvinceTextField;
    private javax.swing.JTextField permanentStreetTextField;
    private javax.swing.JTextField permanentSubdivisionVillageTextField;
    private javax.swing.JTextField permanentZipCodeTextField;
    private javax.swing.JTextField philHealthNo;
    private javax.swing.JTextField placeOfBirthTextField;
    private javax.swing.JTextField residentialBarangayTextField;
    private javax.swing.JTextField residentialCityMunicipalityTextField;
    private javax.swing.JTextField residentialHouseBlockLotTextField;
    private javax.swing.JTextField residentialProvinceTextField;
    private javax.swing.JTextField residentialStreetTextField;
    private javax.swing.JTextField residentialSubdivisionVillageTextField;
    private javax.swing.JTextField residentialZipCodeTextField;
    private javax.swing.JRadioButton separateButton;
    private javax.swing.ButtonGroup sexButtonGroup;
    private javax.swing.JRadioButton singleButton;
    private javax.swing.JTextField sssNoTextField;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JLabel surnameLabel1;
    private javax.swing.JLabel surnameLabel12;
    private javax.swing.JLabel surnameLabel13;
    private javax.swing.JLabel surnameLabel14;
    private javax.swing.JLabel surnameLabel15;
    private javax.swing.JLabel surnameLabel16;
    private javax.swing.JLabel surnameLabel17;
    private javax.swing.JLabel surnameLabel18;
    private javax.swing.JLabel surnameLabel2;
    private javax.swing.JLabel surnameLabel3;
    private javax.swing.JLabel surnameLabel4;
    private javax.swing.JLabel surnameLabel5;
    private javax.swing.JLabel surnameLabel6;
    private javax.swing.JLabel surnameLabel7;
    private javax.swing.JTextField surnameTextField;
    private javax.swing.JTextField telephoneNoTextField;
    private javax.swing.JTextField tinNoTextField;
    private javax.swing.JTextField weightTextField;
    private javax.swing.JRadioButton widowedButton;
    // End of variables declaration//GEN-END:variables
}
