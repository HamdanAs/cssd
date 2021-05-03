package com.mycompany.cssd.utility;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    
    public void setColumn(String[] colName){
        int colLength = colName.length;
        for (int i = 0; i < colLength; i++){
            model.addColumn(colName[i]);
        }
    }
}
