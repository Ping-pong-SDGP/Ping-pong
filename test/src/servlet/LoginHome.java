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
import model.LoginLogic;
import model.User;



@WebServlet("/LoginHome")
public class LoginHome extends HttpServlet{
	private static final long serialVersionUID = 1L;

	//ログイン結果画面の「つぶやき投稿」リンク、つぶやき画面の「更新」
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

		LoginLogic loginLogic = new LoginLogic();
		//パスワードチェック execute()

		String isLogin = loginLogic.execute(loginUser);

		if (loginUser == null) { // ログインしていない場合
			// リダイレクト
			response.sendRedirect("/login.jsp");
		}else if(isLogin.equals("1") == true){
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}else if(isLogin.equals("0") == true){
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main2.jsp");
			dispatcher.forward(request, response);
		}
	}
}