package com.example.webapp.firstWebApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webapp.firstWebApp.entity.Todo;

@Repository
public interface EntityRepository extends JpaRepository<Todo, Integer> {

	//public List<Todo> findByUsername(String name);
	  public List<Todo> findByName(String name);

}
