<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Prova accesso GitHub e StackOverflow" %>
</h1>
<br/>
<a href="https://github.com/login/oauth/authorize?client_id=cba2d4eee4f6df798aec&scope=repo">Login with Github</a><br>
<a href="https://stackoverflow.com/oauth?client_id=19786&scope=private_info,no_expiry&redirect_uri=http://localhost:8080/GithubStackOverflowAuthentication_war_exploded/private-stuff-stack">Login with Stack Overflow</a><br>
<a href="http://192.168.1.123:8065" target="_blank">Mattermost</a>
</body>
</html>