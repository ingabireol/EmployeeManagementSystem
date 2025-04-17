package com.olim.employeemanagementsystem.db;

import com.olim.employeemanagementsystem.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class EmployeeDatabase<T> {
    private final  HashMap<T, Employee<T>> employees;

    public EmployeeDatabase(HashMap<T, Employee<T>> employees) {
        this.employees = employees;
    }
    public T addEmployee(Employee<T> employee){
        if(employee == null){
            throw new IllegalArgumentException("Employee can not be empty");
        }
        if(employees.containsKey(employee.getEmployeeId()))
            return null;
        employees.put(employee.getEmployeeId(),employee);
        return employee.getEmployeeId();
    }
    public Employee<T> removeEmployee(T employeeId){
        if(employeeId == null){
            throw new IllegalArgumentException("employee Id no not be null");
        }
        return employees.remove(employeeId);
    }
    public Employee<T> updateEmployeeDetails(T employeeId, String field, Object newValue){
        if(employeeId == null) {
            throw new IllegalArgumentException("Employee Id can not be null");
        }
        Employee<T> employee = employees.get(employeeId);
        switch(field.toLowerCase()){
            case "name":
                if (newValue instanceof  String){
                    employee.setName((String)newValue);
                }
                else{
                    throw new IllegalArgumentException("Name must be string");
                }
                break;
            case "department":
                if (newValue instanceof  String){
                    employee.setDepartment((String)newValue);
                }
                else{
                    throw new IllegalArgumentException("Department must be string");
                }
                break;
            case "salary":
                if (newValue instanceof Number){
                    employee.setSalary(((Number)newValue).doubleValue());
                }
                else{
                    throw new IllegalArgumentException("Salary must be of double");
                }
                break;
            case "performancerating":
                if (newValue instanceof Number){
                    employee.setPerformanceRating(((Number)newValue).doubleValue());
                }
                else{
                    throw new IllegalArgumentException("Performance rating must be of double");
                }
                break;
            case "yearsofexperience":
                if (newValue instanceof Number){
                    employee.setYearsOfExperience(((Number)newValue).intValue());
                }
                else{
                    throw new IllegalArgumentException("Years of experience rating must be of double");
                }
                break;
            case "isactive":
                if (newValue instanceof Boolean){
                    employee.setActive((Boolean) newValue);
                }
                else{
                    throw new IllegalArgumentException("isActive must be a boolean value");
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid argument");
        }
        return employee;
    }
    public Collection<Employee<T>> getAllEmployees() {
        return employees.values();
    }
}
