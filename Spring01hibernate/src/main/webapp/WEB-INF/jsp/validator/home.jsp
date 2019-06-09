<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<form:form method = "GET" action = "backHome">
    <input type = "submit" value = "Ekran glowny"/>
</form:form>
<br />
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="book" name="redirectPage"/>
    <input type="submit" value="Przetestuj walidatory na ksiazce">
</form:form>
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="author" name="redirectPage"/>
    <input type="submit" value="Przetestuj walidatory na autorze">
</form:form>
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="publisher" name="redirectPage"/>
    <input type="submit" value="Przetestuj walidatory na wydawcy">
</form:form>