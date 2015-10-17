package org.dj.mode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 
 * 项目名称：foodapp 类描述：jdk动态代理 类名称：org.dj.mode.proxy.ServiceProxy2 创建人：dujie
 * 创建时间：2015年10月17日 上午11:35:35
 * 
 * @version V1.0
 */
public class JdkProxy implements InvocationHandler {
	private Object target;


	/**
	 * proxy 代理的对象 method 调用的方法 args 方法调用的参数
	 * 
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		System.out.println("jdk动态代理事务开始");
		result = method.invoke(target, args);
		System.out.println("jdk动态代理事务结束");
		return result;
	}

	public Object createProxy(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
