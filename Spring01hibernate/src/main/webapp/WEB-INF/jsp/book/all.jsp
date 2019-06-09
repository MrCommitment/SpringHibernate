<%@ taglib prefix="form"
                              uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1> Wszystkie ksiazki </h1>

<br />

<form:form method = "GET" action = "add">
        <input type = "submit" value = "Dodaj ksiazke"/>
</form:form>
<form:form method = "GET" action = "home">
        <input type = "submit" value = "Ekran glowny"/>
</form:form>

<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
        <form:select path="categorySearch.id">
                <form:options items="${allCategories}" itemLabel="name" itemValue="id"/>
        </form:select>
        <input type="hidden" value="category" name="searchMode"/>
        <input type = "submit" value = "Szukaj po kategorii"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
        <form:select path="publisherSearch.id">
                <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
        </form:select>
        <input type="hidden" value="publisher" name="searchMode"/>
        <input type = "submit" value = "Szukaj po wydawcy"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
        <form:input path="titleSearch" />
        <input type="hidden" value="title" name="searchMode"/>
        <input type = "submit" value = "Szukaj po tytule"/>
</form:form>
<form:form method = "GET" action = "all"
           modelAttribute="viewMode">
        <input type="hidden" value="all" name="searchMode"/>
        <input type = "submit" value = "Pokaz wszystkich"/>
</form:form>
<form:form method = "post"
           modelAttribute="viewMode">
        <form:input path="resetRating" />
        <input type="hidden" value="resetRating" name="mode"/>
        <input type = "submit" value = "Ustaw rating wszystkim"/>
</form:form>


<c:forEach items="${allBooks}" var="book">
        <b>Tytul:</b> ${book.title} <br />
        <b>Opis:</b> ${book.description} <br />
        <b>Strony:</b> ${book.pages} <br />
        <b>Ocena:</b> ${book.rating} <br />
        <b>Wydawca:</b> ${book.publisher.name} <br />
        <form:form method = "post" modelAttribute="viewMode">
                <input type="hidden" value="remove" name="mode"/>
                <input type="hidden" value="${book.id}" name="objectId"/>
                <input type = "submit" value = "Usun ksiazke"/>
        </form:form>
        <form:form method = "post" modelAttribute="viewMode">
                <input type="hidden" value="edit" name="mode"/>
                <input type="hidden" value="${book.id}" name="objectId"/>
                <input type = "submit" value = "Edytuj ksiazke"/>
        </form:form>
        <br />
</c:forEach> <br />