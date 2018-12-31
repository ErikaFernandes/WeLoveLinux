package com.erika.welovelinux.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erika.welovelinux.repository.CommandRepository;

@Service
public class CommandService {

	@Autowired
	private CommandRepository repository;
	
	public boolean saveCommand(Command command) {
		try {
			repository.save(command);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<Command> getListCommand(){
		List<Command> lc = repository.findAll();
		return lc;
	}
}
