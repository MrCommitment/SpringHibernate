<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<h2>Czy na pewno chcesz usunac ta ksiazke?</h2>

<form:form method="post"
           modelAttribute="book">
    Tytul: <form:input disabled="true" path="title"/><br />
    Opis: <form:input disabled="true" path="description"/> <br />
    <form:hidden path="id"/>
    <input type="submit" value="Usun!"/>

</form:form>