package com.mycompany.cssd.controllers;

import com.mycompany.cssd.database.Database;
import com.mycompany.cssd.utility.Table;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author NESAS
 */
public class RuanganController implements Controller{

    private JTable jTable;
    private Table table;
    
    private Database db;
    
    public RuanganController(Table table) throws SQLException {
        this.table = table;
        this.db = new Database();
    }
    
    @Override
    public void insert(String[] data) {
    }

    @Override
    public void update(String[] data, int id) {
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void showAll() {
        try {
            String query = "select * from ruangan";
            db.query(query);
            
            db.resultSet(table);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void showById(int id) {
    }

}
