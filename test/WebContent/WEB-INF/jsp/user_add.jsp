<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="ja">
<head>
  <title>従業員の登録画面</title>
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
              <li><a href="/test/LoginHome">ホーム</a></li>
              <li><a href="product-list.html">商品在庫一覧</a></li>
              <li><a href="controled.html">操作履歴</a></li>
          </ul>
      <a class="btn-style" href="login.jsp"><button class="logout-btn">　ログアウト　</button></a>
      </div>
  </nav>
  <div class="wrapper">

    <br><span style="padding-left:20px;">ホーム　＞　従業員の登録</span>

      <br><br><br>
      <h1 style="text-align:center;">従業員登録</h1>
      <div class="user-add-form">
        <form action="/test/RegisterUser" method="post" class="form-group">
          <div class="row">
            <div class="col-sm-2">
              <label style="font-size:20px;">名前</label>
            </div>
            <div class="col-sm-4">
              <input type="text" name="userName" class="form-control" placeholder="名前を入力してください">
            </div>
            <div class="col-sm-3">
              <p style="font-size:20px;">例：管理　四太郎</p>
            </div>
          </div>
          <br>

          <div class="row">
            <div class="col-sm-2">
              <label style="font-size:20px;">ID</label>
            </div>
            <div class="col-sm-4">
              <input type="text" name="userId" class="form-control" placeholder="IDを入力してください">
            </div>
          </div>
          <br>

          <div class="row">
            <div class="col-sm-2">
              <label style="font-size:20px;">パスワード</label>
            </div>
            <div class="col-sm-4">
              <input type="text" name="userPass" class="form-control" placeholder="パスワードを入力してください">
            </div>
          </div>
          <br>

          <div class="row">
            <div class="col-sm-2">
              <label style="font-size:20px; padding-top:3px;">権限設定</label>
            </div>
            <div class="col-sm-2 radio">
              <label><input type="radio" name="permission" value="0" checked="checked">従業員</label>
            </div>
            <div class="col-sm-2 radio">
              <label style="padding-top:15px;"><input type="radio" name="permission" value="1">管理者</label>
            </div>
          </div>
          <br><br><br>

          <input type="submit" value="　登　録　" class="btn btn-primary">
        </form>
      </div>

  </div>



</body>
</html>
