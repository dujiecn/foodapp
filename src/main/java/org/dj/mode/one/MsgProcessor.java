package org.dj.mode.one;

public class MsgProcessor {
	private String msg;
	// private Filter[] filters = { new HtmlFilter(), new SensitiveFilter() };
	FilterChain fc;

	public String process() {
		return fc.doFilter(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public FilterChain getFc() {
		return fc;
	}

	public void setFc(FilterChain fc) {
		this.fc = fc;
	}
}
