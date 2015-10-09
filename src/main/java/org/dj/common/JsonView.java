package org.dj.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonView {
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

	public JsonView(Object data) {
		this(1, "", data);
	}

	public JsonView(int code, String msg, Object data) {
		setCode(code);
		setMsg(msg);
		setData(data);
	}

	public JsonView() {
		this(1, "", null);
	}
	
}
