package com.demo.service.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.domain.DemoService;

@RestController
public class DemoServiceController {

	private static Map<String, List<DemoService>> custDB = new HashMap<String, List<DemoService>>();

	static {
		custDB = new HashMap<String, List<DemoService>>();

		List<DemoService> lst = new ArrayList<DemoService>();
		DemoService std = new DemoService("Customer-1", "Peel region");
		lst.add(std);
		std = new DemoService("Customer-2", "Peel region");
		lst.add(std);

		custDB.put("abccust", lst);

		lst = new ArrayList<DemoService>();
		std = new DemoService("Customer-3", "Halton region");
		lst.add(std);
		std = new DemoService("Customer-4", "Halton region");
		lst.add(std);

		custDB.put("xyzcust", lst);

	}

	@RequestMapping(value = "/getShippingDetailsForCustomer/{custname}", method = RequestMethod.GET)
	public List<DemoService> getStudents(@PathVariable String custname) {
		System.out.println("Getting Customer details for " + custname);

		List<DemoService> shippingList = custDB.get(custname);
		if (shippingList == null) {
			shippingList = new ArrayList<DemoService>();
			DemoService std = new DemoService("Not Found", "N/A");
			shippingList.add(std);
		}
		return shippingList;
	}
}
