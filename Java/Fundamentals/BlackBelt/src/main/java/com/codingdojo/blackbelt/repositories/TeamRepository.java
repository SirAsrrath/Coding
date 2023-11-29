package com.codingdojo.blackbelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.blackbelt.models.Team;
import com.codingdojo.blackbelt.models.User;

@Repository
public interface TeamRepository extends CrudRepository<Team ,Long>{
	List<Team> findAll();
	List<Team>findAllByUser(User user);
}
