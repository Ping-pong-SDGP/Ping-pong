package servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetUserListLogic;
import model.Log;
import model.PostUserLogLogic;
import model.PostUserLogic;
import model.User;

@WebServlet("/UserAdd")
public class UserAdd extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {


		//データベースから読み出しリクエストに保存
		GetUserListLogic getUser = new GetUserListLogic();
		List<User> list = getUser.execute();
		request.setAttribute("userList", list);


		// ログインしているか確認するため
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser == null) { // ログインしていない場合
			// リダイレクト
			response.sendRedirect("/login.jsp");
		} else { // ログイン済みの場合
		// フォワード

			request.setCharacterEncoding("UTF-8");

			User user = (User) session.getAttribute("kaluser");
			String name = user.getName();
			String id = user.getId();
			String pass = user.getPass();
			String permission = user.getPermission();

			User userAdd = new User(name, id, pass, permission);
			PostUserLogic postUserLogic = new PostUserLogic();
			postUserLogic.execute(userAdd);

			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			Log userAddLog = new Log(loginUser.getId(),1,"1",0,timestamp);
			PostUserLogLogic postUserLogLogic = new PostUserLogLogic();
			postUserLogLogic.execute(userAddLog);

			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/user_completion.jsp");
			dispatcher.forward(request, response);

		}
	}

}

