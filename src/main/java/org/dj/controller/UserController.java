package org.dj.controller;

import org.dj.bean.po.User;
import org.dj.common.JsonView;
import org.dj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

	@RequestMapping(value = "/resume/{id}", method = RequestMethod.GET)
	public @ResponseBody JsonView getResume(@PathVariable String id) throws Exception {
		return new JsonView(userService.findUserResume(id));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody JsonView modUser(@PathVariable String id) throws Exception {
		User user = new User();
		user.setUserId(id);
		user.setUsername("update-dujie");
		userService.modUser(user);
		return new JsonView();
	}
	
}
