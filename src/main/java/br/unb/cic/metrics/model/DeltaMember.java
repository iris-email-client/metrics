package br.unb.cic.metrics.model;

/**
 * Represents a DeltaMember, which could 
 * be a module addition, a module modification, 
 * or a module exclusion. 
 * 
 * @author rbonifacio
 */
public class DeltaMember {

	enum Type {Adds, Modifies, Removes};

	private Type type;

	public DeltaMember(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
}
