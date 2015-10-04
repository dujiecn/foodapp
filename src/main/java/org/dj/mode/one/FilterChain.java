package org.dj.mode.one;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter{
	private List<Filter> filters = new ArrayList<>();

	public FilterChain addFilter(Filter f) {
		filters.add(f);
		return this;
	}
	
	public String doFilter(String msg) {
		for (Filter filter : filters) {
			msg = filter.doFilter(msg);
		}
		return msg;
	}
}
