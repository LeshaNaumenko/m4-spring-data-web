<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lesha Naumenko
  Date: 23.11.2016
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

<form action="checkout" method="post">
    <c:forEach items ="${products}" var = "prod">
        <input type="checkbox" name="favoriteProduct"  value="${prod.id}">${prod.id}  ${prod.name}<br>
    </c:forEach>
    <c:if test="${existSession eq 1}">
        <input type="submit" value="Send" >
    </c:if>
</form>
<c:if test="${existSession eq 1}">
    <a href="leave_the_session">Вихід</a>
</c:if>


</body>
</html>
