//ログインのチェック処理

package model;

import java.util.ArrayList;
import java.util.List;

public class LoginLogic {



	public String execute(User user) {
		String permissionCheck;
//
//		//パスワードが「１２３４」だったらOK
//		if(user.getPass().equals("1234") && user.getId().equals("abc")){return true;}
//		else if(user.getPass().equals("5678") && user.getId().equals("ABC")){return true;}
//		return false;
//
		List<User> userList = new ArrayList<>();
		//DBチェック
		GetUserListLogic g = new GetUserListLogic();
		userList = g.execute();
		for (User u : userList){
			if(u.getId().equals(user.getId()) == true && u.getPass().equals(user.getPass())== true){
				permissionCheck = u.getPermission();
				System.out.println(permissionCheck);
				if(permissionCheck.equals("1") == true){
					return permissionCheck;
				}else if(permissionCheck.equals("0") == true){
					permissionCheck = u.getPermission();
					return permissionCheck;
				}else{
					return "-1";
				}
			}
		}
		return "-1";
	}
}
