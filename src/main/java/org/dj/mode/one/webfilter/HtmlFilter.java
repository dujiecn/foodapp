package org.dj.mode.one.webfilter;

public class HtmlFilter implements Filter {

	@Override
	public void doFilter(Request request, Response response, Filter chain) {
		request.setMsg(request.getMsg().replaceAll("<", "[").replace(">", "]") + "===htmlFilter");
		chain.doFilter(request, response, chain);
		response.setMsg(response.getMsg() + "===htmlFilter");
	}

}
