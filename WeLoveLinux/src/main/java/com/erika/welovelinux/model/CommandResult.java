package com.erika.welovelinux.model;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Entity;

@Entity
public class CommandResult { 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCR;
	
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="id")
	private Command idfk;
	
	private String line;
	
	
	public Long getIdCR() {
		return idCR;
	}
	public void setIdCR(Long idCR) {
		this.idCR = idCR;
	}
	public Command getIdfk() {
		return idfk;
	}
	public void setIdfk(Command idfk) {
		this.idfk = idfk;
	}
	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCR == null) ? 0 : idCR.hashCode());
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
		CommandResult other = (CommandResult) obj;
		if (idCR == null) {
			if (other.idCR != null)
				return false;
		} else if (!idCR.equals(other.idCR))
			return false;
		return true;
	}
	
	
	
	
}
