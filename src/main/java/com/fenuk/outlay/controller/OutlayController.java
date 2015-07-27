package com.fenuk.outlay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OutlayController {

	@RequestMapping("datatable.do")
	public String view() {
		return "dataTable";
	}
	
	@RequestMapping("outlayformselector.do")
	public String outlayFormSelector(){
		
		return "outlayFormSelector";
		
	}
	@RequestMapping("outlay.do")
	@ResponseBody
	public String execute(){
		
		return "Ok";
	}
}
