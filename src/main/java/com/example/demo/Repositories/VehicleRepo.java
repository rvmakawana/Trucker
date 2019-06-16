package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Vehicles;

public interface VehicleRepo extends CrudRepository<Vehicles, String> {

	
	List<Vehicles> findAllByVin(String vin);
}
