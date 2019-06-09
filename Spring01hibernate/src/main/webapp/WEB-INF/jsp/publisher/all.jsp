<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1> Wszyscy wydawcy </h1>

<br />

<form:form method = "GET" action = "add">
    <input type = "submit" value = "Dodaj wydawce"/>
</form:form>
<form:form method = "GET" action = "home">
    <input type = "submit" value = "Ekran glowny"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
    <form:input path="nipSearch" />
    <input type="hidden" value="nip" name="searchMode"/>
    <input type = "submit" value = "Szukaj po NIP"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
    <form:input path="regonSearch" />
    <input type="hidden" value="regon" name="searchMode"/>
    <input type = "submit" value = "Szukaj po REGON"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
    <input type="hidden" value="all" name="searchMode"/>
    <input type = "submit" value = "Pokaz wszystkich"/>
</form:form>


<br />

<c:forEach items="${allPublishers}" var="publisher">
    <b>Nazwa:</b> ${publisher.name} <br />
    <b>NIP:</b> ${publisher.nip} <br />
    <b>REGON:</b> ${publisher.regon} <br />
    <form:form method = "post" modelAttribute="viewMode">
        <input type="hidden" value="remove" name="mode"/>
        <input type="hidden" value="${publisher.id}" name="objectId"/>
        <input type = "submit" value = "Usun wydawce"/>
    </form:form>
    <form:form method = "post" modelAttribute="viewMode">
        <input type="hidden" value="edit" name="mode"/>
        <input type="hidden" value="${publisher.id}" name="objectId"/>
        <input type = "submit" value = "Edytuj wydawce"/>
    </form:form>
    <br />
</c:forEach> <br />