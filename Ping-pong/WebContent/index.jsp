<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ja">
<head>
  <title>在庫管理ログイン画面</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/style.css">
</head>
<body class="login">

  <span class="logo-icon"><img src="img/stock-logo.png" width="150px" height="150px"></span>
  <div class="panel panel-default">
    <form action="/Ping-pong/Login" method="post">
      <div class="form-group">
        <label style="color:#666;">ユーザーID</label>
        <input type="text" name="userid" placeholder="ユーザーIDを入力してください" class="form-control form-border">
      </div>
      <br>
      <div class="form-group">
        <label style="color:#666;">パスワード</label>
        <input type="password" name="pass" placeholder="パスワードを入力してください" class="form-control form-border">
      </div>
      <br><br>
      <input type="submit" class="btn login-btn" value="　ログイン　">
    </form>
    <img src="img/pinpon1.png" width="70" height="70" class="img1">
    <img src="img/pinpon2.png" width="70" height="70" class="img2">
  </div>

  <p class="logo"><span class="logo-inner">powered by </span><img src="img/pinpon.png" width="70" height="70">
    <span class="red">ぴ</span><span class="green">ん</span><span class="blue">ぽ</span><span class="purple">ん</span>
  </p>

</body>
</html>