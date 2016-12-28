<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
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
            <label for="lgInput">Login:</label>
            <input type="text" name="lgInput" />
        </div>
        <div class="field">
            <label for="psInput">Password:</label>
            <input type="password" name="psInput" />
        </div>
        <div class="field">
            <input type="submit" value="Send">
        </div>

        <div class="field">
            <a href="reg.html">Реєстрація</a>
        </div>
    </div>
</form>
<br/>
<h3 style="color: red">${message}</h3>
</body>
</html>
