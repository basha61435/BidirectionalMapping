package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Entity.Address;
import com.example.Entity.Customers;
@Repository
public interface CustomerRepo extends JpaRepository<Customers, Long> {
	 @Query("SELECT  c FROM Customers c JOIN FETCH c.address a WHERE a.city = :city")
	   public List<Customers> findPersonByCity(@Param("city") String city);


}
