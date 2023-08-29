<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="homework.JankenBean"%>

<% 
List<JankenBean> jankenList = (List<JankenBean>) request.getAttribute("jankenList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけんの結果</title>
</head>
<body>
<h1>じゃんけんのこれまでの結果は以下です。</h1>
<ul>
<% for(JankenBean a:jankenList){ %>
   <li> 自分の手は<%= a.getMyselfResultName() %>です,PCの手は<%=a.getPcResultName() %>です,勝敗は<%= a.getResult() %>です
   
<form action="JankenServlet2" method="get">
<input type="hidden" name="paramemo" value="done">
<input type="text" name="memo"value="<%= a.getMemo() %>" ></input> <input type="submit" value="保存" />
</form>
</li><% } %>

</ul>

<a href="JankenServlet2">もう一回</a>
</body>

</html>