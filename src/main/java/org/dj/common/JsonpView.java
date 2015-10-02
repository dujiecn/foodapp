package org.dj.common;

public class JsonpView {
	private int code;
	private String msg;
	private Object data;

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

	public JsonpView(Object data) {
		this(1, "", data);
	}

	public JsonpView(int code, String msg, Object data) {
		setCode(code);
		setMsg(msg);
		setData(data);
	}
}
