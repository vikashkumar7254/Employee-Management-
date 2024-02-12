package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Authentication {
    Connection con;
        Scanner sc= new Scanner(System.in);
    Menu m1= new Menu();
    void staffAuthenticate(){

        con=DBConnection.CreateDBConnection();

        System.out.println("");
        System.out.println("Press 1 for SIGN UP..");
        System.out.println("Press 2 for LOGIN..");
        System.out.print("Enter Your Choice: ");
        int ch=sc.nextInt();
        if(ch==1){
            sc.nextLine();
            System.out.println("");
            System.out.print("Enter Username: ");
            String username=sc.nextLine();
            System.out.print("Enter Password: ");
            String password=sc.nextLine();
            try{
                PreparedStatement ps = con.prepareStatement("insert into admin_login values(?,?)");
                ps.setString(1,username);
                ps.setString(2,password);
                int rs=ps.executeUpdate();
                System.out.println("Sign Up Successfully");

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(ch==2){
            sc.nextLine();
            System.out.println("");
            System.out.print("Enter Username: ");
            String username=sc.nextLine();
            System.out.print("Enter Password: ");
            String password=sc.nextLine();
            try {
                PreparedStatement ps =con.prepareStatement("select * from admin_login where Username=? and Password_=?");
                ps.setString(1,username);
                ps.setString(2,password);
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    m1.Adminmenu();
                }
                else{
                    System.out.println("You have Enter Wrong Details...");
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }

    }
    void employeeAuthenticate()
    {
        con=DBConnection.CreateDBConnection();
        System.out.println("");
        System.out.print("Enter your ID to LOGIN: ");
        int id=sc.nextInt();
        try
        {
                PreparedStatement ps = con.prepareStatement("select * from employee where Emp_id=?");
                ps.setInt(1,id);
                ResultSet rs= ps.executeQuery();
                if(rs.next())
                {
                        m1.emp_Menu(id);
                }
                else
                {
                    System.out.println("You Have Entered Wrong ID...");
                }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
