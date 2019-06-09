<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<form:form method = "GET" action = "back">
    <input type = "submit" value = "Powrot"/>
</form:form>
<br />
<c:forEach items="${errors}" var="error">
    ${error.field} : ${error.message}<br />
</c:forEach>