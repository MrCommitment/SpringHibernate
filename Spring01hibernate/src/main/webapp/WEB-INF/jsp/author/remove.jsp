<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<h2>Czy na pewno chcesz usunac tego autora?</h2>

<form:form method="post"
           modelAttribute="author">
    Imie: <form:input disabled="true" path="firstName"/><br />
    Nazwisko: <form:input disabled="true" path="lastName"/> <br />
    PESEL: <form:input disabled="true" path="pesel"/> <br />
    Email: <form:input disabled="true" path="email" /> <br />
    <form:hidden path="id"/>
    <input type="submit" value="Usun!"/>

</form:form>