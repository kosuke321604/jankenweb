<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん入力の画面</title>
</head>
<body>
<h2>じゃんけんの手を入力してください</h2>

<form action="JankenServlet" meathod="post">
グー<input type="radio" name="janken" value="0" >
<br>
チョキ<input type="radio" name="janken" value="1" >
<br>
パー<input type="radio" name="janken" value="2" >
<br>
<input type="submit" value="ぽん" >
</form>

</body>

</html>