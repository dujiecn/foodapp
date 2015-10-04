package org.dj.mode.one.webfilter;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	private List<Filter> filters = new ArrayList<>();

	private int index = 0;

	public FilterChain addFilter(Filter f) {
		filters.add(f);
		return this;
	}

	@Override
	public void doFilter(Request request, Response response, Filter chain) {
		if (index == filters.size())
			return;
		Filter f = filters.get(index);
		index++;
		f.doFilter(request, response, chain);
	}
}
