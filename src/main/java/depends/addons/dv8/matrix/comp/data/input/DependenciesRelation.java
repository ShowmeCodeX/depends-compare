package depends.addons.dv8.matrix.comp.data.input;

import java.util.HashMap;

public class DependenciesRelation {

	private String[] variables;
	private HashMap<String,DependencyPair> pairs;
	
	public DependenciesRelation() {
		pairs = new HashMap<>();
	}
	public void addDependencies(String type, int src, int dest, double weight) {
		if (!pairs.containsKey(key(src, dest))) {
			pairs.put(key(src, dest), new DependencyPair(src, dest));
		}
		DependencyPair pair = pairs.get(key(src, dest));
		pair.setDependency(type,weight);
	}

	private String key(int src, int dest) {
		return variables[src]+"-->"+variables[dest];
	}
	public void addVariables(String[] variables) {
		this.variables = variables;
	}
	
	public String[] getVariables() {
		return variables;
	}
	public HashMap<String, DependencyPair> getPairs() {
		return pairs;
	}

}
