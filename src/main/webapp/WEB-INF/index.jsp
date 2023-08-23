<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>じゃんけん入力の画面</title>
</head>
<body>
	<h2>じゃんけんの手を入力してください</h2>

	<form action="JankenServlet2" method="post">
		<label for="gu">グー</label>
		<input id="gu" type="radio" name="janken" value="0" /> <br> 
		<label for="cu">チョキ</label>
		<input id="cu" type="radio" name="janken" value="1" /> <br> 
		<label for="pa">パー</label>
		<input id="pa" type="radio" name="janken" value="2" /> <br>
		 <input type="submit" value="ぽん" />
	</form>

</body>

</html>