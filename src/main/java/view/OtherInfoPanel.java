package view;

import controller.PDSController;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import  java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Reference;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class OtherInfoPanel extends javax.swing.JPanel {

    /**
     * Creates new form OtherInfoPanel
     */
    private List<Reference> references = new ArrayList<>();
    private ReferencesTableModel referencesTableModel;
    private PDSController controller;

    public OtherInfoPanel() {
        initComponents();
        referencesTableModel = new ReferencesTableModel(references);
        referencesTable.setModel(referencesTableModel);
    }

    public void setController(PDSController controller) {
        this.controller = controller;
    }
    
    // submission
    private void handleSubmit() {
        if (controller != null) {
            controller.handleSubmit();
            System.out.println("Submitted!");
        }
        
        System.out.println("Failed!");
    }
    

    public List<String> getSpecialSkillsHobbies() {
        return Arrays.asList(skillsTextArea.getText().split("\\n"));
    }

    public List<String> getNonAcademicDistinctionsRecognition() {
        return Arrays.asList(distinctionsTextArea.getText().split("\\n"));
    }

    public List<String> getMembershipInAssociationsOrganizations() {
        return Arrays.asList(membershipsTextArea.getText().split("\\n"));
    }

    // References getters
    public int getReferencesCount() {
        return references.size();
    }

    public String getReferenceName(int rowIndex) {
        return references.get(rowIndex).getName();
    }

    public String getReferenceAddress(int rowIndex) {
        return references.get(rowIndex).getAddress();
    }

    public String getReferenceTelephoneNo(int rowIndex) {
        return references.get(rowIndex).getTelephoneNo();
    }

    // Other Questions getters
    public boolean getThirdDegreeRelationship() {
        return thirdDegreeCheckbox.isSelected();
    }

    public boolean getFourthDegreeRelationship() {
        return fourthDegreeCheckbox.isSelected();
    }

    public boolean getAdminOffense() {
        return adminOffenseCheckbox.isSelected();
    }

    public String getAdminOffenseDetails() {
        return adminOffenseDetailsTextField.getText();
    }

    public boolean getCriminallyCharged() {
        return criminallyChargedCheckbox.isSelected();
    }

    public LocalDate getCriminallyChargedDate() {
        if (!criminallyChargedDateTextField.getText().isEmpty()) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                return LocalDate.parse(criminallyChargedDateTextField.getText(), formatter);
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format for 'Date Filed'.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        }
        return null;
    }

    public String getCriminallyChargedStatus() {
        return criminallyChargedStatusTextField.getText();
    }

    public boolean getConvicted() {
        return convictedCheckbox.isSelected();
    }

    public String getConvictedDetails() {
        return convictedDetailsTextField.getText();
    }

    public boolean getSeparatedService() {
        return separatedServiceCheckbox.isSelected();
    }

    public String getSeparatedServiceDetails() {
        return separatedServiceDetailsTextField.getText();
    }

    public boolean getElectionCandidate() {
        return electionCandidateCheckbox.isSelected();
    }

    public String getElectionCandidateDetails() {
        return electionDetailsCandidateTextField.getText();
    }

    public boolean getResignedGovt() {
        return resignedGovtCheckbox.isSelected();
    }

    public String getResignedGovtDetails() {
        return resignedGovtDetailsTextField.getText();
    }

    public boolean getImmigrant() {
        return immigrantCheckbox.isSelected();
    }

    public String getImmigrantCountry() {
        return immigrantCountryTextField.getText();
    }

    public boolean getIndigenous() {
        return indigenousCheckbox.isSelected();
    }

    public String getIndigenousDetails() {
        return indigenousDetailsTextField.getText();
    }

    public boolean getPwd() {
        return pwdCheckbox.isSelected();
    }

    public String getPwdDetails() {
        return pwdDetailsTextField.getText();
    }

    public boolean getSoloParent() {
        return soloParentCheckbox.isSelected();
    }

    public String getSoloParentDetails() {
        return soloParentDetailsTextField.getText();
    }

    private void showAddReferenceDialog() {
        AddReferenceDialog dialog = new AddReferenceDialog(JOptionPane.getFrameForComponent(this), true);
        dialog.setVisible(true);
        Reference newReference = dialog.getReference();
        if (newReference != null) {
            referencesTableModel.addReference(newReference);
        }
    }

    private void editSelectedReference() {
        int selectedRow = referencesTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a reference to edit.", "No Reference Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Reference referenceToEdit = references.get(selectedRow);
        AddReferenceDialog dialog = new AddReferenceDialog(JOptionPane.getFrameForComponent(this), true, referenceToEdit);
        dialog.setVisible(true);

        Reference updatedReference = dialog.getReference();
        if (updatedReference != null) {
            references.set(selectedRow, updatedReference);
            referencesTableModel.fireTableRowsUpdated(selectedRow, selectedRow);
        }
    }

    private void deleteSelectedReference() {
        int selectedRow = referencesTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a reference to delete.", "No Reference Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected reference?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            referencesTableModel.removeReference(selectedRow);
        }
    }


    public void refreshData() {
        // Clear text areas for Other Information
        skillsTextArea.setText("");
        distinctionsTextArea.setText("");
        membershipsTextArea.setText("");

        // Clear the References table
        referencesTableModel.clearData();

        // Reset checkboxes and clear/disable detail fields for Other Questions
        thirdDegreeCheckbox.setSelected(false);
        fourthDegreeCheckbox.setSelected(false);
        adminOffenseCheckbox.setSelected(false);
        adminOffenseDetailsTextField.setText("");
        adminOffenseDetailsTextField.setEnabled(false);
        criminallyChargedCheckbox.setSelected(false);
        criminallyChargedDateTextField.setText("");
        criminallyChargedDateTextField.setEnabled(false);
        criminallyChargedStatusTextField.setText("");
        criminallyChargedStatusTextField.setEnabled(false);
        convictedCheckbox.setSelected(false);
        convictedDetailsTextField.setText("");
        convictedDetailsTextField.setEnabled(false);
        separatedServiceCheckbox.setSelected(false);
        separatedServiceDetailsTextField.setText("");
        separatedServiceDetailsTextField.setEnabled(false);
        electionCandidateCheckbox.setSelected(false);
        electionDetailsCandidateTextField.setText("");
        electionDetailsCandidateTextField.setEnabled(false);
        resignedGovtCheckbox.setSelected(false);
        resignedGovtDetailsTextField.setText("");
        immigrantCheckbox.setSelected(false);
        immigrantCountryTextField.setText("");
        immigrantCountryTextField.setEnabled(false);
        indigenousCheckbox.setSelected(false);
        indigenousDetailsTextField.setText("");
        indigenousDetailsTextField.setEnabled(false);
        pwdCheckbox.setSelected(false);
        pwdDetailsTextField.setText("");
        pwdDetailsTextField.setEnabled(false);
        soloParentCheckbox.setSelected(false);
        soloParentDetailsTextField.setText("");
        soloParentDetailsTextField.setEnabled(false);
    }

    class ReferencesTableModel extends AbstractTableModel {

        private String[] columnNames = {"Name", "Address", "Telephone No."};
        private List<Reference> references;

        public ReferencesTableModel(List<Reference> references) {
            this.references = references;
        }

        @Override
        public int getRowCount() {
            return references.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public String getColumnName(int column) {
            return columnNames[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Reference reference = references.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return reference.getName();
                case 1:
                    return reference.getAddress();
                case 2:
                    return reference.getTelephoneNo();
                default:
                    return null;
            }
        }

        public void addReference(Reference reference) {
            references.add(reference);
            fireTableRowsInserted(references.size() - 1, references.size() - 1);
        }

        public void removeReference(int rowIndex) {
            if (rowIndex >= 0 && rowIndex < references.size()) {
                references.remove(rowIndex);
                fireTableRowsDeleted(rowIndex, rowIndex);
            }
        }

        public void clearData() {
            int size = references.size();
            if (size > 0) {
                references.clear();
                fireTableRowsDeleted(0, size - 1);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        informationLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        skillsTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        distinctionsTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        membershipsTextArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        thirdDegreeCheckbox = new javax.swing.JCheckBox();
        fourthDegreeCheckbox = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        thirdDegreeDetailsTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        fourthDegreeDetailsTextField = new javax.swing.JTextField();
        adminOffenseCheckbox = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        adminOffenseDetailsTextField = new javax.swing.JTextField();
        criminallyChargedCheckbox = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        criminallyChargedStatusTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        criminallyChargedDateTextField = new javax.swing.JTextField();
        convictedCheckbox = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        convictedDetailsTextField = new javax.swing.JTextField();
        separatedServiceCheckbox = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        separatedServiceDetailsTextField = new javax.swing.JTextField();
        electionCandidateCheckbox = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        electionDetailsCandidateTextField = new javax.swing.JTextField();
        resignedGovtCheckbox = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        resignedGovtDetailsTextField = new javax.swing.JTextField();
        immigrantCheckbox = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        immigrantCountryTextField = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        indigenousCheckbox = new javax.swing.JCheckBox();
        pwdCheckbox = new javax.swing.JCheckBox();
        soloParentCheckbox = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        indigenousDetailsTextField = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        pwdDetailsTextField = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        soloParentDetailsTextField = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        referencesTable = new javax.swing.JTable();
        addReferenceBtn = new javax.swing.JButton();
        editReferenceBtn = new javax.swing.JButton();
        deleteReferenceBtn = new javax.swing.JButton();
        submitBtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(243, 244, 246));

        informationLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        informationLabel.setText("Other Information");

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel2.setText("Special Skills and Hobbies");

        skillsTextArea.setColumns(20);
        skillsTextArea.setRows(5);
        jScrollPane1.setViewportView(skillsTextArea);

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel3.setText("Misc.");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel4.setText("Non-Academic Distinctions / Recognitions");

        distinctionsTextArea.setColumns(20);
        distinctionsTextArea.setRows(5);
        jScrollPane2.setViewportView(distinctionsTextArea);

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel5.setText("Membership in Association/Organization");

        membershipsTextArea.setColumns(20);
        membershipsTextArea.setRows(5);
        jScrollPane3.setViewportView(membershipsTextArea);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel6.setText("Other Questions");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("<html> Are you related by consanguinity or affinity to the appointing or recommending authority, or to the chief of bureau or office or to the person who has immediate supervision over you in the Office, Bureau or Department where you will be appointed,<br></html>");

        thirdDegreeCheckbox.setText("within the third degree?");
        thirdDegreeCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                thirdDegreeCheckboxItemStateChanged(evt);
            }
        });
        thirdDegreeCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thirdDegreeCheckboxActionPerformed(evt);
            }
        });

        fourthDegreeCheckbox.setText("within the fourth degree (for Local Government Unit - Career Employees)?");
        fourthDegreeCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fourthDegreeCheckboxItemStateChanged(evt);
            }
        });
        fourthDegreeCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourthDegreeCheckboxActionPerformed(evt);
            }
        });

        jLabel7.setText("Give Details");

        jLabel8.setText("Give Details");

        fourthDegreeDetailsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourthDegreeDetailsTextFieldActionPerformed(evt);
            }
        });

        adminOffenseCheckbox.setText("Have you ever been found guilty of any administrative offense?");
        adminOffenseCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                adminOffenseCheckboxItemStateChanged(evt);
            }
        });
        adminOffenseCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminOffenseCheckboxActionPerformed(evt);
            }
        });

        jLabel9.setText("Give Details");

        criminallyChargedCheckbox.setText("Have you been criminally charged before any court?");
        criminallyChargedCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                criminallyChargedCheckboxItemStateChanged(evt);
            }
        });
        criminallyChargedCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criminallyChargedCheckboxActionPerformed(evt);
            }
        });

        jLabel10.setText("Date Filed:");

        jLabel11.setText("Status of Case/s:");

        convictedCheckbox.setText("<html>Have you ever been convicted of any crime or violation of <br>any law, decree, ordinance or regulation by any court or tribunal?</html>");
        convictedCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                convictedCheckboxItemStateChanged(evt);
            }
        });
        convictedCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convictedCheckboxActionPerformed(evt);
            }
        });

        jLabel12.setText("Give Details");

        separatedServiceCheckbox.setText("<html>\n\tHave you ever been separated from the service in any of the following modes: <br>resignation, retirement, dropped from the rolls, dismissal, termination, end of term, <br>finished contract or phased out (abolition) in the public or private sector?\n</html>");
        separatedServiceCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                separatedServiceCheckboxItemStateChanged(evt);
            }
        });
        separatedServiceCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                separatedServiceCheckboxActionPerformed(evt);
            }
        });

        jLabel13.setText("Give Details");

        electionCandidateCheckbox.setText("<html>\n\tHave you ever been a candidate in a national <br>or local election held within the last year <br>(except Barangay election)?\n</html>");
        electionCandidateCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                electionCandidateCheckboxItemStateChanged(evt);
            }
        });
        electionCandidateCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                electionCandidateCheckboxActionPerformed(evt);
            }
        });

        jLabel14.setText("Give Details");

        resignedGovtCheckbox.setText("<html>\n     Have you resigned from the government service during the three (3)-month period <br>before the last election to promote/actively <br>campaign for a national or local candidate?\n</html>");
        resignedGovtCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                resignedGovtCheckboxItemStateChanged(evt);
            }
        });
        resignedGovtCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resignedGovtCheckboxActionPerformed(evt);
            }
        });

        jLabel15.setText("Give Details");

        resignedGovtDetailsTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resignedGovtDetailsTextFieldActionPerformed(evt);
            }
        });

        immigrantCheckbox.setText("<html>\n\tHave you acquired the status of an immigrant <br>or permanent resident of another country?\n</html>");
        immigrantCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                immigrantCheckboxItemStateChanged(evt);
            }
        });
        immigrantCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                immigrantCheckboxActionPerformed(evt);
            }
        });

        jLabel16.setText("Country");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("<html>\nPursuant to: (a) Indigenous People's Act (RA 8371); <br>(b) Magna Carta for Disabled Persons (RA 7277); and <br>(c) Solo Parents Welfare Act of 2000 (RA 8972), please answer the following items:\n</html>");

        indigenousCheckbox.setText("Are you a member of any indigenous group?");
        indigenousCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                indigenousCheckboxItemStateChanged(evt);
            }
        });
        indigenousCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indigenousCheckboxActionPerformed(evt);
            }
        });

        pwdCheckbox.setText("Are you a person with disability?");
        pwdCheckbox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pwdCheckboxItemStateChanged(evt);
            }
        });

        soloParentCheckbox.setText("Are you a solo parent?");

        jLabel18.setText("Specify");

        jLabel19.setText("ID No.");

        jLabel20.setText("ID No.");

        jLabel21.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel21.setText("References");

        referencesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        referencesTable.setRowHeight(30);
        referencesTable.setShowGrid(false);
        jScrollPane4.setViewportView(referencesTable);

        addReferenceBtn.setBackground(new java.awt.Color(16, 185, 129));
        addReferenceBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        addReferenceBtn.setForeground(new java.awt.Color(255, 255, 255));
        addReferenceBtn.setText("Add Reference");
        addReferenceBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addReferenceBtn.setFocusPainted(false);
        addReferenceBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        addReferenceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addReferenceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addReferenceBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addReferenceBtnMousePressed(evt);
            }
        });
        addReferenceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addReferenceBtnActionPerformed(evt);
            }
        });

        editReferenceBtn.setBackground(new java.awt.Color(59, 130, 246));
        editReferenceBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        editReferenceBtn.setForeground(new java.awt.Color(255, 255, 255));
        editReferenceBtn.setText("Edit Reference");
        editReferenceBtn.setToolTipText("");
        editReferenceBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editReferenceBtn.setFocusPainted(false);
        editReferenceBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        editReferenceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editReferenceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editReferenceBtnMouseExited(evt);
            }
        });
        editReferenceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editReferenceBtnActionPerformed(evt);
            }
        });

        deleteReferenceBtn.setBackground(new java.awt.Color(239, 68, 68));
        deleteReferenceBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        deleteReferenceBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteReferenceBtn.setText("Delete Reference");
        deleteReferenceBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteReferenceBtn.setFocusPainted(false);
        deleteReferenceBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        deleteReferenceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteReferenceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteReferenceBtnMouseExited(evt);
            }
        });
        deleteReferenceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReferenceBtnActionPerformed(evt);
            }
        });

        submitBtn.setBackground(new java.awt.Color(59, 130, 246));
        submitBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Submit");
        submitBtn.setToolTipText("");
        submitBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        submitBtn.setFocusPainted(false);
        submitBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitBtnMouseExited(evt);
            }
        });
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1224, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(thirdDegreeDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fourthDegreeCheckbox)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(fourthDegreeDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel8))))
                                .addGap(355, 355, 355)))
                        .addGap(173, 173, 173))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(thirdDegreeCheckbox)
                            .addComponent(jLabel6)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(informationLabel)
                            .addComponent(jLabel21)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminOffenseCheckbox)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(adminOffenseDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel9))))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel10)
                                                .addComponent(jLabel11))
                                            .addGap(18, 18, 18)
                                            .addComponent(criminallyChargedStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(criminallyChargedDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(criminallyChargedCheckbox))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(separatedServiceCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(immigrantCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel16)
                                                    .addGap(312, 312, 312))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(6, 6, 6)
                                                        .addComponent(separatedServiceDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jLabel13))))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(electionDetailsCandidateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(11, 11, 11)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel12)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addComponent(convictedDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addComponent(convictedCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(electionCandidateCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(resignedGovtCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(37, 37, 37)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(resignedGovtDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel15)))))))))
                            .addComponent(immigrantCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(indigenousCheckbox)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(indigenousDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel18))))
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pwdCheckbox)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(pwdDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel19))))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(soloParentDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel20)))
                            .addComponent(soloParentCheckbox)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(editReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(deleteReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(informationLabel)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(thirdDegreeCheckbox)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thirdDegreeDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fourthDegreeCheckbox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fourthDegreeDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminOffenseCheckbox)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adminOffenseDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(criminallyChargedCheckbox)
                                .addComponent(convictedCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(criminallyChargedDateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(convictedDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(6, 6, 6))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(criminallyChargedStatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resignedGovtCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(electionCandidateCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(separatedServiceCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(separatedServiceDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(electionDetailsCandidateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resignedGovtDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(immigrantCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(immigrantCountryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(indigenousCheckbox)
                            .addComponent(pwdCheckbox)
                            .addComponent(soloParentCheckbox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(indigenousDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pwdDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soloParentDetailsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addReferenceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void thirdDegreeCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thirdDegreeCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thirdDegreeCheckboxActionPerformed

    private void fourthDegreeCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourthDegreeCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fourthDegreeCheckboxActionPerformed

    private void fourthDegreeDetailsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourthDegreeDetailsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fourthDegreeDetailsTextFieldActionPerformed

    private void thirdDegreeCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_thirdDegreeCheckboxItemStateChanged
        // TODO add your handling code here:
        thirdDegreeDetailsTextField.setEnabled(thirdDegreeCheckbox.isSelected());
    }//GEN-LAST:event_thirdDegreeCheckboxItemStateChanged

    private void fourthDegreeCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fourthDegreeCheckboxItemStateChanged
        // TODO add your handling code here:
        fourthDegreeDetailsTextField.setEnabled(fourthDegreeCheckbox.isSelected());
    }//GEN-LAST:event_fourthDegreeCheckboxItemStateChanged

    private void adminOffenseCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminOffenseCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminOffenseCheckboxActionPerformed

    private void criminallyChargedCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criminallyChargedCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_criminallyChargedCheckboxActionPerformed

    private void adminOffenseCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_adminOffenseCheckboxItemStateChanged
        // TODO add your handling code here:
        adminOffenseDetailsTextField.setEnabled(adminOffenseCheckbox.isSelected());
    }//GEN-LAST:event_adminOffenseCheckboxItemStateChanged

    private void criminallyChargedCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_criminallyChargedCheckboxItemStateChanged
        // TODO add your handling code here:
        boolean isSelected = criminallyChargedCheckbox.isSelected();
        criminallyChargedDateTextField.setEnabled(isSelected);
        criminallyChargedStatusTextField.setEnabled(isSelected);
    }//GEN-LAST:event_criminallyChargedCheckboxItemStateChanged

    private void convictedCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convictedCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_convictedCheckboxActionPerformed

    private void convictedCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_convictedCheckboxItemStateChanged
        // TODO add your handling code here:
        convictedDetailsTextField.setEnabled(convictedCheckbox.isSelected());
    }//GEN-LAST:event_convictedCheckboxItemStateChanged

    private void separatedServiceCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_separatedServiceCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_separatedServiceCheckboxActionPerformed

    private void electionCandidateCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_electionCandidateCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_electionCandidateCheckboxActionPerformed

    private void separatedServiceCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_separatedServiceCheckboxItemStateChanged
        // TODO add your handling code here:
        separatedServiceDetailsTextField.setEnabled(separatedServiceCheckbox.isSelected());
    }//GEN-LAST:event_separatedServiceCheckboxItemStateChanged

    private void electionCandidateCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_electionCandidateCheckboxItemStateChanged
        // TODO add your handling code here:
        electionDetailsCandidateTextField.setEnabled(electionCandidateCheckbox.isSelected());
    }//GEN-LAST:event_electionCandidateCheckboxItemStateChanged

    private void resignedGovtCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resignedGovtCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resignedGovtCheckboxActionPerformed

    private void resignedGovtCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_resignedGovtCheckboxItemStateChanged
        // TODO add your handling code here:
        resignedGovtDetailsTextField.setEnabled(resignedGovtCheckbox.isSelected());
    }//GEN-LAST:event_resignedGovtCheckboxItemStateChanged

    private void immigrantCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_immigrantCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_immigrantCheckboxActionPerformed

    private void immigrantCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_immigrantCheckboxItemStateChanged
        // TODO add your handling code here:
        immigrantCountryTextField.setEnabled(immigrantCheckbox.isSelected());
    }//GEN-LAST:event_immigrantCheckboxItemStateChanged

    private void indigenousCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indigenousCheckboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_indigenousCheckboxActionPerformed

    private void resignedGovtDetailsTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resignedGovtDetailsTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resignedGovtDetailsTextFieldActionPerformed

    private void indigenousCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_indigenousCheckboxItemStateChanged
        // TODO add your handling code here:
        indigenousDetailsTextField.setEnabled(indigenousCheckbox.isSelected());
    }//GEN-LAST:event_indigenousCheckboxItemStateChanged

    private void pwdCheckboxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pwdCheckboxItemStateChanged
        // TODO add your handling code here:
        pwdDetailsTextField.setEnabled(pwdCheckbox.isSelected());
    }//GEN-LAST:event_pwdCheckboxItemStateChanged

    private void addReferenceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addReferenceBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(5, 150, 105));
    }//GEN-LAST:event_addReferenceBtnMouseEntered

    private void addReferenceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addReferenceBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(16, 185, 129));
    }//GEN-LAST:event_addReferenceBtnMouseExited

    private void addReferenceBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addReferenceBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addReferenceBtnMousePressed

    private void addReferenceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addReferenceBtnActionPerformed
        // TODO add your handling code here:
        showAddReferenceDialog();
    }//GEN-LAST:event_addReferenceBtnActionPerformed

    private void editReferenceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editReferenceBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(37, 99, 235));
    }//GEN-LAST:event_editReferenceBtnMouseEntered

    private void editReferenceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editReferenceBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(59, 130, 246));
    }//GEN-LAST:event_editReferenceBtnMouseExited

    private void editReferenceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editReferenceBtnActionPerformed
        // TODO add your handling code here:
        editSelectedReference();
    }//GEN-LAST:event_editReferenceBtnActionPerformed

    private void deleteReferenceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteReferenceBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(220, 38, 35));
    }//GEN-LAST:event_deleteReferenceBtnMouseEntered

    private void deleteReferenceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteReferenceBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(239, 68, 68));
    }//GEN-LAST:event_deleteReferenceBtnMouseExited

    private void deleteReferenceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteReferenceBtnActionPerformed
        // TODO add your handling code here:
        deleteSelectedReference();
    }//GEN-LAST:event_deleteReferenceBtnActionPerformed

    private void submitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_submitBtnMouseEntered

    private void submitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_submitBtnMouseExited

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        // TODO add your handling code here:
        handleSubmit();
    }//GEN-LAST:event_submitBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addReferenceBtn;
    private javax.swing.JCheckBox adminOffenseCheckbox;
    private javax.swing.JTextField adminOffenseDetailsTextField;
    private javax.swing.JCheckBox convictedCheckbox;
    private javax.swing.JTextField convictedDetailsTextField;
    private javax.swing.JCheckBox criminallyChargedCheckbox;
    private javax.swing.JTextField criminallyChargedDateTextField;
    private javax.swing.JTextField criminallyChargedStatusTextField;
    private javax.swing.JButton deleteReferenceBtn;
    private javax.swing.JTextArea distinctionsTextArea;
    private javax.swing.JButton editReferenceBtn;
    private javax.swing.JCheckBox electionCandidateCheckbox;
    private javax.swing.JTextField electionDetailsCandidateTextField;
    private javax.swing.JCheckBox fourthDegreeCheckbox;
    private javax.swing.JTextField fourthDegreeDetailsTextField;
    private javax.swing.JCheckBox immigrantCheckbox;
    private javax.swing.JTextField immigrantCountryTextField;
    private javax.swing.JCheckBox indigenousCheckbox;
    private javax.swing.JTextField indigenousDetailsTextField;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea membershipsTextArea;
    private javax.swing.JCheckBox pwdCheckbox;
    private javax.swing.JTextField pwdDetailsTextField;
    private javax.swing.JTable referencesTable;
    private javax.swing.JCheckBox resignedGovtCheckbox;
    private javax.swing.JTextField resignedGovtDetailsTextField;
    private javax.swing.JCheckBox separatedServiceCheckbox;
    private javax.swing.JTextField separatedServiceDetailsTextField;
    private javax.swing.JTextArea skillsTextArea;
    private javax.swing.JCheckBox soloParentCheckbox;
    private javax.swing.JTextField soloParentDetailsTextField;
    private javax.swing.JButton submitBtn;
    private javax.swing.JCheckBox thirdDegreeCheckbox;
    private javax.swing.JTextField thirdDegreeDetailsTextField;
    // End of variables declaration//GEN-END:variables
}
