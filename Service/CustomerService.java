package com.example.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Address;
import com.example.Entity.Customers;
import com.example.Repository.CustomerRepo;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepo customerRepo;

	public Customers saveCustomers(Customers customers) {
		List<Address> address = customers.getAddress();
		address.stream().map((a) -> {
			a.setCustomers(customers);
			return a;
		}).collect(Collectors.toList());
		return customerRepo.save(customers);
	}

	public List<Customers> getDeteailsByCity(String city) {
		return customerRepo.findPersonByCity(city);
	}
}
