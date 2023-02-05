<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Sign in - Employee Management</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">

    </head>

    <body class="text-center">


        <main class="form-signin w-100 m-auto">
            <form action="Login" method="post">
                <img class="mb-4" src="images/flower-logo.jpg" alt="" width="200" height="200">
                <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

                <c:set var="msg" value="${ErrorMsg}"/>                   
                <c:if test="${msg!=null}">
                    <div class="alert alert-danger msg_style" role="alert">
                        <c:out value="${msg}"/>
                    </div>
                </c:if>
                
                <c:set var="msg1" value="${SuccessMsg}"/>                   
                <c:if test="${msg1!=null}">
                    <div class="alert alert-success msg_style" role="alert">
                        <c:out value="${msg1}"/>
                    </div>
                </c:if>

                <div class="form-floating">
                    <input name="emailAddress" type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required="required">
                    <label for="floatingInput">Email address</label>
                </div>
                <div class="form-floating">
                    <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="Password" required="required">
                    <label for="floatingPassword">Password</label>
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
