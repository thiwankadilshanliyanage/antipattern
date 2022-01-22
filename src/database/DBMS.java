/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Thiwanka
 */
public class DBMS {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "thiwanka";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    private static Connection c;
    
    private DBMS(){}
    
    public static synchronized Connection getConnect(){
        try {
            if(c==null){
                Class.forName(DRIVER);
                c=DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return c;
        
    }
    public static void iud(String query){
        try {
            getConnect().createStatement().executeUpdate(query);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static ResultSet search(String query){
        ResultSet rs = null;
        try {
            rs = getConnect().createStatement().executeQuery(query);
        } catch (Exception e) {
            System.out.println(e);
        }
        return rs;
    }public static void main(String[] args) {
            System.out.println(c);
    }
}
