package jp.co.bow.ec.model;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class PaymentMethodModel implements Serializable {
	private String user_id;
	@NotEmpty(message = "支払方法を入力してください。")
	private String payment_method;
	private String payment_no;
	@NotEmpty(message="クレジットカード番号を入力してください。")
	private String card_number;
	@NotEmpty(message = "カードの有効期限を入力してください。")
	private String expiration_month;
	@NotEmpty(message = "カードの有効期限を入力してください。")
	//@Future(message="無効な日付です。")
	private String expiration_year;


	@NotEmpty(message = "カードの所有者名を入力してください。")
	private String card_holder_name;

	public String getUser_id() {
		return user_id;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public String getPayment_no() {
		return payment_no;
	}
	public String getCard_number() {
		return card_number;
	}
	public String getExpiration_month() {
		return expiration_month;
	}
	public String getCard_holder_name() {
		return card_holder_name;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public void setPayment_no(String payment_no) {
		this.payment_no = payment_no;
	}
	public void setCard_number(String card_number) {
		this.card_number = card_number;
	}
	public void setExpiration_month(String expiration_month) {
		this.expiration_month = expiration_month;
	}
	public void setCard_holder_name(String card_holder_name) {
		this.card_holder_name = card_holder_name;
	}
	public String getExpiration_year() {
		return expiration_year;
	}
	public void setExpiration_year(String expiration_year) {
		this.expiration_year = expiration_year;
	}

}
