package jp.co.bow.ec.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginModel implements Serializable {
	@NotEmpty(message = "idを入力してください。")
	private String user_id;
	@NotEmpty(message = "パスワードを入力してください。")
	private String password;

	public String getUser_id() {
		return user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
