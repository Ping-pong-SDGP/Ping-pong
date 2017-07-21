package model;

import dao.LogDAO;

public class PostUserLogLogic {
	public void execute(Log log) {

		//DAO生成
		LogDAO dao = new LogDAO();

		//１件登録
		dao.createUserLog(log);
	}
}