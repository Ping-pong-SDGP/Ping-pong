package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetSearchUserLogic;
import model.User;

@WebServlet("/SearchUser")
public class SearchUser extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");

		// Userインスタンス（ユーザー情報）の生成
		User userSearch = new User(name);

		GetSearchUserLogic getSearchUserLogic = new GetSearchUserLogic();

		List<User> userList = getSearchUserLogic.execute(userSearch);

		request.setAttribute("userList", userList);

		RequestDispatcher dispatcher =
				request.getRequestDispatcher("/WEB-INF/jsp/user_del.jsp");
		dispatcher.forward(request, response);
	}

}
