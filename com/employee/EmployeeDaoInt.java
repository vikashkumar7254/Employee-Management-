package com.employee;

public interface EmployeeDaoInt {
    public void create(Employee emp);
    public void showall();
    public void showbyid(int id);
    public void update(int id);
    public void delete(int id);
    public void attendence(int id);


}
