<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<h2>Czy na pewno chcesz usunac tego wydawce?</h2>

<form:form method="post"
           modelAttribute="publisher">
    Nazwa: <form:input disabled="true" path="name"/><br />
    NIP: <form:input disabled="true" path="nip"/> <br />
    REGON: <form:input disabled="true" path="regon"/> <br />
    <form:hidden path="id"/>
    <input type="submit" value="Usun!"/>

</form:form>