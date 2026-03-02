package project2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		UniversalSet uniIngredients = new UniversalSet(Arrays.asList("lime juice", "simple syrup", "bitters", "olives", 
				"bloody mary mix", "sweet vermouth", "soda water", "tonic water", "lemon juice", 
				"whiskey", "tequila", "vodka"));
		OrdinarySets OldFashioned = OrdinarySets.fromIngredients(uniIngredients, Arrays.asList("simple syrup", "bitters", "whiskey"));
		OrdinarySets Margarita = OrdinarySets.fromIngredients(uniIngredients, Arrays.asList("lime juice", "simple syrup", "tequila"));
		
		System.out.println(uniIngredients);
		System.out.println(OldFashioned.toBitsIngredients());
		System.out.println(Margarita.toBitsIngredients());
		

	}
}
