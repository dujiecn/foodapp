package org.dj.controller;

import org.dj.common.JsonView;
import org.dj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	// @RequestMapping(value = "/", produces = "text/json;charset=utf-8")
	// public String index() {
	// return "我爱你";
	// }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody JsonView login(String username, String password) throws Exception {
		return new JsonView(userService.findUser(username, password));
	}
}
