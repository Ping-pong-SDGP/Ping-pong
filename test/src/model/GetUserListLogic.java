//DAOクラスを使って、データを取得するメソッドをもつクラス
package model;

import java.util.List;

import dao.UserDAO;

public class GetUserListLogic {

	//execute()メソッドで、データリストを取得
	public List<User> execute() {

		//DAOインスタンス作成
		UserDAO dao = new UserDAO();

		//検索、取得
		List<User> UserList = dao.findAll();
		//リストを返す
		return UserList;
	}
}