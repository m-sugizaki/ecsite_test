package jp.co.bow.ec.model;

import java.io.Serializable;

public class SearchProductInfoModel implements Serializable {
	private String product_id;
	private String price_start;
	private String price_end;
	private String product_name;
	private String maker;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getPrice_start() {
		return price_start;
	}

	public void setPrice_start(String price_start) {
		this.price_start = price_start;
	}

	public String getPrice_end() {
		return price_end;
	}

	public void setPrice_end(String price_end) {
		this.price_end = price_end;
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


}