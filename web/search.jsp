<%-- 
    Document   : search
    Created on : 24-Jan-2023, 1:11:37 pm
    Author     : RISHAV DUTTA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.exavalu.services.RoleService"%>
<%@page import="com.exavalu.services.DepartmentService"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Search</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/menu_css.css" rel="stylesheet">
        <link href="css/product.css" rel="stylesheet">
        <link rel="stylesheet" href="css/search_css.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"/>
        <style>
            #example_wrapper{
                width: 75%;
                display: block;
                margin: auto;
            }
        </style>
    </head>
    <body>
        
            <h1>Search Employee</h1>
            <form action="SearchEmployees" method="post" class="form_style">
                <div class="filed_style">
                    <label for="floatingInput">First Name</label>
                    <input type="text" class="" id="floatingInput" placeholder="Search FirstName wise" name="firstName">

                </div>
                <div class="filed_style">
                    <label for="floatingInput">Last Name</label>
                    <input type="text" class="" id="floatingInput" placeholder="Search LastName wise" name="lastName" value="">
                </div>
                <div class="filed_style">
                    <label for="floatingInput">Gender</label>
                    <input type="text" class="" id="floatingInput" placeholder="Search Gender wise" name="gender">
                </div>

            <c:set var="departmentList" value="${DepartmentService.getAllDepartment()}" />
            <c:set var="roleList" value="${RoleService.getAllRole()}" />
            <div class="filed_style">

                <select name="departmentName" class="form-select" id="departmentName">
                    <option value="">Department</option>

                    <c:forEach items="${departmentList}" var="dept">
                        <option value="${dept.getDepartmentName()}"> ${dept.getDepartmentName()} </option>
                    </c:forEach>


                </select>
            </div>
            <div class="filed_style">

                <select name="roleName" class="form-select" id="roleName">
                    <option value="">Role</option>

                    <c:forEach items="${roleList}" var="role">
                        <option value="${role.getRoleName()}"> ${role.getRoleName()} </option>
                    </c:forEach>


                </select>
            </div>




            <button class="filed_style" type="submit">Search</button>
        </form>



        <c:set var="empList" value="${sessionScope.SearchEmpList}"/>
        <c:if test="${empList!=null}">
            <table id="example" class="table table-striped border">
                <thead>
                    <tr class="backgroud_colorha">
                        <th>
                            Employee Id
                        </th>
                        <th>
                            First Name
                        </th>
                        <th>
                            Last Name
                        </th>
                        <th>
                            Phone Number
                        </th>
                        <th>
                            Gender
                        </th>
                        <th>
                            Age
                        </th>
                        <th>
                            Department Name
                        </th>
                        <th>
                            Role Name
                        </th>
                        <th>
                            Basic Salary
                        </th>
                        
                        <th>
                            Car Allowance
                        </th>
                        <th>
                            Action
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${empList}" var="emp">
                        <tr>
                            <td>
                                <c:out value="${emp.getEmployeeId()}"/>
                            </td>
                            <th scope="row">
                                <c:out value="${emp.getFirstName()}"/>
                            </th>
                            <th scope="row">
                                <c:out value="${emp.getLastName()}"/>
                            </th>
                            <td>
                                <c:out value="${emp.getPhoneNumber()}"/>
                            </td>
                            <td>
                                <c:out value="${emp.getGender()}"/>
                            </td>
                            <td>
                                <c:out value="${emp.getAge()}"/>
                            </td>
                            <td>
                                <c:out value="${emp.getDepartmentName()}"/>
                            </td>
                            <td>
                                <c:out value="${emp.getRoleName()}"/>
                            </td>
                            <td>
                                <c:out value="${emp.getBasicSalary()}"/>
                            </td>
                            
                            <td>
                                <c:out value="${emp.getCarAllowance()}"/>
                            </td>
                            <td> 
                                <a href=EditEmployee?id=${emp.getEmployeeId()}>
                                    Edit</a>                     
                            </td>
                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </c:if>


    </body>
</html>
