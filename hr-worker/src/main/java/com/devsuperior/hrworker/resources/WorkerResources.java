package com.devsuperior.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value= "/workers")
public class WorkerResources {

	@Autowired
	private Environment env;
	
	private static Logger log = LoggerFactory.getLogger(WorkerResources.class);
	
	@Autowired
	private WorkerRepository workerRepository;
	
	
	@RequestMapping("/all")
	public ResponseEntity<List<Worker>> findAll(){
		
		List<Worker> lista = workerRepository.findAll();
		
		return ResponseEntity.ok(lista);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById( @PathVariable Long id){
		
		
		log.info("Port: " + env.getProperty("local.server.port"));
		
		Optional<Worker> worker =  workerRepository.findById(id);
		
		return ResponseEntity.ok().body(worker.orElseThrow());
	}
	
	
	
	
}
