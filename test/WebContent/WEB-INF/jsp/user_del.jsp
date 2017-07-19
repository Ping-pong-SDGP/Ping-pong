<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="model.User,java.util.List" %>
<%
	//リクエストスコープに保存されたつぶやきリストを取得
	List<User> userList = (List<User>) request.getAttribute("userList");
	String permission = "従業員";
%>
<html lang="ja">
<head>
  <title>従業員の削除画面</title>
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
              <li><a href="/LoginHome">ホーム</a></li>
              <li class="active"><a href="#">商品在庫一覧</a></li>
              <li><a href="controled.html">操作履歴</a></li>
          </ul>
      <a class="btn-style" href="/Logout"><button class="logout-btn">　ログアウト　</button></a>
      </div>
  </nav>
  <div class="wrapper">

    <br><span style="padding-left:20px;">ホーム　＞　従業員の削除</span>

      <br><br>
      <div class="sort-area">
        <form action="/SearchUser" method="post" style="margin-bottom:-20px;">
          <p style="font-size:20px;"><span class="fa fa-search" style="color:#3B5998;padding-right:5px;"></span>従業員検索</p>
          <div class="row">
            <div class="col-sm-4">
              <input type="serch" name="userName" placeholder="検索するキーワードを入力してください" class="form-control">
            </div>
            <div class="col-sm-1">
              <button class="btn btn-primary">　検索　</button>
            </div>
          </div>
        </form>
      </div>

      <div class="product-list">
        <table class="table table-hover">
          <thead>
            <tr><th>従業員ID</th><th>従業員名</th><th>権限</th></tr>
          </thead>
          <tbody>

		<% for(User user : userList) {%>
		<%
		if(user.getPermission().equals("1") == true){
			permission="管理者";
		}else{
			permission="従業員";
		}
		%>
		<tr><td><%= user.getId() %></td><td><%= user.getName()%></td><td><%=permission %>

              <td>

                  <form action="/UserDel" method="post" style="padding:0px;">
                    <input type="submit" value="　削　除　" class="btn btn-danger">
                    <input type="hidden" name="userName" value="user.getName()">
                    <input type="hidden" name="userId" value="user.getId()">
                  </form>

              </td>
            </tr>
		<% } %>
          </tbody>
        </table>
      </div>
      <br><br>

  </div>



</body>
</html>