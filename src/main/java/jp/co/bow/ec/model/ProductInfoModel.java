package jp.co.bow.ec.model;

import java.io.Serializable;

public class ProductInfoModel implements Serializable {
	private String product_id;
	private String product_name;
	private String maker;
	private String price;
	private String size;
	private String color;
	private String sale_point;
	private String stock_quantity;
	private String image;
	private String similar_product_id;
	private String quantity;

	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public String getSale_point() {
		return sale_point;
	}
	public void setSale_point(String sale_point) {
		this.sale_point = sale_point;
	}
	public String getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(String stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getSimilar_product_id() {
		return similar_product_id;
	}
	public void setSimilar_product_id(String similar_product_id) {
		this.similar_product_id = similar_product_id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


}
