package com.lb.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("login")
	String login(@RequestParam(required=false)String username, @RequestParam(required=false) String password) {
		if(username == null || password == null) {
			return "login";
		}
		Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                username, password);
        subject.login(usernamePasswordToken);
		return "success";
	}

	@RequiresRoles("createUser")
	@RequiresPermissions("create")
	@GetMapping("/create")
	String create() {
		return "create";
	}
	

	@RequiresPermissions("delete")
	@GetMapping("/delete")
	String delete() {
		return "delete";
	}
}
