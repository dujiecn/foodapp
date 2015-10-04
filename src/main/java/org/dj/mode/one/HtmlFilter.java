package org.dj.mode.one;

public class HtmlFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		return msg.replaceAll("<", "[").replace(">", "]");
	}

}
