<%-- 
    Document   : newLandingPage
    Created on : 14-Feb-2023, 4:17:23 pm
    Author     : LENOVO
--%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Landing Page</title>
    </head>
    
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
    <script>
        function fetchContent(selectedAction, targetId) {
            alert(selectedAction);
            $.ajax({
                url: selectedAction,
                data: {
                    [selectedAction]: $("#" + selectedAction).val()
                },
                success: function (responseText) {
//                                     alert(responseText);
                    $("#" + targetId).html(responseText);
                }
            });
        }
    </script>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>


            <div id="contentBody">
            <c:set var="msg" value="${SuccessMsgForAdd}"/>

            <c:if test="${msg!=null}">
                <div class="alert alert-success msg_style" role="alert">
                    <c:out value="${msg}"/>
                </div>
            </c:if>
            <jsp:include page="bodyForLandingPage.jsp"></jsp:include>
        </div>
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
