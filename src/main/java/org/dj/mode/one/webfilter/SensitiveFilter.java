package org.dj.mode.one.webfilter;

public class SensitiveFilter implements Filter {


	@Override
	public void doFilter(Request request, Response response, Filter chain) {
		request.setMsg(request.getMsg().replaceAll("习近平", "") + "===sensitiveFilter");
		chain.doFilter(request, response, chain);
		response.setMsg(response.getMsg() + "===sensitiveFilter");
	}

}
