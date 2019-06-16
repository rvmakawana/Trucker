package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Tires;

public interface TireRepo extends CrudRepository<Tires, Integer> {

}
