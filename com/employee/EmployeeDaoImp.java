package com.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoImp implements EmployeeDaoInt {
    Connection con;
    @Override
    public void create(Employee emp) {
        try {
            con=DBConnection.CreateDBConnection();
            PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?)");
            ps.setInt(1,emp.getId());
            ps.setString(2,emp.getName());
            ps.setInt(3,emp.getAge());
            ps.setString(4,emp.getGender());
            ps.setString(5,emp.getDesignation());
            ps.setString(6,emp.getBloodGp());
            ps.setDouble(7,emp.getSalary());
            ps.setLong(8,emp.getPhNumber());
            ps.setString(9,emp.getEmail());
            int rs= ps.executeUpdate();
            System.out.println("Records inserted");

con.close();
        }
        catch (Exception e){
        e.printStackTrace();

        }


    }

    @Override
    public void showall() {
        con=DBConnection.createDBconnection();
        try {
            PreparedStatement ps= con.prepareStatement("select *from employee");
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                System.out.println(rs.getInt(1)+rs.getString(2)+rs.getInt(3)+rs.getString(4)+rs.getString(5)+rs.getString(6)+rs.getDouble(7)+rs.getLong(8)+rs.getString(9));

            }
            con.close();
            rs.close();

        }catch (Exception e){
            e.printStackTrace();;
        }

    }

    @Override
    public void showbyid(int id) {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
