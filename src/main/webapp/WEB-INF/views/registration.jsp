<%--
  Created by IntelliJ IDEA.
  User: Lesha Naumenko
  Date: 31.12.2016
  Time: 2:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shop</title>
    <style type="text/css">
        body {font-size:14px;}
        label {float:left; padding-right:10px;}
        .field {clear:both; text-align:right; line-height:25px;}
        .main {float:left;}
        .main{
        }
    </style>
</head>
<body>

<h1>Реєстрація </h1>
<form method="post" action="registration">
    <div class="main">
        <div class="field">
            <label >First name:</label>
            <input type="text" name="firstName" />
        </div>
        <div class="field">
            <label >Last name:</label>
            <input type="text" name="lastName" />
        </div>
        <div class="field">
            <label >Login:</label>
            <input type="text" name="login" />
        </div>
        <div class="field">
            <label >Password:</label>
            <input type="password" name="password" />
        </div>
        <div class="field">
            <label >Phone number:</label>
            <input type="text" name="phoneNumber" />
        </div>
        <div class="field">
            <input type="submit" value="Send">
        </div>
    </div>
</form>
</body>
</html>
