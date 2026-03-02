package project2;

import java.util.ArrayList;
import java.util.List;

public class UniversalSet {
	
	//List of drinks
	private List<String> drinks;
	
	//Constructor Method
	
	public UniversalSet(List<String> drinks) {
		
		this.drinks = new ArrayList<>();
		
		for (int i=0; i < drinks.size(); i++) {
			String name = drinks.get(i);
			
			this.drinks.add(name);	
		}
	}
	
	//Returns number of drinks in Universal Set
	public int size() {
		return drinks.size();
	}
	
	//Returns list of elements in Universal Set
	public List<String> getDrinks() {
		return new ArrayList<>(drinks);	
	}

	@Override
	public String toString() {
		return "UniversalSet drinks=" + drinks;
	}
	
}