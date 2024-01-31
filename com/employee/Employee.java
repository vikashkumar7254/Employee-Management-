package com.employee;

public class Employee {
        private int id;
        private String name;
        private String gender;
        private double age;
        private String designation;
        private String bloodGp;
        private double salary;
        private long phNumber;
        private String email;
        public Employee(){

        }
        public Employee(int id, String name, String gender, double age, String designation, String bloodGp, double salary, long phNumber, String email) {
            this.id = id;
            this.name = name;
            this.gender = gender;
            this.age = age;
            this.designation = designation;
            this.bloodGp = bloodGp;
            this.salary = salary;
            this.phNumber = phNumber;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public double getAge() {
            return age;
        }

        public void setAge(double age) {
            this.age = age;
        }

        public String getDesignation() {
            return designation;
        }

        public void setDesignation(String designation) {
            this.designation = designation;
        }

        public String getBloodGp() {
            return bloodGp;
        }

        public void setBloodGp(String bloodGp) {
            this.bloodGp = bloodGp;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public long getPhNumber() {
            return phNumber;
        }

        public void setPhNumber(long phNumber) {
            this.phNumber = phNumber;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", gender='" + gender + '\'' +
                    ", age=" + age +
                    ", designation='" + designation + '\'' +
                    ", bloodGp='" + bloodGp + '\'' +
                    ", salary=" + salary +
                    ", phNumber=" + phNumber +
                    ", email='" + email + '\'' +
                    '}';
        }
}
