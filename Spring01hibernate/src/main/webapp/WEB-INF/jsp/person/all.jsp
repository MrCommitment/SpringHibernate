<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1> Wszystkie osoby </h1>

<br />

<form:form method = "GET" action = "add">
    <input type = "submit" value = "Dodaj osobe"/>
</form:form>
<form:form method = "GET" action = "home">
    <input type = "submit" value = "Ekran glowny"/>
</form:form>


<br />

<c:forEach items="${allPersons}" var="person">
    <b>Login:</b> ${person.login} <br />
    <b>Email:</b> ${person.email} <br />
    <b>First name:</b> ${person.personDetails.firstName}
    <b>Last name:</b> ${person.personDetails.lastName}
    <form:form method = "post" modelAttribute="viewMode">
        <input type="hidden" value="remove" name="mode"/>
        <input type="hidden" value="${person.id}" name="objectId"/>
        <input type = "submit" value = "Usun osobe"/>
    </form:form>
    <form:form method = "post" modelAttribute="viewMode">
        <input type="hidden" value="edit" name="mode"/>
        <input type="hidden" value="${person.id}" name="objectId"/>
        <input type = "submit" value = "Edytuj osobe"/>
    </form:form>
    <br />
</c:forEach> <br />