package com.menu.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.menu.model.OrderModelVO;
import com.menu.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	//Post method for adding data to database
	//@param - OrderModelVO from the request body
	//@return - Status code whether the operation was successful or not
	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
	@PostMapping("/add")
	public ResponseEntity<?> addOrder(@RequestBody OrderModelVO order){
		try {
			service.addOrder(order);
			return ResponseEntity.ok("Success");
		}catch(Exception e){
			System.out.println(e);
			return ResponseEntity.ok("Error in posting data");
		}
	}
	
	//Get method for fetching data from database
	//@return - Status code and the list of orders
	@CrossOrigin(allowedHeaders="*",allowCredentials="true")
	@GetMapping("/display")
	public ResponseEntity<List<OrderModelVO>> getOrder(){
		try {
			return ResponseEntity.ok(service.getOrders());
		}catch(Exception e){
			System.out.println(e);
			return ResponseEntity.ok(null);
		}
		
	}
}
