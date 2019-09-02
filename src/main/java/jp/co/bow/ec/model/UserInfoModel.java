package jp.co.bow.ec.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserInfoModel implements Serializable {
	private String user_id;
	@NotEmpty(message = "名前を入力してください。")
	private String name;
	@NotEmpty(message = "ニックネームを入力してください。")
	private String nickname;
	@NotEmpty(message = "郵便番号を入力してください")
	private String postal_code;
	@NotEmpty(message = "住所を入力してください。")
	private String address1;
	private String address2;
	@NotEmpty(message = "電話番号を入力してください。")
	private String phone_number;
	@NotEmpty(message = "メールアドレスを入力してください。")
	@Email(message = "これはメールアドレスではありません。")
	private String email;
	@NotEmpty(message = "誕生日を入力してください。")
	private String birthday;


	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getName() {
		return name;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPostal_code() {
		return postal_code;
	}
	public String getAddress1() {
		return address1;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public String getEmail() {
		return email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

}
