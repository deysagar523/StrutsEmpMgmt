<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<option value="">---Select a District--</option>


<c:forEach items="${DistList}" var="dist">
    <option value="${dist.getDistCode()}"
            <c:if test="${dist.getDistCode() == User.getDistCode()}">
        selected 
        </c:if>>

        ${dist.getDistName()} 
    </option>
</c:forEach>
