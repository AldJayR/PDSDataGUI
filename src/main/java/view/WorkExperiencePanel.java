/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.WorkExperience;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WorkExperiencePanel extends javax.swing.JPanel {

    /**
     * Creates new form WorkExperiencePanel
     */
    private List<WorkExperience> workExperienceList = new ArrayList<>();
    private WorkExperienceTableModel tableModel;

    public WorkExperiencePanel() {
        initComponents();
        tableModel = new WorkExperienceTableModel(workExperienceList);
        workExperienceTable.setModel(tableModel);
    }

    public int getWorkExperienceCount() {
        return workExperienceList.size();
    }

    public LocalDate getDateFrom(int rowIndex) {
        return workExperienceList.get(rowIndex).getDateFrom();
    }

    public LocalDate getDateTo(int rowIndex) {
        return workExperienceList.get(rowIndex).getDateTo();
    }

    public String getPositionTitle(int rowIndex) {
        return workExperienceList.get(rowIndex).getPositionTitle();
    }

    public String getDepartmentAgencyOfficeCompany(int rowIndex) {
        return workExperienceList.get(rowIndex).getDepartmentAgencyOfficeCompany();
    }

    public String getMonthlySalary(int rowIndex) {
        return workExperienceList.get(rowIndex).getMonthlySalary();
    }

    public String getSalaryGradeStepIncrement(int rowIndex) {
        return workExperienceList.get(rowIndex).getSalaryGradeStepIncrement();
    }

    public String getStatusOfAppointment(int rowIndex) {
        return workExperienceList.get(rowIndex).getStatusOfAppointment();
    }

    public boolean isGovernmentService(int rowIndex) {
        return workExperienceList.get(rowIndex).isGovernmentService();
    }

    private void showAddWorkExperienceDialog() {
        AddWorkExperienceDialog dialog = new AddWorkExperienceDialog(JOptionPane.getFrameForComponent(this), true);
        dialog.setVisible(true);
        WorkExperience newWorkExperience = dialog.getWorkExperience();
        if (newWorkExperience != null) {
            tableModel.addWorkExperience(newWorkExperience);
        }
    }

    private void editSelectedWorkExperience() {
        int selectedRow = workExperienceTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a work experience entry to edit.", "No Entry Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        WorkExperience workExperienceToEdit = workExperienceList.get(selectedRow);
        AddWorkExperienceDialog dialog = new AddWorkExperienceDialog(JOptionPane.getFrameForComponent(this), true, workExperienceToEdit);
        dialog.setVisible(true);

        WorkExperience updatedWorkExperience = dialog.getWorkExperience();
        if (updatedWorkExperience != null) {
            workExperienceList.set(selectedRow, updatedWorkExperience);
            tableModel.fireTableRowsUpdated(selectedRow, selectedRow);
        }
    }

    private void deleteSelectedWorkExperience() {
        int selectedRow = workExperienceTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a work experience entry to delete.", "No Entry Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected work experience entry?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.removeWorkExperience(selectedRow);
        }
    }

    public void refreshData() {
        tableModel.clearData();
    }

    // Inner class for the Work Experience table model
    class WorkExperienceTableModel extends AbstractTableModel {

        private String[] columnNames = {"Date From", "Date To", "Position Title", "Department/Agency/Office/Company", "Monthly Salary", "Salary Grade & Step", "Status of Appointment", "Gov't Service"};
        private List<WorkExperience> workExperienceList;

        public WorkExperienceTableModel(List<WorkExperience> workExperienceList) {
            this.workExperienceList = workExperienceList;
        }

        @Override
        public int getRowCount() {
            return workExperienceList.size();
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
            WorkExperience workExperience = workExperienceList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return workExperience.getDateFrom() != null ? workExperience.getDateFrom().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) : "";
                case 1:
                    return workExperience.getDateTo() != null ? workExperience.getDateTo().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) : "";
                case 2:
                    return workExperience.getPositionTitle();
                case 3:
                    return workExperience.getDepartmentAgencyOfficeCompany();
                case 4:
                    return workExperience.getMonthlySalary();
                case 5:
                    return workExperience.getSalaryGradeStepIncrement();
                case 6:
                    return workExperience.getStatusOfAppointment();
                case 7:
                    return workExperience.isGovernmentService() ? "Yes" : "No";
                default:
                    return null;
            }
        }

        public void addWorkExperience(WorkExperience workExperience) {
            workExperienceList.add(workExperience);
            fireTableRowsInserted(workExperienceList.size() - 1, workExperienceList.size() - 1);
        }

        public void removeWorkExperience(int rowIndex) {
            if (rowIndex >= 0 && rowIndex < workExperienceList.size()) {
                workExperienceList.remove(rowIndex);
                fireTableRowsDeleted(rowIndex, rowIndex);
            }
        }

        public void clearData() {
            int size = workExperienceList.size();
            if (size > 0) {
                workExperienceList.clear();
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

        jPanel1 = new javax.swing.JPanel();
        informationLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        workExperienceTable = new javax.swing.JTable();
        editWorkExperienceBtn = new javax.swing.JButton();
        deleteWorkExperienceBtn = new javax.swing.JButton();
        addWorkExperienceBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(243, 244, 246));

        informationLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        informationLabel.setText("Work Experience");

        workExperienceTable.setModel(new javax.swing.table.DefaultTableModel(
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
        workExperienceTable.setRowHeight(30);
        workExperienceTable.setShowGrid(false);
        jScrollPane1.setViewportView(workExperienceTable);

        editWorkExperienceBtn.setBackground(new java.awt.Color(59, 130, 246));
        editWorkExperienceBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        editWorkExperienceBtn.setForeground(new java.awt.Color(255, 255, 255));
        editWorkExperienceBtn.setText("Edit Work");
        editWorkExperienceBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editWorkExperienceBtn.setFocusPainted(false);
        editWorkExperienceBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        editWorkExperienceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editWorkExperienceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editWorkExperienceBtnMouseExited(evt);
            }
        });
        editWorkExperienceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editWorkExperienceBtnActionPerformed(evt);
            }
        });

        deleteWorkExperienceBtn.setBackground(new java.awt.Color(239, 68, 68));
        deleteWorkExperienceBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        deleteWorkExperienceBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteWorkExperienceBtn.setText("Delete Work");
        deleteWorkExperienceBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteWorkExperienceBtn.setFocusPainted(false);
        deleteWorkExperienceBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        deleteWorkExperienceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteWorkExperienceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteWorkExperienceBtnMouseExited(evt);
            }
        });
        deleteWorkExperienceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteWorkExperienceBtnActionPerformed(evt);
            }
        });

        addWorkExperienceBtn.setBackground(new java.awt.Color(16, 185, 129));
        addWorkExperienceBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        addWorkExperienceBtn.setForeground(new java.awt.Color(255, 255, 255));
        addWorkExperienceBtn.setText("Add Work");
        addWorkExperienceBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addWorkExperienceBtn.setFocusPainted(false);
        addWorkExperienceBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        addWorkExperienceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addWorkExperienceBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addWorkExperienceBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addWorkExperienceBtnMousePressed(evt);
            }
        });
        addWorkExperienceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addWorkExperienceBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(informationLabel)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(addWorkExperienceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(editWorkExperienceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(deleteWorkExperienceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(informationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editWorkExperienceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteWorkExperienceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addWorkExperienceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(621, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1246, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void editWorkExperienceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editWorkExperienceBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(37, 99, 235));
    }//GEN-LAST:event_editWorkExperienceBtnMouseEntered

    private void editWorkExperienceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editWorkExperienceBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(59, 130, 246));
    }//GEN-LAST:event_editWorkExperienceBtnMouseExited

    private void editWorkExperienceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editWorkExperienceBtnActionPerformed
        // TODO add your handling code here:
        editSelectedWorkExperience();
    }//GEN-LAST:event_editWorkExperienceBtnActionPerformed

    private void deleteWorkExperienceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteWorkExperienceBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(220, 38, 35));
    }//GEN-LAST:event_deleteWorkExperienceBtnMouseEntered

    private void deleteWorkExperienceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteWorkExperienceBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(239, 68, 68));
    }//GEN-LAST:event_deleteWorkExperienceBtnMouseExited

    private void deleteWorkExperienceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteWorkExperienceBtnActionPerformed
        // TODO add your handling code here:
        deleteSelectedWorkExperience();
    }//GEN-LAST:event_deleteWorkExperienceBtnActionPerformed

    private void addWorkExperienceBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addWorkExperienceBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(5, 150, 105));
    }//GEN-LAST:event_addWorkExperienceBtnMouseEntered

    private void addWorkExperienceBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addWorkExperienceBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(16, 185, 129));
    }//GEN-LAST:event_addWorkExperienceBtnMouseExited

    private void addWorkExperienceBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addWorkExperienceBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addWorkExperienceBtnMousePressed

    private void addWorkExperienceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addWorkExperienceBtnActionPerformed
        // TODO add your handling code here:
        showAddWorkExperienceDialog();
    }//GEN-LAST:event_addWorkExperienceBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addWorkExperienceBtn;
    private javax.swing.JButton deleteWorkExperienceBtn;
    private javax.swing.JButton editWorkExperienceBtn;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable workExperienceTable;
    // End of variables declaration//GEN-END:variables
}
