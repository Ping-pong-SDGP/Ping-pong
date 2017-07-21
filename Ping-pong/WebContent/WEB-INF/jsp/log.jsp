<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Log,java.util.List" %>
<%
	//リクエストスコープに保存されたつぶやきリストを取得
	List<Log> logList = (List<Log>) request.getAttribute("logList");
%>
    <html lang="ja">
<head>
  <title>操作履歴一覧画面</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body>

  <nav class="navbar navbar-default">
      <div class="container">
          <div class="navbar-header">
              <a class="navbar-brand">在庫管理システム</a>
          </div>
          <ul class="nav navbar-nav">
              <li><a href="/Ping-pong/LoginHome">ホーム</a></li>
              <li><a href="/Ping-pong/LogAll">商品在庫一覧</a></li>
              <li class="active"><a href="#">操作履歴</a></li>
          </ul>
      <a class="btn-style" href="index.jsp"><button class="logout-btn">　ログアウト　</button></a>
      </div>
  </nav>
  <div class="wrapper">

      <br><br>
      <div class="controled">
        <table class="table table-hover">
          <thead>
            <tr><th>日時</th><th>操作内容</th><th>商品名</th><th>ユーザー名</th></tr>
          </thead>
          <% for(Log log : logList) {%>
          	<% if(log.getOpName().startsWith("ユーザー")){ %>
          <tbody>
            <tr><td><%=log.getTime() %></td><td><%=log.getOpName() %></td><td>　　　</td><td><%=log.getUserName() %></td></tr>
          </tbody>
          	<% }else{%>
          <tbody>
            <tr><td><%=log.getTime() %></td><td><%=log.getOpName() %></td><td><%=log.getPrName() %></td><td><%=log.getUserName() %></td></tr>
          </tbody>
          	<% } %>
          <%} %>
        </table>
      </div>
      <br><br>

  </div>



</body>
</html>
