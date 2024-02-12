package com.employee;

import com.sun.tools.javac.Main;

import java.sql.SQLOutput;
import java.util.Scanner;
public class main {
    void mainMenu() {
        while(true){
            Authentication a1 = new Authentication();
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to Employee Management System7 DashBoard");
            System.out.println("1.ADMIN LOGIN..");
            System.out.println("2.EMPLOYEE LOGIN..");
            System.out.println("3.Exit..");
            int ch = sc.nextInt();
            if (ch == 1) {
                a1.AdminAuthenticate();
            }
            if (ch == 2) {
                a1.employeeAuthenticate();



    public class main {
            void MainMenu(){
                Authentication a1= new Authentication();
                Scanner sc= new Scanner(System.in);


                System.out.println("\033[H\033[2J");
                System.out.flush();

                System.out.println("");
                System.out.println("----------------------------------------");
                System.out.println("Welcome To EMPLOYEE MANAGEMENT SYSTEM");
                System.out.println("----------------------------------------");
                System.out.println("1) ADMIN LOGIN..");
                System.out.println("2) EMPLOYEE LOGIN..");
                System.out.print("Enter Your Choice: ");

                int ch=sc.nextInt();
                System.out.println("-----------------------");

                int ch=sc.nextInt();

                System.out.println("1.ADMIN LOGIN..");
                System.out.println("2.EMPLOYEE LOGIN..");
                int ch=sc.nextInt();


                if(ch==1){
                    a1.staffAuthenticate();
                }
                if(ch==2){
                    a1.employeeAuthenticate();
                }

            }
            else
            {
                System.out.println("Thankyou For using our Application..");
                break;
            }

        }
    }

    public static void main(String[] args) {
        main m1= new main();
        m1.mainMenu();
    }
}

