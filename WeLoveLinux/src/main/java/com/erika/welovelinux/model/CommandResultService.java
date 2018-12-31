package com.erika.welovelinux.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erika.welovelinux.repository.CommandResultRepository;

@Service
public class CommandResultService {

	@Autowired
	private CommandResultRepository repository;
	
	public boolean saveCommandResult(List<CommandResult> commandResultList) {
		try {
			repository.saveAll(commandResultList);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public List<CommandResult> getAllResults(){
		List<CommandResult> crl = repository.findAll();
		return crl;
	}
	
}
