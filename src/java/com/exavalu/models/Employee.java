/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;

import com.exavalu.services.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class Employee extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String gender;
    private String age;
    private String departmentId;
    private String roleId;
    private String basicSalary;
    private String carAllowance;
    private String specialAllowance;
    private String departmentName;
    private String roleName;

    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }

    public String addEmployee() throws Exception {
        String result = "FAILURE";

        boolean success = EmployeeService.getInstance().addEmployee(this);

        if (success) {
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();

            String successMsg = "One Employee Added Successfully";

            sessionMap.put("EmpList", empList);
            sessionMap.put("SuccessMsgForAdd", successMsg);

            result = "SUCCESS";
        } else {
            String errorMsg = "You did not select gender or deparatment or role coorectly";

            sessionMap.put("ErrorMsg", errorMsg);

        }

        return result;
    }

    public String searchEmployees() throws Exception {
        String result = "SUCCESS";

        ArrayList empList = EmployeeService.getInstance().searchEmployees(this);
        sessionMap.put("SearchEmpList", empList);

        return result;
    }

    public String doEditEmployee() throws Exception {
        Employee emp = EmployeeService.getInstance().getEmployee(this.employeeId);
        ArrayList deptList = DepartmentService.getAllDepartment();
        ArrayList roleList = RoleService.getAllRole();

        sessionMap.put("Emp", emp);
        sessionMap.put("DeptList", deptList);
        sessionMap.put("RoleList", roleList);

        return "SUCCESS";
    }

    public String SaveUpdatedEmployee() throws Exception {
        String result = "FAILURE";
        boolean success = EmployeeService.getInstance().updateEmployee(this, this.employeeId);
        
        if (success) {
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("EmpList", empList);
            result = "SUCCESS";
        }
       return result;

    }
    
     public String getAllEmployees() throws Exception {
        String result = "SHOW";
        ArrayList empList = EmployeeService.getInstance().getAllEmployees();
//        System.out.println("get all employees ="+empList.size());
        sessionMap.put("EmpList", empList);
        return result;
       

    }
     
   

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the departmentId
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the basicSalary
     */
    public String getBasicSalary() {
        return basicSalary;
    }

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

    /**
     * @return the carAllaowance
     */
    public String getCarAllowance() {
        return carAllowance;
    }

    /**
     * @param carAllaowance the carAllaowance to set
     */
    public void setCarAllowance(String carAllowance) {
        this.carAllowance = carAllowance;
    }

    /**
     * @return the specialAllowance
     */
    public String getSpecialAllowance() {
        return specialAllowance;
    }

    /**
     * @param specialAllowance the specialAllowance to set
     */
    public void setSpecialAllowance(String specialAllowance) {
        this.specialAllowance = specialAllowance;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName the roleName to set
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

}
