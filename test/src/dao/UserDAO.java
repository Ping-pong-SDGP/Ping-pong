
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {

	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL =
			"jdbc:h2:tcp://localhost/~/Documents/group_work/Ping-pong/pingpongDB/ChestDB";	//DB名
	//		(例)"jdbc:h2:tcp://localhost/~/DB/docotsubu";
	private final String DB_USER = "legal";
	private final String DB_PASS = "lll";

	static Connection conn = null;
	//--------------------------------------------
	//コンストラクタ（今回、ここでは接続まで行う）
	//--------------------------------------------
	public UserDAO(){

		if(conn == null){
			try{
			// JDBCドライバを読み込み
			Class.forName(DRIVER_NAME);

			// データベースへ接続
			conn = DriverManager.getConnection(
					JDBC_URL,	DB_USER, DB_PASS);
			}catch(Exception  e){}

			if(conn != null)	System.out.println("connectしました");
			else System.out.println("connect失敗しました");
		}
	}

	//------------------------------
	//UESR
	//------------------------------
	public List<User> findAll() {

		List<User> UserList = new ArrayList<User>();
		try {

			if(conn == null){
				System.out.println("DB接続できていません");
				return UserList;
			}
			// SELECT文の準備
			String sql =
					"SELECT * FROM USER";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			System.out.println(sql);

			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();
			System.out.println(rs);

			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				String Id = rs.getString("USERID");
				String Pass= rs.getString("PASSWORD");
				String Name = rs.getString("USERNAME");
				String per = rs.getString("PERMISSION");


//				Integer oi = new Integer(per);
//				String Permission = oi.toString();
//				System.out.println("***"+Permission);

				User User = new User(Name, Id, Pass,per);
				UserList.add(User);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("B"+UserList);
			return null;

		} finally {
			close();
		}
		//検索結果のリストを返す
		return UserList;
	}

	//-----------------------------------
	//DB接続を切る
	//-----------------------------------
	public static void  close(){

		// データベース切断
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//-----------------------------------
	//データ１件登録
	//-----------------------------------
	public boolean create(User user) {
		try {
			conn = DriverManager.getConnection(
					JDBC_URL,	DB_USER, DB_PASS);

			String sql = "INSERT INTO User(USERNAME,USERID, PASSWORD, PERMISSION) VALUES(?, ?, ?, ?)";

			//プリペアステートメントの作成
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, user.getName());
			pStmt.setString(2, user.getId());
			pStmt.setString(3, user.getPass());
			pStmt.setString(4, user.getPermission());

			// INSERT文を実行
			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			close();
		}
		return true;
	}
	public List<User> findSearch(User user) {

		List<User> UserSearchList = new ArrayList<User>();
		try {

			if(conn == null){
				System.out.println("DB接続できていません");
				return UserSearchList;
			}
			// SELECT文の準備
			String sql =
					"SELECT  FROM USER WHERE USERNAME = (?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, user.getName());

			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();
			System.out.println(rs);

			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
				String Id = rs.getString("USERID");
				String Pass= rs.getString("PASSWORD");
				String Name = rs.getString("USERNAME");
				String per = rs.getString("PERMISSION");


//				Integer oi = new Integer(per);
//				String Permission = oi.toString();
//				System.out.println("***"+Permission);

				User User = new User(Name, Id, Pass,per);
				UserSearchList.add(User);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("B"+UserList);
			return null;

		} finally {
			close();
		}
		//検索結果のリストを返す
		return UserSearchList;
	}
}
