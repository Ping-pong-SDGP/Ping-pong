package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

@WebServlet("/UserDel")
public class UserDel extends HttpServlet{
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		String id = request.getParameter("userId");
		String permission = request.getParameter("permission");

		// 入力値チェック
		if (name != null && name.length() != 0 && id != null && id.length() != 0) {
			User user = new User(name,id,permission);
			HttpSession session = request.getSession();
			session.setAttribute("deluser",user);
			System.out.println(user.getName());
				RequestDispatcher dispatcher =
						request.getRequestDispatcher("/WEB-INF/jsp/user_del_confirm.jsp");
				dispatcher.forward(request, response);
		}else{
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/user_del.jsp");
			dispatcher.forward(request, response);
		}
	}
}
