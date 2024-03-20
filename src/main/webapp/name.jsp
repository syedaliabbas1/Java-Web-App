<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Name Information</title>
</head>
<body>
<h1>Name Information</h1>

<%-- Display any error message --%>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<%-- Display the first name, last name, and age --%>
<c:if test="${empty error}">
    <p>First Name: ${person.firstName}</p>
    <p>Last Name: ${person.lastName}</p>
    <p>Age: ${person.age}</p>
</c:if>
</body>
</html>
