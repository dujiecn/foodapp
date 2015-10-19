package org.dj.mode.proxy;

public class Main {
	public static void main(String[] args) {
		/*
		 * 静态代理
		 */
		// Service service = new ServiceImpl();
		// Service s = new ServiceProxy(service);
		// s.doSome();

		/*
		 * jdk动态代理
		 */
		// Service service = new ServiceImpl();
		// JdkProxy jdkProxy = new JdkProxy();
		// Service proxy = (Service) jdkProxy.createProxy(service);
		// proxy.doSome();

		/*
		 * cglib动态代理
		 */
		CglibService service = new CglibService();
		CglibProxy cglibProxy = new CglibProxy();
		CglibService proxy = (CglibService) cglibProxy.createProxy(service);
		proxy.doSome();

	}
}
