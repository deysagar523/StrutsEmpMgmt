<%-- 
    Document   : landingPage
    Created on : 22-Dec-2022, 12:00:33 PM
    Author     : Avijit Chattopadhyay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <!--        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <!--        <link rel="stylesheet" href="css/all.min.css">-->
        <!--        <link rel="stylesheet" href="css/reset-min.css">-->
        <!--        <link rel="stylesheet" href="css/algolia-min.css">
                <link rel="stylesheet" href="css/header.css">
                <link rel="stylesheet" href="css/docs.min.css">
                <link rel="stylesheet" href="css/index.css">-->
        <title>Employee Management</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.2.0/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap5.min.css"/>

        <style>
            #example_wrapper{
                width: 75%;
                display: block;
                margin: auto;
            }
            h2{
                text-align: center;
            }
            .msg_style{
                width: 25%;
                text-align: center;
                margin: auto;
            }
        </style>    
    </head>
    <body>
        
            <h2> :Employee List:</h2>
        
        <table id="example" class="table table-striped border" >
            <thead>
                <tr class="table-striped table-primary">
                    <th>Employee Id</th>
                    <th>Employee Name</th>
                    <th>Phone</th>
                    <th>Gender</th>
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
                        Special Allowance
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
                <c:forEach items="${EmpList}" var="emp">
                    <tr data-index="0">
                        <td><c:out value="${emp.employeeId}"> </c:out></td>
                        <td><c:out value="${emp.firstName}"> </c:out> <c:out value="${emp.lastName}"> </c:out></td>
                        <td><c:out value="${emp.phoneNumber}"> </c:out></td>
                        <td><c:out value="${emp.gender}"> </c:out></td>
                        <td><c:out value="${emp.age}"> </c:out></td>
                        <td><c:out value="${emp.departmentName}"> </c:out></td>
                        <td><c:out value="${emp.roleName}"> </c:out></td>
                        <td><c:out value="${emp.basicSalary}"> </c:out></td>
                        <td><c:out value="${emp.specialAllowance}"> </c:out></td>
                        <td><c:out value="${emp.carAllowance}"> </c:out></td>
                            <td> 
                                <a href=EditEmployee?employeeId=${emp.employeeId}>
                                Edit
                            </a>                     
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
        <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap5.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#example').DataTable();
            });
        </script>
    </body>

</html>
