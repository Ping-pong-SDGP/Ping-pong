package model;

import dao.UserDAO;

public class PostDelUserLogic {
	public void execute(User user) {

		//DAO生成
		UserDAO dao = new UserDAO();

		//１件登録
		dao.delete(user);
	}

}