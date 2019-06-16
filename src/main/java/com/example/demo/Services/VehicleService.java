package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Vehicles;
import com.example.demo.Repositories.VehicleRepo;

@Service
public class VehicleService {

	@Autowired
	VehicleRepo vr;
	
	public void save(List<Vehicles> vehicles)
	{
		vr.saveAll(vehicles);
	}
	
	public List<Vehicles> findall()
	{
		
		return (List<Vehicles>) vr.findAll();
	}
	public Vehicles findone(String vin)
	{
		Vehicles v= vr.findById(vin).get();
		return v;
	}
	
	public List<Vehicles> findallbyvin(String vin)
	{
		
		return vr.findAllByVin(vin);
	}
}


