package org.market.foodapp.controller;

import org.market.foodapp.service.UserService;
import org.market.foodapp.util.JsonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	private Logger Logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody JsonView findUser(@PathVariable String id) throws Exception {
		return new JsonView(1, userService.findUserById(id));
	}

	@RequestMapping(value = "/common")
	public @ResponseBody JsonView t() {
		return new JsonView("common page");
	}

	@RequestMapping(value = "/admin")
	public @ResponseBody JsonView t2() {
		return new JsonView("admin page");
	}

	@RequestMapping(value = "/login")
	public @ResponseBody JsonView t1() {
		return new JsonView("login page");
	}

	@RequestMapping(value = "/fail")
	public @ResponseBody JsonView error() {
		return new JsonView("fail page");
	}
	@RequestMapping(value = "/logout")
	public @ResponseBody JsonView logout() {
		return new JsonView("logout page");
	}
}
