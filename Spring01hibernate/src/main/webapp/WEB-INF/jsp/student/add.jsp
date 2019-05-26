<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
            modelAttribute="newStudent">
    First name: <form:input path="firstName" /> <br />
    Last name: <form:input path="lastName" /> <br />

    Male: <form:radiobutton path="gender" value="M"/> <br />
    Female: <form:radiobutton path="gender" value="F"/> <br />


    Country:
    <form:select path="country">
          <form:option value="-" label="Please Select Country"/>
          <form:options items="${countries}"/>
    </form:select> <br />

    Notes: <form:textarea path="notes" rows="3" cols="20"/> <br />

    Mailing list: <form:checkbox path="mailingList"/> <br />

    Programming skills: <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/> <br />

    Hobbies: <form:select path="hobbies" items="${hobbies}" multiple="true"/> <br />

    <input type="submit" value="Add Student"/>

</form:form>
