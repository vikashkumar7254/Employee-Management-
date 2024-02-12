package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDaoImp implements EmployeeDaoInt
{
    Connection con;
    @Override
    public void create(Employee emp)
    {
        try
        {
            con=DBConnection.CreateDBConnection();
            PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,emp.getId());
            ps.setString(2,emp.getName());
            ps.setInt(3,emp.getAge());
            ps.setString(4,emp.getGender());
            ps.setString(5,emp.getDesignation());
            ps.setString(6,emp.getBloodGp());
            ps.setDouble(7,emp.getSalary());
            ps.setLong(8,emp.getPhNumber());
            ps.setString(9,emp.getEmail());
            ps.setInt(10,emp.getLeave());
            int rs= ps.executeUpdate();
            System.out.println("Records Inserted Successfully...");

            con.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void showall()
    {
        con=DBConnection.CreateDBConnection();
        System.out.println("");
        System.out.println("EMPLOYEE DETAILS");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.format("%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t\t\t%s\n","ID","Name","Age","Gender","Designation","Blood Group","Salary","Phone Number","Email","Total Leaves");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");



        try
        {
            PreparedStatement ps= con.prepareStatement("select * from employee");
            ResultSet rs=ps.executeQuery();

            while(rs.next())
            {
                System.out.format("%d\t%s\t%d\t\t%s\t\t\t%s\t\t\t\t%s\t\t\t\t%.2f\t%d\t\t%s\t\t%d\n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getInt(10));

                System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");


            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getDouble(7)+" "+rs.getLong(8)+" "+rs.getString(9)+" "+rs.getInt(10));



            }
            con.close();
            rs.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }

    @Override
    public void showbyid(int id)
    {
        con=DBConnection.CreateDBConnection();

        System.out.println("");
        System.out.println("EMPLOYEE DETAILS");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");

        System.out.format("%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t\t%s\t%s\t\t\t\t%s\n","ID","Name","Age","Gender","Designation","Blood Group","Salary","Phone Number","Email","Total Leaves");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");


        try
        {
            Statement stm= con.createStatement();
            String quary="select * from employee where Emp_id="+id;
            ResultSet rs= stm.executeQuery(quary);

            while(rs.next())
            {
                System.out.format("%d\t%s\t%d\t\t%s\t\t\t%s\t\t\t\t%s\t\t\t\t%.2f\t%d\t\t%s\t\t%d\n",
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getDouble(7),
                        rs.getLong(8),
                        rs.getString(9),
                        rs.getInt(10));

            }



            while(rs.next()){
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getDouble(7)+"  "+rs.getLong(8)+"  "+rs.getString(9)+"  "+rs.getInt(10));


            }

            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
        }
        catch (Exception e)
        {
        e.printStackTrace();

        }

    }

    @Override
    public void update(int id) {
        con=DBConnection.CreateDBConnection();
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to UPDATION Portal");
        System.out.println("1) Press 1 for Name");
        System.out.println("2) Press 2 for Age");
        System.out.println("3) Press 3 for Gender");
        System.out.println("4) Press 4 for Designation");
        System.out.println("5) Press 5 for Blood Group");
        System.out.println("6) Press 6 for Salary");
        System.out.println("7) Press 7 for Phone Number");
        System.out.println("8) Press 8 for Email");
        System.out.print("Enter Your Choice: ");
       int choice=sc.nextInt();

        switch (choice)
        {
            case 1:
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name =sc.nextLine();
                try
                {
                    PreparedStatement ps = con.prepareStatement("update employee set Emp_name=? where Emp_id=?");
                    ps.setString(1,name);
                    ps.setInt(2,id);


                    int rs=ps.executeUpdate();
                    if(rs!=0)
                    {
                        System.out.println("Record Updated Successfully");
                    }

                }
                catch (Exception e)
                {
                    e.printStackTrace();

                }
                break;
                case 2:
                System.out.print("Enter Age: ");
                int age =sc.nextInt();
                try
                {
                    PreparedStatement ps = con.prepareStatement("update employee set Emp_age=? where Emp_id=?");
                    ps.setInt(1,age);
                    ps.setInt(2,id);


                    int rs=ps.executeUpdate();
                    if(rs!=0)
                    {
                        System.out.println("Record Updated Successfully");
                    }


                }
                catch (Exception e)
                {
                    e.printStackTrace();

                }
                break;
                case 3:
                    sc.nextLine();
                System.out.println("Enter gender :");
                String gender =sc.nextLine();

                try {
                    PreparedStatement ps = con.prepareStatement("update employee set Emp_gender=? where Emp_id=?");
                    ps.setString(1, gender);
                    ps.setInt(2, id);


                    int rs = ps.executeUpdate();
                    if (rs != 0) {
                        System.out.println("updated successfully");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                    break;
            case 4:
                sc.nextLine();
                System.out.println("Enter Designation :");
                String designation =sc.nextLine();


                try {
                    PreparedStatement ps = con.prepareStatement("update employee set Emp_designation=? where Emp_id=?");
                    ps.setString(1, designation);
                    ps.setInt(2, id);


                    int rs = ps.executeUpdate();
                    if (rs != 0) {
                        System.out.println("updated successfully");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
            case 5:sc.nextLine();
                System.out.println("Enter blood Group :");
                String blood_group =sc.nextLine();
                try {
                    PreparedStatement ps = con.prepareStatement("update employee set blood_group=? where Emp_id=?");
                    ps.setString(1, blood_group);
                    ps.setInt(2, id);


                    int rs = ps.executeUpdate();
                    if (rs != 0) {
                        System.out.println("updated successfully");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
            case 6:
                System.out.println("Enter salary :");
                double salary =sc.nextDouble();
                try {
                    PreparedStatement ps = con.prepareStatement("update employee set salary=? where Emp_id=?");
                    ps.setDouble(1, salary);
                    ps.setInt(2, id);


                    int rs = ps.executeUpdate();
                    if (rs != 0) {
                        System.out.println("updated successfully");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

                break;
            case 7:

                System.out.println("Enter salary :");
                long ph =sc.nextLong();
                try {
                    PreparedStatement ps = con.prepareStatement("update employee set Emp_phNumber=? where Emp_id=?");
                    ps.setLong(1, ph);
                    ps.setInt(2, id);


                    int rs = ps.executeUpdate();
                    if (rs != 0) {
                        System.out.println("updated successfully");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                    break;
            case 8:
                sc.nextLine();
                System.out.println("Enter Email :");
                String email =sc.nextLine();

                try {
                    PreparedStatement ps = con.prepareStatement("update employee set Emp_email=? where Emp_id=?");
                    ps.setString(1,email);
                    ps.setInt(2, id);


                    int rs = ps.executeUpdate();
                    if (rs != 0) {
                        System.out.println("updated successfully");
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("you have Enter wrong choice...");


        }

    }

    @Override
    public void delete(int id) {
        con=DBConnection.CreateDBConnection();
        try {
            PreparedStatement ps = con.prepareStatement("delete from employee where Emp_id=?");
            ps.setInt(1,id);
            int rs=ps.executeUpdate();

                System.out.println("Data Delete Successfully");

        }catch (Exception e){
            e.printStackTrace();

        }


    }

    @Override
    public void attendence(int id) {

    }
}
