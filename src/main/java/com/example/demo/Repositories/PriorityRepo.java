package com.example.demo.Repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Priorities;

public interface PriorityRepo extends CrudRepository<Priorities, Integer> {

	@Transactional
	List<Priorities> findAllByPriority(String pr);
	
	@Transactional
	List<Priorities> findAllByVin(String vin);
}
