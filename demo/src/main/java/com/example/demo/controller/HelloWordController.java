package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.bean.User;
import com.example.demo.mapper.UserMapper;

//返回页面
@Controller
// 返回json,相当于@Controller和@ResponseBody的结合
// @RestController
public class HelloWordController {

	protected Logger logger = LoggerFactory.getLogger(HelloWordController.class);

	@Autowired
	private UserMapper mapper;

	@RequestMapping("/hello")
	public String hello(String name) {

		logger.info("Hello" + name);
		return "Hello" + name;

	}

	@RequestMapping("/index")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("index");
		List<User> users = mapper.getAll();
		modelAndView.addObject("users", users);
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView model=new ModelAndView("add");
		model.addObject("type", "add");
		return model;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(@RequestParam(required = false, value = "name") String name,
			@RequestParam(required = false, value = "password") String password) {
		ModelAndView model=new ModelAndView("add");
		model.addObject("type", "update");
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		model.addObject("user", user);
		return model;
	}

	@RequestMapping("/addUser")
	public ModelAndView addUser(User user) {
		int exist = mapper.exists(user);
		if (exist > 0) {
			logger.info("该用户已经存在");
			return new ModelAndView("redirect:/index");
		}
		int num = mapper.insert(user);

		if (num > 0) {
			logger.info("新增成功");
		} else {
			logger.info("新增失败"); 
		}
		ModelAndView mav = new ModelAndView("redirect:/index");
		return mav;
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(@RequestParam(required = false, value = "name") String name) {
		int num = mapper.delete(name);
		if (num > 0) {
			logger.info("删除成功");
		} else {
			logger.info("删除失败");
		}
		ModelAndView mav = new ModelAndView("redirect:/index");
		return mav;
	}


	@RequestMapping("/updateUser")
	public ModelAndView updateUser(@RequestParam(required = false, value = "name") String name,
			@RequestParam(required = false, value = "password") String password) {
		User user = new User();
		user.setName(name);
		user.setPassword(password);
		int num = mapper.update(user);
		if (num > 0) {
			logger.info("修改成功");
		} else {
			logger.info("修改失败");
		}
		ModelAndView mav = new ModelAndView("redirect:/index");
		return mav;
	}

}
