package com.employee;

import java.sql.SQLOutput;
import java.util.Scanner;





    public class main {

        public static void main(String[] args) {
           Authentication a1= new Authentication();
            Scanner sc= new Scanner(System.in);
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
    }

