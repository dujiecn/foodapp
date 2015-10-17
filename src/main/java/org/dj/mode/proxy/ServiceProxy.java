package org.dj.mode.proxy;

/**
 * 
 * 项目名称：foodapp 类描述：静态代理 类名称：org.dj.mode.proxy.ServiceProxy 创建人：dujie
 * 创建时间：2015年10月17日 上午11:35:49
 * 
 * @version V1.0
 */
public class ServiceProxy implements Service {

	private Service service;

	public ServiceProxy(Service service) {
		this.service = service;
	}

	@Override
	public void doSome() {
		System.out.println("事务处理之前");
		service.doSome();
		System.out.println("事务处理之后");
	}

}
