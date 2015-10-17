package org.dj.mode.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	private Object target;


	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object result = null;
		System.out.println("cglib proxy do before.");
		result = methodProxy.invokeSuper(proxy, args);
		System.out.println("cglib proxy do after.");
		return result;
	}

	public Object createProxy(Object target) {
		this.target = target;

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());// 设置代理目标
		enhancer.setCallback(this);// 设置回调
		enhancer.setClassLoader(target.getClass().getClassLoader());
		return enhancer.create();
	}

}
