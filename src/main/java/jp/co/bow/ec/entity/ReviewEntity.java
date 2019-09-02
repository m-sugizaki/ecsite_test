package jp.co.bow.ec.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class ReviewEntity implements Serializable {
	private String product_id;
	private int review_no;
	private String user_id;
	private int evaluation;
	private String review_content;
	private LocalDate review_dt;
	private String nickname;
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getReview_no() {
		return review_no;
	}
	public void setReview_no(int review_no) {
		this.review_no = review_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public LocalDate getReview_dt() {
		return review_dt;
	}
	public void setReview_dt(LocalDate review_dt) {
		this.review_dt = review_dt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
