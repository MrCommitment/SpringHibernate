<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<h2> Added student </h2>

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
</c:forEach> <br />

Hobbies: <br />
<c:forEach items="${student.hobbies}" var="hobby">
        ${hobby}<br>
</c:forEach>
<br />