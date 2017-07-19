<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html lang="ja">
<head>
  <title>管理者ホーム画面</title>
  <meta charset="utf-8">
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
</head>
<body>

  <nav class="navbar navbar-default">
      <div class="container">
          <div class="navbar-header">
              <a class="navbar-brand">在庫管理システム</a>
          </div>
          <ul class="nav navbar-nav">
              <li class="active"><a href="/LoginHome">ホーム</a></li>
              <li><a href="product-list.html">商品在庫一覧</a></li>
              <li><a href="controled.html">操作履歴</a></li>
          </ul>
      <a class="btn-style" href="/Logout"><button class="logout-btn">　ログアウト　</button></a>
      </div>
  </nav>
  <div class="wrapper">

      <br><br>

      <div class="stock">
        <label class="host-label"><span class="fa fa-archive" style="color:#3B5998;padding-right:5px;"></span>在庫の管理</label>
        <a class="btn-style" href="" style="margin-top:0px;"><button class="btn btn-primary">　編集　</button></a>
        <span style="font-size:15px;"><p>在庫の管理をします。</p></span>
        <hr>
      </div>
      <br><br>

  </div>



</body>
</html>