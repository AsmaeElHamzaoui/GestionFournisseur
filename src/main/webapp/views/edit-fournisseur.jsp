<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Éditer Fournisseur</title>
</head>
<body>
<h2>Éditer le fournisseur</h2>

<form:form modelAttribute="fournisseur" method="post" action="${pageContext.request.contextPath}/fournisseurs/edit/${fournisseur.id}">
    <table>
        <tr><td>Société:</td><td><form:input path="societe"/></td></tr>
        <tr><td>Adresse:</td><td><form:input path="adresse"/></td></tr>
        <tr><td>Contact:</td><td><form:input path="contact"/></td></tr>
        <tr><td>Email:</td><td><form:input path="email"/></td></tr>
        <tr><td>Téléphone:</td><td><form:input path="telephone"/></td></tr>
        <tr><td>Ville:</td><td><form:input path="ville"/></td></tr>
        <tr><td>ICE:</td><td><form:input path="ice"/></td></tr>
        <tr><td colspan="2"><button type="submit">Mettre à jour</button></td></tr>
    </table>
</form:form>

<p><a href="${pageContext.request.contextPath}/fournisseurs">Retour</a></p>
</body>
</html>
