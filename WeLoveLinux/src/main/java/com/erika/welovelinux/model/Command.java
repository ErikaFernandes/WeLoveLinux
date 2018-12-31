package com.erika.welovelinux.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

@Entity
public class Command {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cmd;
	
	@NotNull
	private String cmd;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,mappedBy="Command")
	public Long getId_cmd() {
		return id_cmd; 
	} 
	public void setId_cmd(Long id_cmd) {
		this.id_cmd = id_cmd;
	}
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_cmd == null) ? 0 : id_cmd.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Command other = (Command) obj;
		if (id_cmd == null) {
			if (other.id_cmd != null)
				return false;
		} else if (!id_cmd.equals(other.id_cmd))
			return false;
		return true;
	}
	
	
	
}
