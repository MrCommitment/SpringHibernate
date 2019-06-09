<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
        modelAttribute="book">
Title: <form:input path="title"/>
 <form:errors path="title"/> <br />
 Pages: <form:input path="pages"/>
 <form:errors path="pages"/> <br />
 Rating: <form:input path="rating"/>
 <form:errors path="rating" /> <br />
Description: <form:textarea path="description" cols="3" rows="20"/>
 <form:errors path="description"/> <br />
Publisher: <form:select path="publisher.id">
<form:options items="${publishers}" itemValue="id" itemLabel="name"/>
</form:select>
 <form:errors path="publisher" /> <br />
 Autorzy: <form:select path="authors" multiple="true">
 <form:options items="${allAuthors}" itemLabel="fullName" itemValue="id"/>
</form:select>
 <form:errors path="authors" />

 Kategorie: <form:select path="category.id">
 <form:options items="${allCategories}" itemLabel="name" itemValue="id"/>
</form:select>


<br />
 <form:hidden path="id"/>

<input type="submit" value="Zapisz!"/>

 </form:form>