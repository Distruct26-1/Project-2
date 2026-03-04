/*
Team Name: The Penguins
Team Members: Agnes Braz Franco, Cristian Taylor, Dallin Yauney, Kathleen Monahan
Course: CS 2430
Semester: Spring 2026
Project: Programming Project 2 – Sets, Multisets, and Natural-Language Queries
*/

package project2;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		// Creating the UNIVERSAL SET.
		// This is the full list of ingredients that exist in our system.
		
		UniversalSet uniIngredients = new UniversalSet(Arrays.asList(
				"lime juice", "simple syrup", "bitters", "olives", 
				"bloody mary mix", "sweet vermouth", "soda water", 
				"tonic water", "lemon juice", "whiskey", "tequila", "vodka"));
		
		// Creating Set A.
        // This represents the ingredients used in the drink Old Fashioned.
        // The method fromIngredients() converts the ingredient names into a Boolean array.
		
		OrdinarySets OldFashioned = OrdinarySets.fromIngredients(uniIngredients, Arrays.asList("simple syrup", "bitters", "whiskey"));
		
		// Creating Set B.
        // This represents the ingredients used in the drink Margarita.
		
		OrdinarySets Margarita = OrdinarySets.fromIngredients(uniIngredients, Arrays.asList("lime juice", "simple syrup", "tequila"));
		
		// Printing the universal set so we know the order of the ingredients.
        // The order matters because each position corresponds to a bit in the bit string.
		
		System.out.println("Universal Set (all possible ingredients)");
		System.out.println(uniIngredients);
		
		// Print Old Fashioned set (SET A)
		System.out.println("\nOld Fashioned:");
		System.out.println("Bit representation: " + OldFashioned.toBitsIngredients());
		System.out.println("Ingredients: " + OldFashioned.toIngredientsList());
		
		// Print Margarita set (SET B)
		System.out.println("\nMargarita:");
		System.out.println("Bit representation: " + Margarita.toBitsIngredients());
		System.out.println("Ingredients: " + Margarita.toIngredientsList());
		
		// =======================
		// Ordinary Set Operations
		// =======================

		System.out.println("\n===== Ordinary Set Operations =====");

		// Complement
		// Returns everything that is NOT in the Old Fashioned cocktail
		OrdinarySets notOldFashioned = OldFashioned.complement();

		System.out.println("\nComplement (NOT OldFashioned):");
		System.out.println("Complement returns all ingredients that are NOT in the Old Fashioned cocktail.");
		System.out.println("Bits: " + notOldFashioned.toBitsIngredients());
		System.out.println("Ingredients: " + notOldFashioned.toIngredientsList());


		// Union
		// Returns every ingredient that appears in OldFashioned OR Margarita
		OrdinarySets union = OldFashioned.union(Margarita);

		System.out.println("\nUnion (OldFashioned ∪ Margarita):");
		System.out.println("Union returns all ingredients that appear in either cocktail.");
		System.out.println("Bits: " + union.toBitsIngredients());
		System.out.println("Ingredients: " + union.toIngredientsList());


		// Intersection
		// Returns only ingredients that BOTH cocktails share
		OrdinarySets intersection = OldFashioned.intersection(Margarita);

		System.out.println("\nIntersection (OldFashioned ∩ Margarita):");
		System.out.println("Intersection returns only the ingredients both cocktails share.");
		System.out.println("Bits: " + intersection.toBitsIngredients());
		System.out.println("Ingredients: " + intersection.toIngredientsList());


		// Set Difference (A - B)
		// Returns ingredients that exist in OldFashioned but NOT in Margarita
		OrdinarySets difference = OldFashioned.difference(Margarita);

		System.out.println("\nDifference (OldFashioned − Margarita):");
		System.out.println("Difference returns ingredients in Old Fashioned that are not in Margarita.");
		System.out.println("Bits: " + difference.toBitsIngredients());
		System.out.println("Ingredients: " + difference.toIngredientsList());


		// Symmetric Difference (A − B) ∪ (B − A)
		// Returns ingredients that appear in only ONE cocktail
		OrdinarySets symDiff = OldFashioned.symmetricDifference(Margarita);

		System.out.println("\nSymmetric Difference (OldFashioned ⊕ Margarita):");
		System.out.println("Symmetric difference returns ingredients that appear in only one cocktail.");
		System.out.println("Bits: " + symDiff.toBitsIngredients());
		System.out.println("Ingredients: " + symDiff.toIngredientsList());
		
	}
}