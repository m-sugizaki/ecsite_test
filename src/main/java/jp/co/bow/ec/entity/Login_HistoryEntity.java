package jp.co.bow.ec.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Login_HistoryEntity implements Serializable {
	private String user_id;
	private LocalDate login_dt;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public LocalDate getLogin_dt() {
		return login_dt;
	}
	public void setLogin_dt(LocalDate login_dt) {
		this.login_dt = login_dt;
	}

}
