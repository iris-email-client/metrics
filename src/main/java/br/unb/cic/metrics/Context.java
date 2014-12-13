package br.unb.cic.metrics;

import java.util.HashMap;

import br.unb.cic.metrics.model.Delta;

/**
 * This class represents an execution context 
 * for collecting OO, AOP and Delta metrics. It basically 
 * keeps a list of declared classes, declared aspects and 
 * declared delta modules. 
 * 
 * @author rbonifacio
 *
 */
public class Context {

	private HashMap<String, Delta> deltaModules;

	private static Context instance;
	
	private Context() {
		deltaModules = new HashMap<String, Delta>();
	}
	
	public static Context instance() {
		if(instance == null) {
			instance = new Context();
		}
		return instance;
	}
	
	public void addDeltaModule(Delta module) {
		deltaModules.put(module.getName(), module);
	}
	
}
