package jp.co.bow.ec.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Purchase_ResultEntity implements Serializable {
	private int order_no;
	private String user_id;
	private String product_id;
	private int quantity;
	private String size;
	private String color;
	private LocalDate order_dt;
	private String order_status;
	private String payment_method;
	private int payment_no;
	private int shipping_address_no;
	private LocalDate delivery_plan_dt;
	private LocalDate delivery_completion_dt;
	public int getOrder_no() {
		return order_no;
	}
	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public LocalDate getOrder_dt() {
		return order_dt;
	}
	public void setOrder_dt(LocalDate order_dt) {
		this.order_dt = order_dt;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public int getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}
	public int getShipping_address_no() {
		return shipping_address_no;
	}
	public void setShipping_address_no(int shipping_address_no) {
		this.shipping_address_no = shipping_address_no;
	}
	public LocalDate getDelivery_plan_dt() {
		return delivery_plan_dt;
	}
	public void setDelivery_plan_dt(LocalDate delivery_plan_dt) {
		this.delivery_plan_dt = delivery_plan_dt;
	}
	public LocalDate getDelivery_completion_dt() {
		return delivery_completion_dt;
	}
	public void setDelivery_completion_dt(LocalDate delivery_completion_dt) {
		this.delivery_completion_dt = delivery_completion_dt;
	}
}
