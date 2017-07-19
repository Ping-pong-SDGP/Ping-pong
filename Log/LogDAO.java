
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import model.Log;

public class LogDAO {

	private final String DRIVER_NAME = "org.h2.Driver";
	private final String JDBC_URL =
			"jdbc:h2:~/Documents/Ping-pong/pingpongDB/ChestDB";	//DB名（フルパス）
	//		(例)"jdbc:h2:tcp://localhost/~/DB/docotsubu";
	private final String DB_USER = "legal";
	private final String DB_PASS = "lll";

	static Connection conn = null;
	//--------------------------------------------
	//コンストラクタ（今回、ここでは接続まで行う）
	//--------------------------------------------
	public LogDAO(){

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
	//つぶやきデータの検索、取得
	//------------------------------
	public List<Log> findAll() {

		List<Log> logList = new ArrayList<Log>();
		try {


System.out.println("conn=" + conn);

			if(conn == null){
				System.out.println("DB接続できていません");
				return logList;
			}
			// SELECT文の準備
			String sql = "SELECT user.username, OPERATION.OPERATIONNAME, PRODUCT.PRODUCTNAME, LOG.QTY, LOG.OPERATIONDATE"
					+"from log"
					+"inner join user on log.userid = user.userid"
					+"inner join operation on log.OPERATIONID = OPERATION.OPERATIONID"
					+"inner join PRODUCT on log.PRODUCTid = PRODUCT.PRODUCTID;";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SELECTを実行
			ResultSet rs = pStmt.executeQuery();

			// SELECT文の結果をArrayListに格納
			while (rs.next()) {
			//	int id = rs.getInt("ID");
				String userName = rs.getString("USERNAME");
				String opName = rs.getString("OPERATIONNAME");
				String prName = rs.getString("PRODUCTNAME");
				int qty = rs.getInt("QTY");
				Timestamp time = rs.getTimestamp("OPERATIONDATE");



				Log mutter = new Log(userName, opName, prName, qty, time);
				logList.add(mutter);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		} finally {

		}
		//検索結果のリストを返す
		return logList;
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
	public boolean create(Log log) {

		try {

			// INSERT文の準備(idは自動連番なので指定しなくてよい）
			String sql = "INSERT INTO MUTTER(NAME, TEXT) VALUES(?, ?)";

			//プリペアステートメントの作成
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, log.getUserName());
			pStmt.setString(2, log.getopName());
			pStmt.setString(3, log.getprName());
			pStmt.setInt(4, log.getqty());
			pStmt.setTimestamp(5, log.getTime());

			// INSERT文を実行s
			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {

		}
		return true;
	}
}
