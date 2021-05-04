package com.mycompany.cssd.models;

import java.sql.SQLException;

/**
 *
 * @author NESAS
 */
public class AlatModel extends Model{

    public AlatModel() {
        super();
        super.table = "stokgudang";
        super.fillable = new String[]{""};
    }
    
    public void insert() throws SQLException{
        Model.save();
    }
}
