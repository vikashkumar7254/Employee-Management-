package com.employee;

import javax.swing.text.DateFormatter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Authentication {
    main m2= new main();
    Connection con;
    String name;
    Scanner sc= new Scanner(System.in);
    Menu m1= new Menu();
    void AdminAuthenticate(){

        con=DBConnection.CreateDBConnection();
        System.out.println("Enter username..");
        String username=sc.nextLine();
        System.out.println("Enter password");
        String password=sc.nextLine();
        try {
            PreparedStatement ps =con.prepareStatement("select *from admin_login where Username=? and Password_=?");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                m1.Adminmenu();
            }
            else{
                System.out.println("You have Enter Wrong Details...");
                System.out.println("press 1 for Main menu");
                System.out.println("press 2 for Exit");
                int sh=sc.nextInt();
                if(sh==1){
                    m2.mainMenu();
                }
                if(sh==2){
                    System.out.println("Thankyou For using our Application");
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    void employeeAuthenticate(){
        con=DBConnection.CreateDBConnection();
        System.out.println("Enter your ID to LOGIN..");
        int id=sc.nextInt();
        try {
            PreparedStatement ps = con.prepareStatement("select *from employee where Emp_id=?");
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                try{
                    PreparedStatement pss= con.prepareStatement("select  Emp_name from employee where Emp_id="+id);
                    ResultSet rss=pss.executeQuery();
                    if(rss.next()) {
                        name = rss.getString(1);
                    }
                    try{
                        LocalDate d1= LocalDate.now();
                        DateTimeFormatter d2= DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        String date = d1.format(d2);
                        PreparedStatement p=con.prepareStatement("insert into attendence values(?,?,?,?)");
                        p.setInt(1,id);
                        p.setString(2,name);
                        p.setString(3,date);
                        p.setString(4,"Present");
                        int r=p.executeUpdate();
                        if(r!=0){
                            System.out.println("record inserted");
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                m1.emp_Menu(id);
            }
            else{
                System.out.println("you have enter wrong id");
                System.out.println("press 1 for Main menu");
                System.out.println("press 2 for Exit");
                int h=sc.nextInt();
                if(h==1){
                      m2.mainMenu();
                }
                if(h==2){
                    System.out.println("Thankyou For Using Application");
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}