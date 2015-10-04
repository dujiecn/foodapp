package org.dj.mode.one;

public class SensitiveFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		return msg.replaceAll("习近平", "");
	}

}
