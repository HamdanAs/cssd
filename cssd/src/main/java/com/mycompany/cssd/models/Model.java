package com.mycompany.cssd.models;

import com.mycompany.cssd.database.Database;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author NESAS
 */
public class Model {
    protected String table;
    protected String[] fillable;
    
    private static Database db;
    
    protected Model(){
        table = "";
        fillable = new String[]{};
    }
    
    public static void save() throws SQLException{
        db = new Database();
        String query = "insert into stokgudang values(?,?,?,?,?)";
        db.query(query);
        PreparedStatement stmt = db.getStmt();
        
        stmt.setInt(1, 0);
        stmt.setString(2, "ADFda");
        stmt.setString(3, "ASDFsa");
        stmt.setString(4, "2020-1-1");
        stmt.setString(5, "15");
        
        stmt.execute();
        
        db.getConn().close();
    }
    
    protected static void update(){
        
    }
    
    protected static void destroy(){
        
    }
}
