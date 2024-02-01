package com.employee;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;
    public static Connection CreateDBConnection(){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement","root","root");

            //
        }catch (Exception e){
        e.printStackTrace();
        }
        return con;
    }
}
