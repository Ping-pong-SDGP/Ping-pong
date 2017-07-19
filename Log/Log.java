//つぶやき情報
//JavaBeansのモデル

package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Log implements Serializable {
	private String userName;
	private String opName; // ユーザー名
	private String prName;
	private int qty;
	private Timestamp time;

	public Log() {
	}

	public Log(String userName, String opName, String prName, int qty, Timestamp time) {
		this.userName = userName;
		this.opName = opName;
		this.prName = prName;
		this.qty = qty;
		this.time = time;
	}


	public int getqty(){
		return qty;
	}
	public String getUserName() {
		return userName;
	}

	public String getopName() {
		return opName;
	}

	public String getprName(){
		return prName;
	}

	public Timestamp getTime(){
		return time;
	}

}