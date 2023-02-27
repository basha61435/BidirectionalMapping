package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Address;
import com.example.Entity.Customers;
import com.example.Repository.AddressRepo;
import com.example.Service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private AddressRepo addressRepo;
	@PostMapping("/saveCustomers")
	public Customers saveCustomers(@RequestBody Customers customers)
	{
		return customerService.saveCustomers(customers);
	}
	@GetMapping("/getcustomersWithCity/{city}")
	public List<Customers> getCustomersWithCity(@PathVariable String city)
	{
		return customerService.getDeteailsByCity(city);
	}
	@GetMapping("getAddresswithCity/{city}")
	public List<Address> getAddressWithCity(@PathVariable String city)
	{
		return addressRepo.findAddressByCity(city);
	}

}
