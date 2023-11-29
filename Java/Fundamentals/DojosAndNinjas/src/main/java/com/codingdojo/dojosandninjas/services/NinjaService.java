package com.codingdojo.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
    
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    
    public List<Ninja> findAll() {
        return ninjaRepository.findAll();
    }

    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
   
    public Ninja findById(Long id) {
        Optional<Ninja> result = ninjaRepository.findById(id);
        if(result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }
    public List<Ninja> findByDojo(Dojo dojo) {
    	return ninjaRepository.findAllByDojo(dojo);
    }
}