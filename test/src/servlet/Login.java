//ログイン全般をコントロールするサーブレットクラス

package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String Id = request.getParameter("userid");
		String pass = request.getParameter("pass");
//		String Name = request.getParameter("name");
//		String permission = request.getParameter("permission");



		// Userインスタンス（ユーザー情報）の生成
		User user = new User(Id, pass);

		// ログインロジックのインスタンス生成
		LoginLogic loginLogic = new LoginLogic();



		//パスワードチェック execute()
		String isLogin = loginLogic.execute(user);

		System.out.println("NNNN"+ isLogin);

		// ログイン成功時の処理
		if(isLogin.equals("1") == true){
			// ユーザー情報をセッションスコープに保存
	 		HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			// ログイン結果画面にフォワード
			RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}else if(isLogin.equals("0") == true){
			// ユーザー情報をセッションスコープに保存
	 		HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			// ログイン結果画面にフォワード
			RequestDispatcher dispatcher =
			request.getRequestDispatcher("/WEB-INF/jsp/main2.jsp");
			dispatcher.forward(request, response);
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", null);
		}

	}
}