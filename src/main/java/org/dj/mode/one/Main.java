package org.dj.mode.one;

/**
 * 
 * 项目名称：foodapp 类描述：责任链模式 类名称：org.dj.mode.one.Main 创建人：dujie 创建时间：2015年10月3日
 * 上午9:25:29 实现过滤字符串
 * 
 * @version V1.0
 */
public class Main {
	public static void main(String[] args) {
		String str = "大家好，<script>，习近平，今天天气真好";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(str);

		FilterChain fc = new FilterChain();
		fc.addFilter(new HtmlFilter()).addFilter(new SensitiveFilter());
		
		FilterChain fc2 = new FilterChain();
		FilterChain fc3 = new FilterChain();
		fc.addFilter(fc2).addFilter(fc3);
		
		mp.setFc(fc);
		str = mp.process();
		System.err.println(str);
	}
}
