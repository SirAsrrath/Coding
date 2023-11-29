package com.codingdojo.blackbelt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.blackbelt.models.Team;
import com.codingdojo.blackbelt.models.User;
import com.codingdojo.blackbelt.repositories.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private final TeamRepository teamRepository;
	
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	public List<Team> findAll(){
		return teamRepository.findAll();
	}
	
	public Team createTeam(Team team) {
	
		return teamRepository.save(team);
	}
	
	public Team findById(Long id) {
		Optional<Team> result = teamRepository.findById(id);
		if(result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
	}
	
	public Team updateTeam(Team team) {
		Optional<Team> optionalTeam = teamRepository.findById(team.getId());
		
		if(optionalTeam.isPresent()) {
			Team thisTeam = optionalTeam.get();
			thisTeam.setName(team.getName());
			thisTeam.setGameday(team.getGameday());
			thisTeam.setSkill(team.getSkill());
			return teamRepository.save(thisTeam);
		}
		else {
			return null;
		}
	}
	
	public void deleteTeam(Team team) {
		teamRepository.delete(team);
	}
	
	public List<Team> findByUser(User user){
		return teamRepository.findAllByUser(user);
	}
	
	
}
