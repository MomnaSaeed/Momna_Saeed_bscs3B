/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

/**
 *
 * @author msaeed.bscs13seecs
 */


import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.sql.Statement;


public class JavaApplication5 {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://localhost/NCITY";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "root";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");
      
      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();
      
      String sql = "CREATE TABLE IF NOT EXISTS GEO_LOCATIONS"+
						 "(lOCID 			INT PRIMARY KEY	NOT NULL," +
						 "COUNTRY			TEXT			," +
						 "REGION			TEXT			," +
						 "CITY				TEXT			," +
						 "POSTALCODE		        TEXT			," +
						 "LATITUDE			FLOAT			," +
						 "LONGITUDE			FLOAT			," +
						 "METROCODE			INT			," +
						 "AREACODE			INT			)" ;

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");
       stmt = conn.createStatement();
      String nsql="Select lattitude and longitude from NCITY where city";
        stmt.executeUpdate(nsql);
      
      
      
      
      
      
   }catch(SQLException se){
      //Handle errors for JDBC
      se.printStackTrace();
   }catch(Exception e){
      //Handle errors for Class.forName
      e.printStackTrace();
   }finally{
      //finally block used to close resources
      try{
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){
      }// do nothing
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
   System.out.println("Geo lite table in database !");
}//end main
}//end JDBCExample
