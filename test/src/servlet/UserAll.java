package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetUserListLogic;
import model.User;


@WebServlet("/UserAll")
public class UserAll extends HttpServlet{
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

			//データベースから読み出しリクエストに保存
			GetUserListLogic gu = new GetUserListLogic();
			List<User> userList = gu.execute();

			request.setAttribute("userList", userList);

			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/user_del.jsp");
			dispatcher.forward(request, response);
		}
	}

}
