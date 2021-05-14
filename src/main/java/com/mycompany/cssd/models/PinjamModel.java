package com.mycompany.cssd.models;

import java.sql.SQLException;

/**
 *
 * @author NESAS
 */
public class PinjamModel extends Model{
    
    public PinjamModel() throws SQLException {
        super.table = "pinjaman";
        super.fillables = new String[]{"idpeminjaman", "idbarang", "qtybarang"};
    }
    
    public String getTable(){
        return super.table;
    }
    
    public String[] getColumn(){
        return super.fillables;
    }
}