package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Priorities;
import com.example.demo.Entity.Reading;
import com.example.demo.Entity.Tires;
import com.example.demo.Entity.Vehicles;
import com.example.demo.Repositories.PriorityRepo;

@Service
public class PService {
	
	@Autowired
	PriorityRepo pr;
	
	@Autowired
	VehicleService vs;
	
	@Autowired
	ReadingService rs;
	
	@Autowired
	TireService ts;
	
	
	public List<Priorities> findHigh()
	{
		List<Priorities> pv= new ArrayList();
		Date dt = new Date();
		int hours = dt.getHours();
		
		Priorities p=new Priorities();
		for(Vehicles vehicle:vs.findall())
		{
			System.out.println("new model is "+vehicle.getModel());
		    float fuel=(float) (vehicle.getMaxFuelVolume()-(vehicle.getMaxFuelVolume()*0.10));
			List<Reading> readings=rs.findallbyvin(vehicle.getVin());
			for(Reading r:readings)
			{
				int t1=r.getTires().getId();
				Tires t=ts.findone(t1);
				if(r.getEngineRpm()> vehicle.getRedlineRpm())
				{
					p.setPriority("HIGH");
				}
				else if(r.getFuelVolume()< fuel )
				{
					p.setPriority("Medium");
				}
			    else if(r.isEngineCoolantLow() ==true || r.isCheckEngineLightOn()==true)
				{
					p.setPriority("LOW");
				}
			    else	 if(t.getFrontLeft()<32 || t.getFrontLeft()<32 )
				{
					p.setPriority("LOW");
				}
			    else if(t.getFrontRight()<32 || t.getFrontRight()>36)
				{
					p.setPriority("LOW");
				}	
			    else if(t.getRearLeft()<32 || t.getRearLeft()>36)
				{
					p.setPriority("LOW");
				}
			    else if(t.getRearRight()<32 || t.getRearRight()>36)
				{
					p.setPriority("LOW");
				}
			    
				p.setTimestamp(r.getTimestamp());
				p.setVin(r.getVin());
				pr.save(p);
			}
			
		}
		
		pv=pr.findAllByPriority("HIGH");
		List<Priorities> prs=new ArrayList();
		if(pv.isEmpty())
		{
			 prs=pv;
		for(Priorities p1:prs)
		{
			if( Math.abs(p1.getTimestamp().getHours()- hours)>2) 
			{
				prs.add(p1);
			}
		}
		return prs;
		}
		return prs;
	}
	
	
	public List<Priorities> findone(String vin)
	{
		
		return pr.findAllByVin(vin);
	}

}
