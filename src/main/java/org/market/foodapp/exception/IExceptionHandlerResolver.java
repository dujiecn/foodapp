package org.market.foodapp.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.market.foodapp.util.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;

public class IExceptionHandlerResolver implements HandlerExceptionResolver {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		logger.info("{}:{}", ex.getClass().getName(), ex.getMessage());
		if (logger.isDebugEnabled()) {
			ex.printStackTrace();
		}
		BusinessException se = null;
		if (ex instanceof BusinessException) {
			se = (BusinessException) ex;
		} else {
			se = new BusinessException("未知错误");
		}

		// 往客户端写失败数据
		write(response, se.getMessage());

		return new ModelAndView();
	}

	private void write(HttpServletResponse response, String error) {
		PrintWriter pw;
		try {
			response.setCharacterEncoding("utf-8");
			response.setHeader("Content-type", "text/json;charset=UTF-8");
			pw = response.getWriter();
			pw.write(JSONObject.toJSONString(new JsonView(0, error, null)));
			pw.flush();
		} catch (IOException e) {
			logger.error("catch exception error" + e.getMessage());
		}
	}

}
