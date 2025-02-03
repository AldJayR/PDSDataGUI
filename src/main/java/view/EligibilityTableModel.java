package view;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Eligibility;

class EligibilityTableModel extends AbstractTableModel {

    private String[] columnNames = {"Career Service", "Rating", "Date of Examination", "Place of Examination", "License Number", "License Date of Validity"};
    private List<Eligibility> eligibilityList;

    public EligibilityTableModel(List<Eligibility> eligibilityList) {
        this.eligibilityList = eligibilityList;
    }

    @Override
    public int getRowCount() {
        return eligibilityList.size();
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
        Eligibility eligibility = eligibilityList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return eligibility.getCareerService();
            case 1:
                return eligibility.getRating();
            case 2:
                return eligibility.getDateOfExamination();
            case 3:
                return eligibility.getPlaceOfExamination();
            case 4:
                return eligibility.getLicenseNumber();
            case 5:
                return eligibility.getLicenseDateOfValidity();
            default:
                return null;
        }
    }

    public void addEligibility(Eligibility eligibility) {
        eligibilityList.add(eligibility);
        fireTableRowsInserted(eligibilityList.size() - 1, eligibilityList.size() - 1);
    }

    public void removeEligibility(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < eligibilityList.size()) {
            eligibilityList.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    public void clearData() {
        int size = eligibilityList.size();
        if (size > 0) {
            eligibilityList.clear();
            fireTableRowsDeleted(0, size - 1);
        }
    }

    public void updateEligibility(int rowIndex, Eligibility updatedEligibility) {
        if (rowIndex >= 0 && rowIndex < eligibilityList.size()) {
            eligibilityList.set(rowIndex, updatedEligibility);
            fireTableRowsUpdated(rowIndex, rowIndex);
        }
    }
}
