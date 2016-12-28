<%--
  Created by IntelliJ IDEA.
  User: Lesha Naumenko
  Date: 28.12.2016
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Вхід</title>
    <style type="text/css">
        body {font-size:14px;}
        label {float:left; padding-right:10px;}
        .field {clear:both; text-align:right; line-height:25px;}
        .main {float:left;}
    </style>
</head>
<body>

<h1>Вхід </h1>
<form method="post" action="entrance">
    <div class="main">
        <div class="field">
            <label for="name">Name:</label>
            <input type="text" name="name" />
        </div>
    </div>
</form>
<br/>

<div class="field">

    <a href="SpringRegistration.jsp">Реєстрація</a>
</div>
</body>
</html>
