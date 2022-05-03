<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="ru.gb.lesson_4.model.Product"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product List:</h1>
<form:form action="search" modelAttribute="findProduct">
Find: <form:input path="id" />
<input type="submit" value="Search">
</form:form>
<ul>
   <c:forEach var="product" items="${products}">
        <c:url var="editUrl" value="/${product.id}"/>
        <c:url var="deleteUrl" value="/${product.id}?delete=true"/>
            <li>
                    ID: ${product.id}
                    Title: ${product.title}
                    Price: ${product.price}
                    <a href="${editUrl}">EDIT</a>
                    <a href="${deleteUrl}">DELETE</a>
            </li>
   </c:forEach>
</ul>
<br>
<c:url var="createUrl" value="/create"/>

<a href="${createUrl}">ADD</a>
<br>




</body>
</html>