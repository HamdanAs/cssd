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
    protected String[] fillables;
    
    private Database db;
    
    public int save(String[] data){
        try {
            String questionMark = "?";
            db = new Database();

            for (String fillable : fillables) {
                questionMark += ",?";
            }

            String query = "insert into " + table + " values(" + questionMark + ")";
            db.query(query);
            PreparedStatement stmt = db.getStmt();

            stmt.setInt(1, 0);
            for (int i = 1; i <= fillables.length - 1; i++){
                stmt.setString(i + 1, data[i - 1]);
            }

            stmt.execute();

            db.getConn().close();

            return 1;
        
        } catch (SQLException e){
            return 0;
        }
    }
    
    protected int update(String[] data, int id){
        try{
            String dataSection = "";
            db = new Database();

            for (String fillable : fillables) {
                dataSection += ", " + fillable + "=?";
            }

            char[] dataSectionArray = dataSection.toCharArray();
            dataSectionArray[0] = ' ';

            String newDataSection = String.valueOf(dataSectionArray)
                .replaceAll("\\s+", " ")
                .trim();

            String query = "update " + table + " set " + newDataSection + " where id=?";
            db.query(query);
            PreparedStatement stmt = db.getStmt();

            for (int i = 1; i <= fillables.length - 1; i++){
                stmt.setString(i, data[i - 1]);
            }
            stmt.setInt(fillables.length - 1, id);

            stmt.execute();

            db.getConn().close();
            
            return 1;
        } catch(SQLException e) {
            return 0;
        }
//
    }
    
    protected int destroy(int id){
        try{
            db = new Database();
            
            String query = "delete from " + table + "where id = ?";
            db.query(query);
            PreparedStatement stmt = db.getStmt();
            
            stmt.setInt(1, id);
            
            stmt.execute();
            
            db.getConn().close();
            return 1;
        } catch (SQLException e){
            return 0;
        }
    }
}
