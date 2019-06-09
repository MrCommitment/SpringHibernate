<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fomr" uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
           modelAttribute="publisher">
    Nazwa: <form:input path="name"/>
    <form:errors path="name" /> <br />
    NIP: <form:input path="nip"/>
    <form:errors path="nip"/> <br/>
    REGON: <form:input path="regon"/>
    <form:errors path="regon"/><br />
    <fomr:hidden path="id"/>
    <input type="submit" value="Zapisz!"/>
</form:form>