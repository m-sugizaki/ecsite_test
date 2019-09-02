package jp.co.bow.ec.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserModel implements Serializable {
@NotEmpty(message = "パスワードは必須入力です。")
@Size(min=1,max=50,message="パスワードは50文字以内で入力してください。")
private String password;
@NotEmpty(message = "パスワードは必須入力です。")
@Size(min=1,max=50,message="パスワードは50文字以内で入力してください。")
private String password2;
@NotEmpty(message = "idは必須入力です。")
@Size(min=1,max=10,message="idは10文字以内で入力してください。")
private String user_id;
public String getPassword() {
	return password;
}
public String getPassword2() {
	return password2;
}
public String getUser_id() {
	return user_id;
}
public void setPassword(String password) {
	this.password = password;
}
public void setPassword2(String password2) {
	this.password2 = password2;
}
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
}
