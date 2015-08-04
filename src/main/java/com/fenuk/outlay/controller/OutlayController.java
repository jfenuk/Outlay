package com.fenuk.outlay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OutlayController {

	@RequestMapping("datatable.do")
	public String view() {
		return "dataTable";
	}

	@RequestMapping("outlayformselector.do")
	public String outlayFormSelector() {

		return "outlayFormSelector";

	}

	@RequestMapping(value = "outlay.do", method = RequestMethod.POST)
	@ResponseBody
	public String execute(@RequestParam("amount") long amount, @RequestParam("category") String category) {

		System.out.println("Amount: " + amount);
		System.out.println("Category: " + category);

		return "Ok";
	}
}
