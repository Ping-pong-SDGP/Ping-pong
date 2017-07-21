<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import =  "model.User" %>
<% User user = (User) session.getAttribute("deluser");
   String name = user.getName();
   String id = user.getId();
   String permission = user.getPermission();
   String permissionName = "従業員";
   if(permission.equals("1") == true){
	   permissionName = "管理者";
   }
%>
<html lang="ja">
<head>
  <title>入力内容確認画面</title>
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
              <li><a href="product-list.html">商品在庫一覧</a></li>
              <li><a href="/Ping-pong/LogAll">操作履歴</a></li>
          </ul>
      <a class="btn-style" href="index.jsp"><button class="logout-btn">　ログアウト　</button></a>
      </div>
  </nav>
  <div class="wrapper">

    <br><span style="padding-left:20px;">ホーム　＞　従業員の削除　＞　入力内容確認</span>

      <br><br><br>
      <h1 style="text-align:center;">下記従業員を削除してよろしいですか。</h1>
      <br><br>

      <div>
        <div class="row">
          <div class="col-sm-5" style="text-align:right;">
            <label style="font-size:20px;">従業員ID：<%=id %></label>
          </div>
          <div class="col-sm-4">
            <p style="font-size:20px; padding-top:3px;"></p>
          </div>
        </div>

        <div class="row">
          <div class="col-sm-5" style="text-align:right;">
            <label style="font-size:20px;">従業員名：<%=name %></label>
          </div>
          <div class="col-sm-4">
            <p style="font-size:20px; padding-top:3px;"></p>
          </div>
        </div>

        <div class="row">
          <div class="col-sm-5" style="text-align:right;">
            <label style="font-size:20px;">権限：<%=permissionName %></label>
          </div>
          <div class="col-sm-4">
            <p style="font-size:20px; padding-top:3px;"></p>
          </div>
        </div>

      </div>
      <br><br><br>

      <a href="/Ping-pong/UserDelCompletion"><button class="btn btn-primary">　削　除　</button></a>
      <br><br><br>

  </div>



</body>
</html>
