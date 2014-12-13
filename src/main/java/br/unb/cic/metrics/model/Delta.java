package br.unb.cic.metrics.model;

import java.util.ArrayList;
import java.util.List;
import br.unb.cic.metrics.model.DeltaMember;

/**
 * Represents a Delta module, from Delta-Oriented 
 * programming.  
 * 
 * @author rbonifacio
 */
public class Delta {

	private String name;
	private List<DeltaMember> members;

	public Delta() {} 
	
	public Delta(String name) {
		this.name = name;
		this.members = new ArrayList<DeltaMember>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DeltaMember> getMembers() {
		return members;
	}

	public void addMember(DeltaMember member) {
		members.add(member);
	}

}
