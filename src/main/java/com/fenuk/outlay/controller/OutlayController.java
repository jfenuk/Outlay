package com.fenuk.outlay.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fenuk.outlay.model.Outlay;
import com.fenuk.outlay.repository.OutlayJdbcRepository;

@Controller
public class OutlayController {

	@Autowired
	OutlayJdbcRepository oRepository;

	@RequestMapping("datatable.do")
	public String view() {
		return "dataTable";
	}
	
	@RequestMapping("jsonArrayData.do")
	public String jsonArrayData() {
		return "jsonArrayData";
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
		
		oRepository.save(new Outlay(amount, category));

		return "Ok";
	}
}
