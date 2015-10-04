package org.dj.mode.one.webfilter;

public interface Filter {
	public void doFilter(Request request,Response response,Filter chain);
}
