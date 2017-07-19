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



@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{
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
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/user_add.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		String id = request.getParameter("userId");
		String pass = request.getParameter("userPass");
		String permission = request.getParameter("permission");

		System.out.println(name + id + pass + permission);

		// 入力値チェック
		if (name != null && name.length() != 0 && pass != null && pass.length() != 0 && id != null && id.length() != 0) {
			User user = new User(name,id,pass,permission);
			HttpSession session = request.getSession();
			session.setAttribute("kaluser",user);
			System.out.println(user.getName());
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/user_add_confirm.jsp");
				dispatcher.forward(request, response);
		}else{
			System.out.println("ABCD");
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/user_add.jsp");
			dispatcher.forward(request, response);
		}
	}

}
