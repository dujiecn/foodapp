package org.market.foodapp.util;

public class JsonView {
	private int code;
	private String msg;
	private Object data;

	public JsonView() {

	}

	public JsonView(int code, String msg, Object data) {
		this(code, data);
		setMsg(msg);
	}

	public JsonView(int code, Object data) {
		setCode(code);
		setData(data);
	}
	
	public JsonView(Object data) {
		this(1, data);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
