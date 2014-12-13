package br.unb.cic.metrics.model;

import java.util.List;

/**
 * Represents an attribute of a class
 * 
 * @author rbonifacio
 */
public class Attribute {

	private List<String> modifiers;
	private String type;
	private String name;

	public Attribute(List<String> modifiers, String type, String name) {
		this.modifiers = modifiers;
		this.type = type;
		this.name = name;
	}

	public List<String> getModifiers() {
		return modifiers;
	}

	public void setModifiers(List<String> modifiers) {
		this.modifiers = modifiers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
