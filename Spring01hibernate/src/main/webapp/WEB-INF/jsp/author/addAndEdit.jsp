<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
           modelAttribute="author">
    Imie: <form:input path="firstName"/>
    <form:errors path="firstName"/> <br />
    Nazwisko: <form:input path="lastName"/>
    <form:errors path="lastName" /> <br/>
    Rok urodzenia: <form:input path="yearOfBirth"/>
    <form:errors path="yearOfBirth"/> <br />
    PESEL: <form:input path="pesel"/>
    <form:errors path="pesel" /> <br />
    Email: <form:input path="email" />
    <form:errors path="email" /> <br />
    <fomr:hidden path="id"/>
    <input type="submit" value="Zapisz!"/>
</form:form>