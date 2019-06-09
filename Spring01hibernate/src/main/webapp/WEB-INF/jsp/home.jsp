<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>

<form:form method="post"
modelAttribute="homeContext">
    <input type="hidden" value="student" name="redirectPage"/>
    <input type="submit" value="Dodaj studenta (bez zapisania do bazy)">
</form:form>
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="validator" name="redirectPage"/>
    <input type="submit" value="Tester walidacji">
</form:form>
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="person" name="redirectPage"/>
    <input type="submit" value="Person CRUD">
</form:form>
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="publisher" name="redirectPage"/>
    <input type="submit" value="Wydawca CRUD">
</form:form>
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="author" name="redirectPage"/>
    <input type="submit" value="Autor CRUD">
</form:form>
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="book" name="redirectPage"/>
    <input type="submit" value="Ksiazki CRUD">
</form:form>
<form:form method="post"
           modelAttribute="homeContext">
    <input type="hidden" value="proposition" name="redirectPage"/>
    <input type="submit" value="Propozycje CRUD">
</form:form>