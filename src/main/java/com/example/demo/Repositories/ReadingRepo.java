package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Reading;

public interface ReadingRepo extends CrudRepository<Reading, String> {

	
	List<Reading> findAllByVin(String vin);
}
