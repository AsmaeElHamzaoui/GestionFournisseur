<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des fournisseurs</title>
</head>
<body>
<h2>Fournisseurs</h2>

<form method="get" action="${pageContext.request.contextPath}/fournisseurs">
    <input type="text" name="q" placeholder="Rechercher par société" value="${q != null ? q : ''}" />
    <button type="submit">Rechercher</button>
    <a href="${pageContext.request.contextPath}/fournisseurs">Réinitialiser</a>
</form>

<p><a href="${pageContext.request.contextPath}/fournisseurs/add">Ajouter un fournisseur</a></p>

<table border="1" cellpadding="6" cellspacing="0">
    <thead>
    <tr>
        <th>Société</th>
        <th>Contact</th>
        <th>Email</th>
        <th>Téléphone</th>
        <th>Ville</th>
        <th>ICE</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="f" items="${fournisseurs}">
        <tr>
            <td><c:out value="${f.societe}"/></td>
            <td><c:out value="${f.contact}"/></td>
            <td><c:out value="${f.email}"/></td>
            <td><c:out value="${f.telephone}"/></td>
            <td><c:out value="${f.ville}"/></td>
            <td><c:out value="${f.ice}"/></td>
            <td>
                <a href="${pageContext.request.contextPath}/fournisseurs/edit/${f.id}">Edit</a>
                <form action="${pageContext.request.contextPath}/fournisseurs/delete/${f.id}" method="post" style="display:inline" onsubmit="return confirm('Supprimer ce fournisseur ?');">
                    <button type="submit">Supprimer</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><a href="${pageContext.request.contextPath}/">Retour</a></p>
</body>
</html>
