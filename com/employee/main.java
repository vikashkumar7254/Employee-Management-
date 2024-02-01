package com.employee;

import java.util.Scanner;





    public class main {
        public static void main(String[] args) {
            Scanner sc= new Scanner(System.in);
            EmployeeDaoInt inf= new EmployeeDaoImp();
            Employee emp= new Employee();
            System.out.println("Welcome to main.Employee Management System........");
            int choice = 0;
            System.out.println("1.Press 1 to Add new main.Employee");
            System.out.println("2.Press 2 to Show all Employees");
            System.out.println("3.Press 3 to Show main.Employee by id");
            System.out.println("4.Press 4 to Update main.Employee record");
            System.out.println("5.Press 5 to delete employee record");
            System.out.println("6.Press 6 to Exit..");
            System.out.println("Enter your choice..: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("Enter Id :");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Name :");
                String name=sc.nextLine();
                System.out.println("Enter age :");
                int age=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Gender :");
                String gender=sc.nextLine();
                System.out.println("Enter Designation :");
                String designation=sc.nextLine();
                System.out.println("Enter Blood Group :");
                String blood_group=sc.nextLine();
                System.out.println("Enter Salary :");
                double salary=sc.nextDouble();
                System.out.println("Enter Phone Number :");
                long ph=sc.nextLong();
                sc.nextLine();
                System.out.println("Enter Email :");
                String email=sc.nextLine();

                emp.setId(id);
                emp.setName(name);
                emp.setAge(age);
                emp.setGender(gender);
                emp.setDesignation(designation);
                emp.setBloodGp(blood_group);
                emp.setSalary(salary);
                emp.setPhNumber(ph);
                emp.setEmail(email);
                inf.create(emp);

            }
            if (choice == 2) {
                inf.showall();

            }
            if (choice == 3) {
                System.out.println("Enter Employee id :");
                int id=sc.nextInt();

                inf.showbyid(id);

            }
            if (choice == 4) {

                System.out.println("Enter id :");
                int id=sc.nextInt();

                inf.update(id);


            }
            if (choice == 5) {
                System.out.println("Enter ID :");
                int id=sc.nextInt();
                inf.delete(id);

            }
            if (choice == 6) {
                System.out.println("Thakyou For Using application....good by");



            }

        }
    }

