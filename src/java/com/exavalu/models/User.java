/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.EmployeeService;

import com.exavalu.services.UserService;
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
 * @author LENOVO
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {

    private String emailAddress, password, firstName, lastName;
    private int status;

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

    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = UserService.getInstance().doLogin(this);

        if (success) {
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            User user = UserService.getInstance().getUser(this.emailAddress);
            sessionMap.put("USER", user);
            sessionMap.put("EmpList", empList);
            sessionMap.put("Loggedin", this);
            sessionMap.put("User", user);
            System.out.println("returning Success from doLogin method");
            System.out.println("logging in");
            result = "SUCCESS";
        } else {
            System.out.println("returning Failure from doLogin method");
            String errorMsg = "Either EmailAddress or Password is wrong";
            sessionMap.put("ErrorMsg", errorMsg);
        }

        return result;
    }

    public String doLogout() throws Exception {
        String result = "SUCCESS";

        System.out.println("logging out");
        sessionMap.clear();
        return result;
    }

    public String doSignup() throws Exception {
        String result = "FAILURE";
        boolean success = UserService.getInstance().doSignup(this);
        if (success) {
            result = "SUCCESS";
            String successMsg = "Account Created,Now Login to your Account";

            sessionMap.put("SuccessMsg", successMsg);

        } else {
            String errorMsg = "This Email is already registered..Try with another Email";

            sessionMap.put("ErrorMsg", errorMsg);
        }
        return result;
    }

    /**
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

}
