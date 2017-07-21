//つぶやき情報
//JavaBeansのモデル

package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Log implements Serializable {
	private String userName;
	private String opName;
	private String prName;
	private int qty;
	private Timestamp time;
	private String userId;
	private int opId;
	private String prId;


	public Log() {
	}

	public Log(String userName, String opName, String prName, int qty, Timestamp time) {
		this.userName = userName;
		this.opName = opName;
		this.prName = prName;
		this.qty = qty;
		this.time = time;
	}
	public Log(String userId, int opId, String prId, int qty,Timestamp time){
		this.userId = userId;
		this.opId = opId;
		this.prId = prId;
		this.qty = qty;
		this.time = time;
	}

	public String getUserId(){
		return userId;
	}

	public int getOpId(){
		return opId;
	}

	public int getQty(){
		return qty;
	}
	public String getUserName() {
		return userName;
	}

	public String getOpName() {
		return opName;
	}

	public String getPrName(){
		return prName;
	}

	public Timestamp getTime(){
		return time;
	}
	public String getPrId(){
		return prId;
	}

}