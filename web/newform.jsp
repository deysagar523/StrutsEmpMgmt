<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.exavalu.services.CountryService"%>
<%@page import="com.exavalu.services.DepartmentService"%>
<%@page import="com.exavalu.services.StateService"%>
<!doctype html>
<html lang="en">
    <head>
        <title>Country Show</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

    </head>

    <body class="text-center">


        <main class="form-signin w-100 m-auto">
            <form action="Login" method="post">
                <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                <c:set var="countryList" value="${CountryService.getAllCountries()}" />

                <div class="filed_style">

                    <select name="countryId" class="form-select" id="countryId" onchange="showStates()">
                        <option value="">---Select a country--</option>

                        <c:forEach items="${countryList}" var="country">
                            <option value="${country.getCountryId()}"> ${country.getCountryName()} </option>
                        </c:forEach>


                    </select>
                </div>
                <script>
                    function showStates() {
                        var x = document.getElementById("countryId").value;


                        console.log(x);
                    <c:set var="stateList" value="${StateService.getAllStates(1)}" />
                    }
                </script>




                <div class="filed_style">

                    <select name="departmentName" class="form-select" id="departmentName">
                        <option value="">--Select a State--</option>

                        <c:forEach items="${stateList}" var="state">
                            <option value="${state.getStateName()}"> ${state.getStateName()} </option>
                        </c:forEach>


                    </select>
                </div>

                <c:set var="departmentList" value="${DepartmentService.getAllDepartment()}" />

                <div class="filed_style">

                    <select name="departmentName" class="form-select" id="departmentName">
                        <option value="">Department</option>

                        <c:forEach items="${departmentList}" var="dept">
                            <option value="${dept.getDepartmentName()}"> ${dept.getDepartmentName()} </option>
                        </c:forEach>


                    </select>
                </div>

                <div class="form-floating">
                    <input name="emailAddress" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required="required">
                    <label for="floatingInput">---select a country---</label>
                </div>
                <div class="form-floating">
                    <input name="emailAddress" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required="required">
                    <label for="floatingInput">---select a state---</label>
                </div>
                <div class="form-floating">
                    <input name="emailAddress" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required="required">
                    <label for="floatingInput">---select a district---</label>
                </div>

                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
                <p class="mt-5 mb-3 text-muted">&copy; 2017?2022</p>
            </form>
        </main>



    </body>
</html>
