package com.rationingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rationingsystem.constant.Constant;

@Controller
@RequestMapping("/controller")
public class HomeController {

	/**
	 * request for home page
	 * 
	 * @return load home page
	 */
	@GetMapping("/home")
	public String Home() {
		return Constant.HOME;
	}

	/**
	 * request for add-ration
	 * 
	 * @return add-ration page
	 */
	@GetMapping("/addration")
	public String addRation() {
		return Constant.ADDRATION;
	}

	/**
	 * request for add-water
	 * 
	 * @return add-water page
	 */
	@GetMapping("/addwater")
	public String addWater() {
		return Constant.ADDWATER;
	}
}
