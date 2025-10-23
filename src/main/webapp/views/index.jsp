<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tricol - Gestion des fournisseurs</title>
</head>
<body>
<h1>Bienvenue chez Tricol - Gestion des fournisseurs</h1>
<ul>
    <li><a href="${pageContext.request.contextPath}/fournisseurs">Liste des fournisseurs</a></li>
    <li><a href="${pageContext.request.contextPath}/api/v1/fournisseurs">API REST (JSON)</a></li>
</ul>
</body>
</html>
