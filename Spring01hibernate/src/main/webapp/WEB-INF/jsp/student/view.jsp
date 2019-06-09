<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<h2> Dodany student </h2>

<form:form method = "GET" action = "home">
    <input type = "submit" value = "Ekran glowny"/>
</form:form>

First name: ${student.firstName} <br />
Last name: ${student.lastName} <br />

Gender: ${student.gender} <br />
Country: ${student.country} <br />

Notes: ${student.notes} <br />
Mailing list:
<c:choose>
    <c:when test="${student.mailingList}">
        YES
        <br />
    </c:when>
    <c:otherwise>
        NO
        <br />
    </c:otherwise>
</c:choose>

Programming skills: <br />
<c:forEach items="${student.programmingSkills}" var="skills">
        ${skills}<br />
</c:forEach>

Hobbies: <br />
<c:forEach items="${student.hobbies}" var="hobby">
        ${hobby}<br>
</c:forEach>