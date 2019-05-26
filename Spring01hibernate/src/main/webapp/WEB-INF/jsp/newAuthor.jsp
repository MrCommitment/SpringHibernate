<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
           modelAttribute="author">
    First name: <form:input path="firstName" /> <br>
    Last name: <form:input path="lastName" /> <br>
    <input type="submit" value="Submit">
</form:form>