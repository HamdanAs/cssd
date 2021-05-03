package com.mycompany.cssd.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 *
 * @author NESAS
 */
public class Database {
    private final String DB_NAME = "cssd";
    private final String DB_USER = "root";
    private final String DB_PASS = "";
    
    private MysqlDataSource dataSource;
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    
    public Database() throws SQLException{
        dataSource = new MysqlDataSource();
        dataSource.setUser(DB_USER);
        dataSource.setPassword(DB_PASS);
        dataSource.setDatabaseName(DB_NAME);
        
        conn = dataSource.getConnection();
    }
    
    public void query(String query) throws SQLException{
        stmt = conn.prepareStatement(query);
    }

    public PreparedStatement getStmt() {
        return stmt;
    }

    public Connection getConn() {
        return conn;
    }
    
    public ResultSet execute() throws SQLException{
        return stmt.executeQuery();
    }
    
    public int rowCount() throws SQLException{
        return stmt.getUpdateCount();
    }
    
    public Object[] resultSet() throws SQLException{
        rs = execute();
        metaData = rs.getMetaData();
        int count = metaData.getColumnCount();
        
        while(rs.next()){
            Object[] data = new Object[count];
            for(int i = 1; i <= data.length; i++){
                data[i - 1] = rs.getString(i);
            }
            
            return data;
        }
        
        stmt.close();
        conn.close();
        
        return null;
    }
}
