package com.example.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Reading;

import com.example.demo.Repositories.ReadingRepo;

@Service
public class ReadingService {

	@Autowired
	ReadingRepo rr;
	
	
	 public void save(Reading reading)
	{
		rr.save(reading);
	}
	
	 
	 public List<Reading> findallbyvin(String vin)
		{
			List<Reading> Readings=rr.findAllByVin(vin);
			return Readings;
		}
	
}
