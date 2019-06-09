<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
           modelAttribute="person">
    Login: <form:input path="login"/><br />
    Password: <form:password path="password"/> <br/>
    Email: <form:input path="email"/> <br />
    First name: <form:input path="personDetails.firstName"/> <br />
    Last name: <form:input path="personDetails.lastName" /> <br />
    Street number: <form:input path="personDetails.streetNumber" /> <br />
    Street: <form:input path="personDetails.street" /> <br />
    City: <form:input path="personDetails.city" /> <br />
    <form:hidden path="id"/>
    <form:hidden path="personDetails.id"/>
    <input type="submit" value="Zapisz!"/>
</form:form>