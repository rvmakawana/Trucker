package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Reading;
import com.example.demo.Entity.Tires;
import com.example.demo.Repositories.TireRepo;

@Service
public class TireService {

    @Autowired
    TireRepo tr;
	
	void save(Tires tire)
	{
		
		tr.save(tire);
		
	}
	
	
	Tires findone(int id)
	{
	 return	tr.findById(id).get();
	}
	
}
