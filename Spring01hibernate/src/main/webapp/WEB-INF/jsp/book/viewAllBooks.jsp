<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1> Wszystkie książki </h1>

<br />

<c:forEach items="${allBooks}" var="book">
        <b>Tytuł:</b> ${book.title} <br />
        <b>Opis:</b> ${book.description} <br />
        <b>Wydawca:</b> ${book.publisher.name} <br />
        <br />
        <br />
</c:forEach> <br />