package com.mycompany.cssd.models;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NESAS
 */
public class AlatModel extends Model{
    
    public AlatModel() throws SQLException {
        super.table = "stokgudang";
        super.fillables = new String[]{"namabarang", "jenis", "tanggalmasuk" ,"stok"};
    }
    
    public String getTable(){
        return super.table;
    }
    
    public String[] getColumn(){
        return super.fillables;
    }
}
