package model;

import java.util.List;

import dao.LogDAO;


public class GetLogListLogic {

	//execute()メソッドで、データリストを取得
	public List<Log> execute() {

		//DAOインスタンス作成
		LogDAO dao = new LogDAO();

		//検索、取得
		List<Log> LogList = dao.findAll();
		//リストを返す
		return LogList;
	}
}