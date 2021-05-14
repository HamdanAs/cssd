package com.mycompany.cssd.controllers;

import com.mycompany.cssd.models.Model;
import com.mycompany.cssd.models.PinjamModel;
import com.mycompany.cssd.utility.Table;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author NESAS
 */
public class PinjamanController implements Controller{

    private Table table;
    private Model model;
    
    public PinjamanController(Table table) throws SQLException{
        this.table = table;
        this.model = new PinjamModel();
    }
    
    @Override
    public void insert(String[] data) {
        if(model.saveBatch(table) > 0){
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
        } else {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data!");
        }
    }

    @Override
    public void update(String[] data, int id) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void showAll() {
    }

    @Override
    public void showById(int id) {
    }

}
