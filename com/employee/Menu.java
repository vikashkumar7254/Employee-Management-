package com.employee;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Menu
{
    Connection con;
    Scanner sc= new Scanner(System.in);
    EmployeeDaoInt inf = new EmployeeDaoImp();
    Employee emp = new Employee();
    int levs;
    int data;
    int exit=7;

    void Adminmenu()
    {
        main m1 = new main();
        do
        {
            System.out.println("");
            System.out.println("------------------------------------------");
            System.out.println("Welcome to ADMIN MENU");
            System.out.println("------------------------------------------");
            System.out.println("1) Press 1 to Add New Employee");
            System.out.println("2) Press 2 to Show All Employees");
            System.out.println("3) Press 3 to Show Employee by ID");
            System.out.println("4) Press 4 to Update Employee Record");
            System.out.println("5) Press 5 to Delete Employee Record");
            System.out.println("6) Press 6 to Check Leave Request");
            System.out.println("7) Press 7 to EXIT..");
            System.out.println("");
            System.out.print("Enter your Choice: ");

    void Adminmenu() {
        do {
            System.out.println("Welcome to main.Employee Management System........");
            System.out.println("1.Press 1 to Add new Employee");
            System.out.println("2.Press 2 to Show all Employees");
            System.out.println("3.Press 3 to Show main.Employee by id");
            System.out.println("4.Press 4 to Update main.Employee record");
            System.out.println("5.Press 5 to delete employee record");
            System.out.println("6.Press 6 for Check Leave Request");
            System.out.println("7.Press 7 to Exit..");
            System.out.println("Enter your choice..: ");

            int choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
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
                    int leaves = sc.nextInt();
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
                    break;
                case 2:
                    inf.showall();
                    break;
                case 3:
                    System.out.println("Enter Employee id :");
                    int id1 = sc.nextInt();

                    inf.showbyid(id1);
                    break;
                case 4:
                    System.out.println("Enter id :");
                    int id2 = sc.nextInt();

                    inf.update(id2);
                    break;
                case 5:
                    System.out.println("Enter ID :");
                    int id3 = sc.nextInt();
                    inf.delete(id3);

                    break;
                case 6:

                {
                    System.out.println("1 Show All Leave Requests");
                    System.out.println("2. Update Request by ID : ");
                    int lev = sc.nextInt();
                    switch (lev)
                    {

                    System.out.println("1 show all Leave Requests");
                    System.out.println("2. Update Request by ID : ");
                    int lev = sc.nextInt();
                    switch (lev) {

                        case 1:
                            con = DBConnection.CreateDBConnection();
                            try {
                                PreparedStatement ps = con.prepareStatement("select * from leave_db");
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                                    System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3));
                                }
                            } catch (Exception e) {
                                e.printStackTrace();

                            }
                            break;
                        case 2:
                            System.out.println("Enter your Id");
                            int ids = sc.nextInt();

                            System.out.println("1. For Approve\n 2. FOr or Not");
                            int ap = sc.nextInt();
                            if (ap == 1)
                                System.out.println("Count Total leaves Date !");
                            levs = sc.nextInt();

                            try {
                                con = DBConnection.CreateDBConnection();
                                //PreparedStatement ps = con.prepareStatement("update employee set Total_leaves_available=? where Emp_id=?");
                                PreparedStatement ps = con.prepareStatement("select Total_leaves_available from employee where Emp_id=" + ids);
                                ResultSet rs = ps.executeQuery();
                                while (rs.next()) {
                                    data = rs.getInt(1);
                                }


                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            try {
                                int levs1 = data - levs;
                                con = DBConnection.CreateDBConnection();
                                PreparedStatement ps = con.prepareStatement("update employee set Total_leaves_available=? where Emp_id=" + ids);
                                ps.setInt(1, levs1);
                                int rs = ps.executeUpdate();
                                if (rs != 0) {
                                    System.out.println("Update Successfully");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            try {

                                String str = "Approve";
                                con = DBConnection.CreateDBConnection();
                                PreparedStatement ps = con.prepareStatement("update leave_db set Stats=? where Emp_id=?");
                                ps.setString(1, str);
                                ps.setInt(2, ids);
                                int rs = ps.executeUpdate();
                                if (rs != 0) {
                                    System.out.println("Update Successfully");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            if (ap == 2)

                            }
                            break;
                        case 2:
                            System.out.println("Enter your Id");
                            int ids = sc.nextInt();

                            System.out.println("1. For Approve\n 2. FOr or Not");
                            int ap= sc.nextInt();
                            if (ap==1)
                                System.out.println("Count Total leaves Date !");
                            levs=sc.nextInt();

                                try {
                                    con = DBConnection.CreateDBConnection();
                                    //PreparedStatement ps = con.prepareStatement("update employee set Total_leaves_available=? where Emp_id=?");
                                    PreparedStatement ps = con.prepareStatement("select Total_leaves_available from employee where Emp_id="+ids);
                                    ResultSet rs=ps.executeQuery();
                                    while (rs.next()){
                                        data=rs.getInt(1);
                                    }


                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                                try {
                                    int levs1=data-levs;
                                    con = DBConnection.CreateDBConnection();
                                    PreparedStatement ps = con.prepareStatement("update employee set Total_leaves_available=? where Emp_id="+ids);
                                    ps.setInt(1,levs1);
                                    int rs = ps.executeUpdate();
                                    if (rs != 0) {
                                        System.out.println("Update Successfully");
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            try {

                                String str = "Approve";
                                con = DBConnection.CreateDBConnection();
                                PreparedStatement ps = con.prepareStatement("update leave_db set Stats=? where Emp_id=?");
                                ps.setString(1, str);
                                ps.setInt(2, ids);
                                int rs = ps.executeUpdate();
                                if (rs != 0) {
                                    System.out.println("Update Successfully");
                                }
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            if (ap==2)

                                try {

                                    String str = "Rejected";
                                    con = DBConnection.CreateDBConnection();
                                    PreparedStatement ps = con.prepareStatement("update leave_db set Stats=? where Emp_id=?");
                                    ps.setString(1, str);
                                    ps.setInt(2, ids);
                                    int rs = ps.executeUpdate();
                                    if (rs != 0) {
                                        System.out.println("Update Successfully");
                                    }
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }

                            break;
                        default:
                            System.out.println("Wrong Input ! ");
                    }


                    break;
                }
                case 7:
                {

                    m1.MainMenu();
                }
                default :
                    System.out.println("Thank You For Using The Application....");
                    break;
            }

        }
        while (true);
    }

    void emp_Menu(int id)
    {
        con=DBConnection.CreateDBConnection();

        System.out.println("\n----------------------------");
        System.out.println("Welcome to EMPLOYEE PORTAL");
        System.out.println("----------------------------");
        System.out.println("1) Apply For Leave");
        System.out.println("2) Show Leave Status");
        System.out.println("");
        int ch=sc.nextInt();
        if(ch==1)
        {
            int id1=id;
            sc.nextLine();
            System.out.print("Enter Name: ");
            String name=sc.nextLine();
            System.out.print("Enter Start to End Date");
            String date=sc.nextLine();
            try
            {
                con = DBConnection.CreateDBConnection();
                PreparedStatement ps = con.prepareStatement("update employee set Total_leaves_available=? where Emp_id=?");
                ps.setInt(1,levs);
                ps.setInt(2, id);
                int rs = ps.executeUpdate();
                if (rs != 0)
                {
                    System.out.println("Record Updated Successfully...");

            break;
            default :
                System.out.println("Thakyou For Using application....good by");
                break;
        }

        }while (true);
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
        try {
            con = DBConnection.CreateDBConnection();
            PreparedStatement ps = con.prepareStatement("update employee set Total_leaves_available=? where Emp_id=?");
           ps.setInt(1,levs);
            ps.setInt(2, id);
            int rs = ps.executeUpdate();
            if (rs != 0) {
                System.out.println("Update Successfully");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try{
                PreparedStatement ps= con.prepareStatement("insert into leave_db values(?,?,?,?)");
                ps.setInt(1,id1);
                ps.setString(2,name);
                ps.setString(3,date);
                ps.setString(4,"");
                int rs=ps.executeUpdate();
                if(rs!=0){

                }
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
            try
            {
                    PreparedStatement ps= con.prepareStatement("insert into leave_db values(?,?,?,?)");
                    ps.setInt(1,id1);
                    ps.setString(2,name);
                    ps.setString(3,date);
                    ps.setString(4,"");
                    int rs=ps.executeUpdate();
                    if(rs!=0)
                    {
                        System.out.println("Leave submitted Successfully");
                    }

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }


        if (ch==2)
        {
            con=DBConnection.CreateDBConnection();
            String query="SELECT * FROM leave_db WHERE Emp_id =" +id;

            //String query1="select * from employee where id="+id;
            try
            {
                Statement stmt= con.createStatement();
                ResultSet result= stmt.executeQuery(query);
                while (result.next())
                {
                    System.out.println(result.getInt(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4));
                }

            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }

        }

    }
if (ch==2){
    con=DBConnection.CreateDBConnection();
    String query="SELECT * FROM leave_db WHERE Emp_id =" +id;

    //String query1="select * from employee where id="+id;
    try {
        Statement stmt= con.createStatement();
        ResultSet result= stmt.executeQuery(query);
        while (result.next()){
            System.out.println(result.getInt(1)+"  "+result.getString(2)+"  "+result.getString(3)+"  "+result.getString(4));
        }

}catch (Exception ex){
        ex.printStackTrace();
    }

    }


    }

}
