/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.exavalu.models;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author LENOVO
 */
public class DepartmentTest {
    
    public DepartmentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setApplication method, of class Department.
     */
    @Test
    public void testSetApplication() {
        System.out.println("setApplication");
        Map<String, Object> application = null;
        Department instance = new Department();
        instance.setApplication(application);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSession method, of class Department.
     */
    @Test
    public void testSetSession() {
        System.out.println("setSession");
        Map<String, Object> session = null;
        Department instance = new Department();
        instance.setSession(session);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartmentId method, of class Department.
     */
    @Test
    public void testGetDepartmentId() {
        System.out.println("getDepartmentId");
        Department instance = new Department();
        int expResult = 0;
        int result = instance.getDepartmentId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartmentId method, of class Department.
     */
    @Test
    public void testSetDepartmentId() {
        System.out.println("setDepartmentId");
        int departmentId = 0;
        Department instance = new Department();
        instance.setDepartmentId(departmentId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDepartmentName method, of class Department.
     */
    @Test
    public void testGetDepartmentName() {
        System.out.println("getDepartmentName");
        Department instance = new Department();
        String expResult = "";
        String result = instance.getDepartmentName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDepartmentName method, of class Department.
     */
    @Test
    public void testSetDepartmentName() {
        System.out.println("setDepartmentName");
        String departmentName = "";
        Department instance = new Department();
        instance.setDepartmentName(departmentName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
