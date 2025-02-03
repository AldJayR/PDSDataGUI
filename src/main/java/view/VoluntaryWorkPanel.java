/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import model.VoluntaryWork;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class VoluntaryWorkPanel extends javax.swing.JPanel {

    /**
     * Creates new form VoluntaryWorkPanel
     */
    private List<VoluntaryWork> voluntaryWorkList = new ArrayList<>();
    private VoluntaryWorkTableModel tableModel;

    public VoluntaryWorkPanel() {
        initComponents();
        tableModel = new VoluntaryWorkTableModel(voluntaryWorkList);
        voluntaryWorkTable.setModel(tableModel);
    }

    public int getVoluntaryWorkCount() {
        return voluntaryWorkList.size();
    }

    public String getOrganizationName(int rowIndex) {
        return voluntaryWorkList.get(rowIndex).getOrganizationName();
    }

    public String getOrganizationAddress(int rowIndex) {
        return voluntaryWorkList.get(rowIndex).getOrganizationAddress();
    }

    public LocalDate getDateFrom(int rowIndex) {
        return voluntaryWorkList.get(rowIndex).getDateFrom();
    }

    public LocalDate getDateTo(int rowIndex) {
        return voluntaryWorkList.get(rowIndex).getDateTo();
    }

    public int getNumberOfHours(int rowIndex) {
        return voluntaryWorkList.get(rowIndex).getNumberOfHours();
    }

    public String getPositionNatureOfWork(int rowIndex) {
        return voluntaryWorkList.get(rowIndex).getPositionNatureOfWork();
    }

    private void showAddVoluntaryWorkDialog() {
        AddVoluntaryWorkDialog dialog = new AddVoluntaryWorkDialog(JOptionPane.getFrameForComponent(this), true);
        dialog.setVisible(true);
        VoluntaryWork newVoluntaryWork = dialog.getVoluntaryWork();
        if (newVoluntaryWork != null) {
            tableModel.addVoluntaryWork(newVoluntaryWork);
        }
    }

    private void editSelectedVoluntaryWork() {
        int selectedRow = voluntaryWorkTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a voluntary work entry to edit.", "No Entry Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VoluntaryWork voluntaryWorkToEdit = voluntaryWorkList.get(selectedRow);
        AddVoluntaryWorkDialog dialog = new AddVoluntaryWorkDialog(JOptionPane.getFrameForComponent(this), true, voluntaryWorkToEdit);
        dialog.setVisible(true);

        VoluntaryWork updatedVoluntaryWork = dialog.getVoluntaryWork();
        if (updatedVoluntaryWork != null) {
            voluntaryWorkList.set(selectedRow, updatedVoluntaryWork);
            tableModel.fireTableRowsUpdated(selectedRow, selectedRow);
        }
    }

    class VoluntaryWorkTableModel extends AbstractTableModel {

        private String[] columnNames = {"Name & Address of Organization", "Date From", "Date To", "Number of Hours", "Position/Nature of Work"};
        private List<VoluntaryWork> voluntaryWorkList;

        public VoluntaryWorkTableModel(List<VoluntaryWork> voluntaryWorkList) {
            this.voluntaryWorkList = voluntaryWorkList;
        }

        @Override
        public int getRowCount() {
            return voluntaryWorkList.size();
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
            VoluntaryWork voluntaryWork = voluntaryWorkList.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return voluntaryWork.getOrganizationName() + ", " + voluntaryWork.getOrganizationAddress();
                case 1:
                    return voluntaryWork.getDateFrom() != null ? voluntaryWork.getDateFrom().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) : "";
                case 2:
                    return voluntaryWork.getDateTo() != null ? voluntaryWork.getDateTo().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) : "";
                case 3:
                    return voluntaryWork.getNumberOfHours();
                case 4:
                    return voluntaryWork.getPositionNatureOfWork();
                default:
                    return null;
            }
        }

        public void addVoluntaryWork(VoluntaryWork voluntaryWork) {
            voluntaryWorkList.add(voluntaryWork);
            fireTableRowsInserted(voluntaryWorkList.size() - 1, voluntaryWorkList.size() - 1);
        }

        public void removeVoluntaryWork(int rowIndex) {
            if (rowIndex >= 0 && rowIndex < voluntaryWorkList.size()) {
                voluntaryWorkList.remove(rowIndex);
                fireTableRowsDeleted(rowIndex, rowIndex);
            }
        }

        public void clearData() {
            int size = voluntaryWorkList.size();
            if (size > 0) {
                voluntaryWorkList.clear();
                fireTableRowsDeleted(0, size - 1);
            }
        }
    }

    private void deleteSelectedVoluntaryWork() {
        int selectedRow = voluntaryWorkTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a voluntary work entry to delete.", "No Entry Selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the selected voluntary work entry?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.removeVoluntaryWork(selectedRow);
        }
    }

    public void refreshData() {
        tableModel.clearData();
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
        voluntaryWorkTable = new javax.swing.JTable();
        editVoluntaryWorkBtn = new javax.swing.JButton();
        deleteVoluntaryWorkBtn = new javax.swing.JButton();
        addVoluntaryWorkBtn = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(243, 244, 246));

        informationLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        informationLabel.setText("Voluntary Work");

        voluntaryWorkTable.setModel(new javax.swing.table.DefaultTableModel(
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
        voluntaryWorkTable.setRowHeight(30);
        voluntaryWorkTable.setShowGrid(false);
        jScrollPane1.setViewportView(voluntaryWorkTable);

        editVoluntaryWorkBtn.setBackground(new java.awt.Color(59, 130, 246));
        editVoluntaryWorkBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        editVoluntaryWorkBtn.setForeground(new java.awt.Color(255, 255, 255));
        editVoluntaryWorkBtn.setText("Edit Voluntary Work");
        editVoluntaryWorkBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        editVoluntaryWorkBtn.setFocusPainted(false);
        editVoluntaryWorkBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        editVoluntaryWorkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editVoluntaryWorkBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editVoluntaryWorkBtnMouseExited(evt);
            }
        });
        editVoluntaryWorkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editVoluntaryWorkBtnActionPerformed(evt);
            }
        });

        deleteVoluntaryWorkBtn.setBackground(new java.awt.Color(239, 68, 68));
        deleteVoluntaryWorkBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        deleteVoluntaryWorkBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteVoluntaryWorkBtn.setText("Delete Voluntary Work");
        deleteVoluntaryWorkBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        deleteVoluntaryWorkBtn.setFocusPainted(false);
        deleteVoluntaryWorkBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        deleteVoluntaryWorkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteVoluntaryWorkBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteVoluntaryWorkBtnMouseExited(evt);
            }
        });
        deleteVoluntaryWorkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteVoluntaryWorkBtnActionPerformed(evt);
            }
        });

        addVoluntaryWorkBtn.setBackground(new java.awt.Color(16, 185, 129));
        addVoluntaryWorkBtn.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        addVoluntaryWorkBtn.setForeground(new java.awt.Color(255, 255, 255));
        addVoluntaryWorkBtn.setText("Add Voluntary Work");
        addVoluntaryWorkBtn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addVoluntaryWorkBtn.setFocusPainted(false);
        addVoluntaryWorkBtn.setMargin(new java.awt.Insets(5, 10, 5, 10));
        addVoluntaryWorkBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addVoluntaryWorkBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addVoluntaryWorkBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addVoluntaryWorkBtnMousePressed(evt);
            }
        });
        addVoluntaryWorkBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addVoluntaryWorkBtnActionPerformed(evt);
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
                        .addComponent(addVoluntaryWorkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(editVoluntaryWorkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(deleteVoluntaryWorkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(editVoluntaryWorkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteVoluntaryWorkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addVoluntaryWorkBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void editVoluntaryWorkBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editVoluntaryWorkBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(37, 99, 235));
    }//GEN-LAST:event_editVoluntaryWorkBtnMouseEntered

    private void editVoluntaryWorkBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editVoluntaryWorkBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(59, 130, 246));
    }//GEN-LAST:event_editVoluntaryWorkBtnMouseExited

    private void editVoluntaryWorkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editVoluntaryWorkBtnActionPerformed
        // TODO add your handling code here:
        editSelectedVoluntaryWork();
    }//GEN-LAST:event_editVoluntaryWorkBtnActionPerformed

    private void deleteVoluntaryWorkBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteVoluntaryWorkBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(220, 38, 35));
    }//GEN-LAST:event_deleteVoluntaryWorkBtnMouseEntered

    private void deleteVoluntaryWorkBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteVoluntaryWorkBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(239, 68, 68));
    }//GEN-LAST:event_deleteVoluntaryWorkBtnMouseExited

    private void deleteVoluntaryWorkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteVoluntaryWorkBtnActionPerformed
        // TODO add your handling code here:
        deleteSelectedVoluntaryWork();
    }//GEN-LAST:event_deleteVoluntaryWorkBtnActionPerformed

    private void addVoluntaryWorkBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addVoluntaryWorkBtnMouseEntered
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(5, 150, 105));
    }//GEN-LAST:event_addVoluntaryWorkBtnMouseEntered

    private void addVoluntaryWorkBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addVoluntaryWorkBtnMouseExited
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();

        button.setBackground(new Color(16, 185, 129));
    }//GEN-LAST:event_addVoluntaryWorkBtnMouseExited

    private void addVoluntaryWorkBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addVoluntaryWorkBtnMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addVoluntaryWorkBtnMousePressed

    private void addVoluntaryWorkBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addVoluntaryWorkBtnActionPerformed
        // TODO add your handling code here:
        showAddVoluntaryWorkDialog();
    }//GEN-LAST:event_addVoluntaryWorkBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addVoluntaryWorkBtn;
    private javax.swing.JButton deleteVoluntaryWorkBtn;
    private javax.swing.JButton editVoluntaryWorkBtn;
    private javax.swing.JLabel informationLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable voluntaryWorkTable;
    // End of variables declaration//GEN-END:variables
}
