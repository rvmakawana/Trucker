package com.example.demo.Controllers;


import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Priorities;
import com.example.demo.Entity.Reading;
import com.example.demo.Entity.Vehicles;
import com.example.demo.Repositories.PriorityRepo;
import com.example.demo.Services.PService;
import com.example.demo.Services.ReadingService;
import com.example.demo.Services.TireService;
import com.example.demo.Services.VehicleService;

@RestController
@CrossOrigin(origins = {"http://mocker.egen.io", "http://mocker.ennate.academy"})
public class VehicleController {
	
	@Autowired
	VehicleService vs;
	
	@Autowired
	ReadingService rs;
	
	@Autowired
	TireService ts;
	
	@Autowired
	PService ps;
	
	
	
//	  @PutMapping("/vehicles")
//	    public  List<Vehicles> update(@RequestBody List<Vehicles> vList) {
//	        System.out.println("Receiving vehicles list with size:- "+vList.size());
//	        for(Vehicles v:vList)
//	        {
//	        	   System.out.print(v.getMake());
//	        }
//	       vs.save(vList);
//	       return vList;
//	    }
	
	
	 @RequestMapping(method = RequestMethod.POST,value="/readings",produces = {"application/json"})	
	    public  Reading create(@RequestBody Reading reading) {
	        System.out.println("Creating Reading record");
	        System.out.println(reading.getEngineHp());
	        rs.save(reading);
	        
	        return reading;
	   
	    }
	
	@RequestMapping(value="/get",produces = {"application/json"})
	public List<Vehicles> getAll()
	{
		
		return vs.findall();
	}
	
	
	@RequestMapping(value="/highpriority",produces = {"application/json"})
	public List<Priorities> showHighPriority()
	{
		 return ps.findHigh();
		
	}
	  
	
	@RequestMapping(value="/history/{vin}",produces = {"application/json"})
	public List<Priorities> showhistory(@PathVariable String vin)
	{
		
		return ps.findone(vin);
	}
	
	@RequestMapping("/location/{vin}")
	public HashMap<Double,Double> locations(@PathVariable String vin)
	{
		List<Reading> readings= rs.findallbyvin(vin);
		Date dt = new Date();
		HashMap<Double,Double> map=new HashMap();
		for(Reading r: readings)
		{
			 long difference = r.getTimestamp().getTime() - dt.getTime();
		       float daysBetween = (difference / (1000*60*60*24));
		       if(daysBetween<1)
		       {
		    	   		int diffInmins = (int)((dt.getTime()/60000) - (r.getTimestamp().getTime()/60000));
		    	   		if(diffInmins<30)
		    	   		{
		    	   			map.put(r.getLongitude(), r.getLatitude());
		    	   		}
		       }
		}

		return map;
	}
	


}
