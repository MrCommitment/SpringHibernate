<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1> Wszyscy autorzy </h1>

<br />

<form:form method = "GET" action = "add">
    <input type = "submit" value = "Dodaj autora"/>
</form:form>
<form:form method = "GET" action = "home">
    <input type = "submit" value = "Ekran glowny"/>
</form:form>
<form:form method = "GET" action = "all"
    modelAttribute="viewMode">
    <form:input path="emailSearch" />
    <input type="hidden" value="email" name="searchMode"/>
    <input type = "submit" value = "Szukaj po emailu"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
    <form:input path="peselSearch" />
    <input type="hidden" value="pesel" name="searchMode"/>
    <input type = "submit" value = "Szukaj po PESEL"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
    <form:input path="lastNameSearch" />
    <input type="hidden" value="lastName" name="searchMode"/>
    <input type = "submit" value = "Szukaj po nazwisku"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
    <input type="hidden" value="all" name="searchMode"/>
    <input type = "submit" value = "Pokaz wszystkich"/>
</form:form>

<br />

<c:forEach items="${allAuthors}" var="author">
    <b>PESEL:</b> ${author.pesel} <br />
    <b>Email:</b> ${author.email} <br />
    <b>Imie:</b> ${author.firstName}
    <b>Nazwisko:</b> ${author.lastName}
    <form:form method = "post" modelAttribute="viewMode">
        <input type="hidden" value="remove" name="mode"/>
        <input type="hidden" value="${author.id}" name="objectId"/>
        <input type = "submit" value = "Usun autora"/>
    </form:form>
    <form:form method = "post" modelAttribute="viewMode">
        <input type="hidden" value="edit" name="mode"/>
        <input type="hidden" value="${author.id}" name="objectId"/>
        <input type = "submit" value = "Edytuj autora"/>
    </form:form>
    <br />
</c:forEach> <br />