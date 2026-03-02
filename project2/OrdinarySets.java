package project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrdinarySets {
	
	private UniversalSet ingredients;
	
	private boolean[] contains;
	
	//Constructor
	
	public OrdinarySets(UniversalSet ingredients) {
		
		this.ingredients = ingredients;
		
		// Length must match universe size.
		this.contains = new boolean[ingredients.size()];
	}
	
	public OrdinarySets(UniversalSet Ingredients, boolean[] initialIngredients) {
		this.ingredients = ingredients;
		this.contains = Arrays.copyOf(initialIngredients, initialIngredients.length);
	}
	
	public static OrdinarySets fromIngredients(UniversalSet ingredients, List<String> recipe) {
		OrdinarySets printout = new OrdinarySets(ingredients);
		
		for (String ingredient : recipe) {
			// UniversalSet.indexOf() should validate that ingredient exists in the Universe.
			int index = ingredients.indexOf(ingredient);
			printout.contains[index] = true;
			
		}
		return printout;
	}
	
	public String toBitsIngredients() {
		StringBuilder sb = new StringBuilder(contains.length);
		for (boolean b : contains) {
			sb.append(b ? '1' : '0');
		}
		return sb.toString();
	}
	
	public List<String> toIngredientsList() {
		List<String> out = new ArrayList<>();
		List<String> universeIngredients = ingredients.getIngredients();
		
		for (int i = 0; i < contains.length; i++) {
			if (contains[i]) {
				out.add(universeIngredients.get(i));
			}
		}
		return out;
	}
	
	public OrdinarySets complement() {
		boolean[] bitArray = new boolean[contains.length];
		
		for (int i = 0; i < contains.length; i++) {
			bitArray[i] = !contains[i];
		}
		
		return new OrdinarySets(ingredients, bitArray);
	}

}