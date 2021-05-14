package com.mycompany.cssd.utility;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author NESAS
 */
public class Table {
    private JTable table;
    private DefaultTableModel model;
    
    public Table(JTable table){
        this.table = table;
        this.model = new DefaultTableModel();
        table.setModel(model);
    }
    
    public Table(){
       this.model = new DefaultTableModel();
    }
    
    public void setTable(JTable table){
        this.table = table;
        table.setModel(model);
    }
    
    public void setColumn(String[] colName){
        int colLength = colName.length;
        for (int i = 0; i < colLength; i++){
            model.addColumn(colName[i]);
        }
    }
    
    public void setColumnWidth(int tablePreferredWidth, double... percentages){
        double total = 0;
        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            total += percentages[i];
        }

        for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth((int)
                    (tablePreferredWidth * (percentages[i] / total)));
        }
    }
    
    public void addRow(Object[] data){
        model.addRow(data);
    }
    
    public int getRowIndex(){
        return table.getSelectedRow();
    }
    
    public int getColumnIndex(){
        return table.getSelectedColumn();
    }
    
    public int getRowCount(){
        return table.getRowCount();
    }
    
    public int getColumnCount(){
        return table.getColumnCount();
    }
    
    public Object getColumnValue(int row, int column){
        return model.getValueAt(row, column);
    }
    
    public void removeRow(int row){
        model.removeRow(row);
    }
}
