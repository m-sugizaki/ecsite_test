package jp.co.bow.ec.entity;

import java.io.Serializable;

public class ProductEntity implements Serializable {
	private String product_id;
	private String product_name;
	private String maker;
	private int price;
	private String size;
	private String color;
	private String sale_point;
	private byte[] image;
	//画像のデータを16進数から64進数に変換用
	private String base64string;
	private int stock_quantity;
	private String similar_product_id;

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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public String getSimilar_product_id() {
		return similar_product_id;
	}
	public void setSimilar_product_id(String similar_product_id) {
		this.similar_product_id = similar_product_id;
	}
	public String getBase64string() {
		return base64string;
	}
	public void setBase64string(String base64string) {
		this.base64string = base64string;
	}

}
