package com.employee;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Menu {
    Connection con;
    Scanner sc= new Scanner(System.in);
    EmployeeDaoInt inf = new EmployeeDaoImp();
    Employee emp = new Employee();


    void Adminmenu(){


                System.out.println("Welcome to main.Employee Management System........");
    int choice = 0;
                System.out.println("1.Press 1 to Add new Employee");
                System.out.println("2.Press 2 to Show all Employees");
                System.out.println("3.Press 3 to Show main.Employee by id");
                System.out.println("4.Press 4 to Update main.Employee record");
                System.out.println("5.Press 5 to delete employee record");
                System.out.println("6.Press 6 for Attendence System");
                System.out.println("6.Press 7 to Exit..");
                System.out.println("Enter your choice..: ");
    choice = sc.nextInt();
                if (choice == 1) {
        System.out.println("Enter Id :");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name :");
        String name = sc.nextLine();
        System.out.println("Enter age :");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Gender :");
        String gender = sc.nextLine();
        System.out.println("Enter Designation :");
        String designation = sc.nextLine();
        System.out.println("Enter Blood Group :");
        String blood_group = sc.nextLine();
        System.out.println("Enter Salary :");
        double salary = sc.nextDouble();
        System.out.println("Enter Phone Number :");
        long ph = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter Email :");
        String email = sc.nextLine();
        System.out.println("Enter Employee Total Leaves :");
        int leaves=sc.nextInt();
        emp.setId(id);
        emp.setName(name);
        emp.setAge(age);
        emp.setGender(gender);
        emp.setDesignation(designation);
        emp.setBloodGp(blood_group);
        emp.setSalary(salary);
        emp.setPhNumber(ph);
        emp.setEmail(email);
        emp.setLeave(leaves);
        inf.create(emp);

    }
                if (choice == 2) {
        inf.showall();

    }
                if (choice == 3) {
        System.out.println("Enter Employee id :");
        int id = sc.nextInt();

        inf.showbyid(id);

    }
                if (choice == 4) {

        System.out.println("Enter id :");
        int id = sc.nextInt();

        inf.update(id);


    }
                if (choice == 5) {
        System.out.println("Enter ID :");
        int id = sc.nextInt();
        inf.delete(id);

    }
                if (choice == 6) {
                    System.out.println("1.Show all attendance sheet");
                    System.out.println("2.Show attendance by data");
                    int ch=sc.nextInt();
                    if(ch==1){
                        con=DBConnection.CreateDBConnection();
                        try {
                            PreparedStatement ps= con.prepareStatement("select *from attendance");
                            ResultSet rs= ps.executeQuery();
                            while(rs.next()){
                                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getString(3)+rs.getString(4));
                            }

                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }


                    if (choice == 7) {
                        System.out.println("Thakyou For Using application....good by");
                    }
                }

}
void emp_Menu(int id){
        con=DBConnection.CreateDBConnection();
    System.out.println("Welcome to Employeee portal");
    System.out.println("1.Apply For Leave");
    System.out.println("2.Show leave Status");
    int ch=sc.nextInt();
    if(ch==1){
        int id1=id;
        sc.nextLine();
        System.out.println("Enter name :");
        String name=sc.nextLine();
        System.out.println("Enter Start to End date");
        String date=sc.nextLine();
        try{
                PreparedStatement ps= con.prepareStatement("insert into leave_db values(?,?,?,?)");
                ps.setInt(1,id1);
                ps.setString(2,name);
                ps.setString(3,date);
                ps.setString(4,"");
                int rs=ps.executeUpdate();
                if(rs!=0){
                    System.out.println("Leave submitted Successfully");
                }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    }

}
