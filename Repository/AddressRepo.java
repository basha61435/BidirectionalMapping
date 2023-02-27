package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Entity.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {
	@Query("select DISTINCT a from Address a join fetch a.customers c where a.city=:city")
	public List<Address> findAddressByCity(@Param("city") String city);

}
