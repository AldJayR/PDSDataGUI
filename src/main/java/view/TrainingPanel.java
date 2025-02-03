/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.Training;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TrainingPanel extends javax.swing.JPanel {

    /**
     * Creates new form TrainingPanel
     */
    private List<Training> trainingList = new ArrayList<>();
    private TrainingTableModel tableModel;

    public TrainingPanel() {
        initComponents();
        tableModel = new TrainingTableModel(trainingList);
        trainingTable.setModel(tableModel);
    }

    public int getTrainingCount() {
        return trainingList.size();
    }

    public String getTitle(int rowIndex) {
        return trainingList.get(rowIndex).getTitle();
    }

    public LocalDate getDateFrom(int rowIndex) {
        return trainingList.get(rowIndex).getDateFrom();
    }

    public LocalDate getDateTo(int rowIndex) {
        return trainingList.get(rowIndex).getDateTo();
    }

    public int getNumberOfHours(int rowIndex) {
        return trainingList.get(rowIndex).getNumberOfHours();
    }

    public String getTypeOfLd(int rowIndex) {
        return trainingList.get(rowIndex).getTypeOfLd();
    }

    public String getConductedBy(int rowIndex) {
        return trainingList.get(rowIndex).getConductedBy();
    }

    private void showAddTrainingDialog() {
        AddTrainingDialog dialog = new AddTrainingDialog(JOptionPane.getFrameForComponent(this), true);
        dialog.setVisible(true);
        Training newTraining = dialog.getTraining();
        if (newTraining != null) {
            tableModel.addTraining(newTraining);
        }
    }

    private void editSelectedTraining() {
        int selectedRow = trainingTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a training entry to edit.", "No Entry Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Training trainingToEdit = trainingList.get(selectedRow);
        AddTrainingDialog dialog = new AddTrainingDialog(JOptionPane.getFrameForComponent(this), true, trainingToEdit);
        dialog.setVisible(true);

        Training updatedTraining = dialog.getTraining();
        if (updatedTraining != null) {
            trainingList.set(selectedRow, updatedTraining);
            tableModel.fireTableRowsUpdated(selectedRow, selectedRow);
        }
    }

    private void deleteSelectedTraining() {
        int selectedRow = trainingTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a training entry to delete.", "No Entry Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected training entry?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.removeTraining(selectedRow);
        }
    }

    public void refreshData() {
        tableModel.clearData();
    }

    // Inner class for the Training table model
    class TrainingTableModel extends AbstractTableModel {

        private String[] columnNames = {"Title of Learning and Development", "Date From", "Date To", "Number of Hours", "Type of LD", "Conducted/Sponsored By"};
        private List<Training> trainingList;

        public TrainingTableModel(List<Training> trainingList) {
            this.trainingList = trainingList;
        }

        @Override
        public int getRowCount() {
            return trainingList.size();
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
            Training training = trainingList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return training.getTitle();
                case 1:
                    return training.getDateFrom() != null ? training.getDateFrom().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) : "";
                case 2:
                    return training.getDateTo() != null ? training.getDateTo().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) : "";
                case 3:
                    return training.getNumberOfHours();
                case 4:
                    return training.getTypeOfLd();
                case 5:
                    return training.getConductedBy();
                default:
                    return null;
            }
        }

        public void addTraining(Training training) {
            trainingList.add(training);
            fireTableRowsInserted(trainingList.size() - 1, trainingList.size() - 1);
        }

        public void removeTraining(int rowIndex) {
            if (rowIndex >= 0 && rowIndex < trainingList.size()) {
                trainingList.remove(rowIndex);
                fireTableRowsDeleted(rowIndex, rowIndex);
            }
        }

        public void clearData() {
            int size = trainingList.size();
            if (size > 0) {
                trainingList.clear();
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
        trainingTable = new javax.swing.JTable();
        editEntryBtn = new javax.swing.JButton();
        deleteEntryBtn = new javax.swing.JButton();
        addEntryBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(243, 244, 246));

        informationLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        informationLabel.setText("Learning And Development Interventions/Training Programs Attended");

        trainingTable.setModel(new javax.swing.table.DefaultTableModel(
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
        trainingTable.setRowHeight(30);
        trainingTable.setShowGrid(false);
        jScrollPane1.setViewportView(trainingTable);

        editEntryBtn.setBackground(new java.awt.Color(59, 130, 246));
        editEntryBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        editEntryBtn.setForeground(new java.awt.Color(255, 255, 255));
        editEntryBtn.setText("Edit Entry");
        editEntryBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editEntryBtn.setFocusPainted(false);
        editEntryBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        editEntryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editEntryBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editEntryBtnMouseExited(evt);
            }
        });
        editEntryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEntryBtnActionPerformed(evt);
            }
        });

        deleteEntryBtn.setBackground(new java.awt.Color(239, 68, 68));
        deleteEntryBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        deleteEntryBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteEntryBtn.setText("Delete Entry");
        deleteEntryBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteEntryBtn.setFocusPainted(false);
        deleteEntryBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        deleteEntryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteEntryBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteEntryBtnMouseExited(evt);
            }
        });
        deleteEntryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEntryBtnActionPerformed(evt);
            }
        });

        addEntryBtn.setBackground(new java.awt.Color(16, 185, 129));
        addEntryBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        addEntryBtn.setForeground(new java.awt.Color(255, 255, 255));
        addEntryBtn.setText("Add Entry");
        addEntryBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addEntryBtn.setFocusPainted(false);
        addEntryBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        addEntryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addEntryBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addEntryBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addEntryBtnMousePressed(evt);
            }
        });
        addEntryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntryBtnActionPerformed(evt);
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
                        .addGap(157, 157, 157)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(213, 213, 213)
                        .addComponent(addEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(editEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(deleteEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addEntryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(622, Short.MAX_VALUE))
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

    private void editEntryBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editEntryBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(37, 99, 235));
    }//GEN-LAST:event_editEntryBtnMouseEntered

    private void editEntryBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editEntryBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(59, 130, 246));
    }//GEN-LAST:event_editEntryBtnMouseExited

    private void editEntryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEntryBtnActionPerformed
        // TODO add your handling code here:
        editSelectedTraining();
    }//GEN-LAST:event_editEntryBtnActionPerformed

    private void deleteEntryBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteEntryBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(220, 38, 35));
    }//GEN-LAST:event_deleteEntryBtnMouseEntered

    private void deleteEntryBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteEntryBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(239, 68, 68));
    }//GEN-LAST:event_deleteEntryBtnMouseExited

    private void deleteEntryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEntryBtnActionPerformed
        // TODO add your handling code here:
        deleteSelectedTraining();
    }//GEN-LAST:event_deleteEntryBtnActionPerformed

    private void addEntryBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEntryBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(5, 150, 105));
    }//GEN-LAST:event_addEntryBtnMouseEntered

    private void addEntryBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEntryBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(16, 185, 129));
    }//GEN-LAST:event_addEntryBtnMouseExited

    private void addEntryBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addEntryBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addEntryBtnMousePressed

    private void addEntryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntryBtnActionPerformed
        // TODO add your handling code here:
        showAddTrainingDialog();
    }//GEN-LAST:event_addEntryBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEntryBtn;
    private javax.swing.JButton deleteEntryBtn;
    private javax.swing.JButton editEntryBtn;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable trainingTable;
    // End of variables declaration//GEN-END:variables
}
