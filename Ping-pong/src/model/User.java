//ユーザ情報
//JavaBeansのモデル
package model;

import java.io.Serializable;

public class User implements Serializable {
//	private int id;
	private String id;
	private String pass;
	private String name;
	private String permission;

	public User() {

	}

	public User(String name, String id, String pass, String permission) {
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.permission = permission;
	}

	public User(String id, String pass){
		this.id = id;
		this.pass = pass;
	}

	public User(String name){
		this.name = name;
	}


	public User(String name, String id, String permission){
		this.name = name;
		this.id = id;
		this.permission = permission;
	}

	public String getName(){
		return name;
	}

	public String getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}
	public String getPermission(){
		return permission;
	}


}