<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<h2>Czy na pewno chcesz usunac tego osobnika?</h2>

<form:form method="post"
           modelAttribute="person">
    Login: <form:input disabled="true" path="login"/><br />
    Email: <form:input disabled="true" path="email"/> <br />
    <form:hidden path="id"/>
    <input type="submit" value="Usun!"/>

</form:form>