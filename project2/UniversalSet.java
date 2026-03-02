package project2;

import java.util.ArrayList;
import java.util.List;

public class UniversalSet {
	
	//List of drinks
	private List<String> ingredients;
	
	//Constructor Method
	
	public UniversalSet(List<String> ingredients) {
		
		this.ingredients = new ArrayList<>();
		
		for (int i=0; i < ingredients.size(); i++) {
			String name = ingredients.get(i);
			
			this.ingredients.add(name);	
		}
	}
	
	//Returns number of drinks in Universal Set
	public int size() {
		return ingredients.size();
	}
	
	//Returns list of elements in Universal Set
	public List<String> getDrinks() {
		return new ArrayList<>(ingredients);	
	}

	@Override
	public String toString() {
		return "UniversalSet ingredients=" + ingredients;
	}
	
}