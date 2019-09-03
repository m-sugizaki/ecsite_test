package jp.co.bow.ec.model;

import java.io.Serializable;//いらないかも

public class ListDataModel implements Serializable {
	private String label;
	private String data;
	public ListDataModel(String label,String data) {
		this.label=label;
		this.data=data;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
