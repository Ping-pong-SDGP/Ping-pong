package model;

import java.util.List;

import dao.UserDAO;

public class GetSearchUserLogic {
	public List<User> execute(User user) {

		//DAO生成
		UserDAO dao = new UserDAO();
		//検索、取得
		List<User> UserSearchList = dao.findSearch(user);
		//リストを返す
		return UserSearchList;
	}


}
