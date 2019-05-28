<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
        modelAttribute="book">
Title: <form:input path="title"/>
Description: <form:textarea path="description" cols="3" rows="20"/>
Publisher: <form:select path="publisher.id">
<form:options items="${publishers}" itemValue="id" itemLabel="id"/>
</form:select>
<input type="submit" value="Zapisz!"/>

 </form:form>