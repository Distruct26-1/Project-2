/*
Team Name: The Penguins
Team Members: Agnes Braz Franco, Cristian Taylor, Dallin Yauney, Kathleen Monahan
Course: CS 2430
Semester: Spring 2026
Project: Programming Project 2 – Sets, Multisets, and Natural-Language Queries
*/

// package project2;

import java.util.Arrays;
import java.util.List;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

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
		OrdinarySets OldFashioned = OrdinarySets.fromIngredients(uniIngredients, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));
		
		// Creating Set B.
        // This represents the ingredients used in the drink Margarita.
		OrdinarySets Margarita = OrdinarySets.fromIngredients(uniIngredients, Arrays.asList(
			"lime juice",
			"simple syrup",
			"tequila"
		));
		
		// Creating Set C.
		// This represents the ingredients used in the drink Vodka Tonic.
		
		OrdinarySets VodkaTonic = OrdinarySets.fromIngredients(uniIngredients, Arrays.asList(
			"vodka",
			"tonic water",
			"lime juice"
		));
		
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
		
		// Print Vodka Tonic set (SET C)
		System.out.println("\nVodka Tonic:");
		System.out.println("Bit representation: " + VodkaTonic.toBitsIngredients());
		System.out.println("Ingredients: " + VodkaTonic.toIngredientsList());
		
		// =======================
		// Ordinary Set Operations
		// =======================

		System.out.println("\n===== Ordinary Set Operations =====");
		System.out.println("\n===== First Test Case =====");

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
		
		//SECOND TEST CASE
		
		System.out.println("\n===== Second Test Case =====");

		// Complement
		OrdinarySets notVodkaTonic = VodkaTonic.complement();

		System.out.println("\nComplement (NOT VodkaTonic):");
		System.out.println("Complement returns all ingredients that are NOT in the Vodka Tonic.");
		System.out.println("Bits: " + notVodkaTonic.toBitsIngredients());
		System.out.println("Ingredients: " + notVodkaTonic.toIngredientsList());


		// Union
		OrdinarySets union2 = VodkaTonic.union(Margarita);

		System.out.println("\nUnion (VodkaTonic ∪ Margarita):");
		System.out.println("Union returns all ingredients that appear in either drink.");
		System.out.println("Bits: " + union2.toBitsIngredients());
		System.out.println("Ingredients: " + union2.toIngredientsList());


		// Intersection
		OrdinarySets intersection2 = VodkaTonic.intersection(Margarita);

		System.out.println("\nIntersection (VodkaTonic ∩ Margarita):");
		System.out.println("Intersection returns only the ingredients both drinks share.");
		System.out.println("Bits: " + intersection2.toBitsIngredients());
		System.out.println("Ingredients: " + intersection2.toIngredientsList());


		// Difference (A - B)
		OrdinarySets difference2 = VodkaTonic.difference(Margarita);

		System.out.println("\nDifference (VodkaTonic − Margarita):");
		System.out.println("Difference returns ingredients in Vodka Tonic that are not in Margarita.");
		System.out.println("Bits: " + difference2.toBitsIngredients());
		System.out.println("Ingredients: " + difference2.toIngredientsList());


		// Symmetric Difference
		OrdinarySets symDiff2 = VodkaTonic.symmetricDifference(Margarita);

		System.out.println("\nSymmetric Difference (VodkaTonic ⊕ Margarita):");
		System.out.println("Symmetric difference returns ingredients that appear in only one drink.");
		System.out.println("Bits: " + symDiff2.toBitsIngredients());
		System.out.println("Ingredients: " + symDiff2.toIngredientsList());
		
		// =======================
		// Multi Set Operations
		// =======================
		
		System.out.println("\n===== Multiset Operations =====");
		
		
		//Order Creation
		//Order A is a large order at a bar on  a Saturday Night
		//Order B is a large order during a Sunday Brunch
		//The Stone Cold order is an Order made by Stone Cold Steve Austin
		List<String> orderA  = Arrays.asList(
			"Beer", "Beer", "Beer",
			"Beer", "Bloody Mary",
			"IPA", "IPA", "Diet Coke",
			"Margarita", "Margarita",
			"Lager", "Lager",
			"Lager", "Lager"
		);

		List<String> orderB  = Arrays.asList(
			"Rose", "Rose", "Margarita",
			"Diet Coke", "Diet Coke",
			"Diet Coke", "Diet Coke",
			"Sparkling Water" ,
			"Sparkling Water",
			"Mimosa", "Mimosa",
			"Chardonnay"
		);

		List<String> orderSC = Arrays.asList(
			"Beer", "Beer", "Beer",
			"Beer", "Beer", "Beer",
			"Beer", "Beer", "Beer",
			"Bloody Mary"
		);

		Multiset<String> SatNightOrder  = HashMultiset.create(orderA);
		Multiset<String> SunBrunchOrder = HashMultiset.create(orderB);
		Multiset<String> StoneColdOrder = HashMultiset.create(orderSC);
		
		
		// Print Saturday Night Order
		System.out.println("\nSaturday Night Order:");
		System.out.println("Order: " + SatNightOrder);


		// Print Sunday Brunch Order
		System.out.println("\nSunday Brunch Order:");
		System.out.println("Order: " + SunBrunchOrder);
		
		// Print The Stone Cold Order
		System.out.println("\nStone Cold Order :");
		System.out.println("Order: " + StoneColdOrder);
		
		//Union
		//Takes the maximum count between both multisets
		Multiset<String> multisetUnion = HashMultiset.create(MultiSets.union(SatNightOrder, SunBrunchOrder));
		
		System.out.println("\nUnion - Sat ∪ Sun:");
		System.out.println("Union returns an order with the maximum value of each drink");
		System.out.println("Order: " + multisetUnion);
		
		//Union
		//Takes the maximum count between both multisets
		Multiset<String> multisetIntersection = HashMultiset.create(MultiSets.intersection(SatNightOrder, SunBrunchOrder));
		
		System.out.println("\nIntersection - Sat ∩ Sun:");
		System.out.println("Intersection returns an order with the minimum value of each drink");
		System.out.println("Order: " + multisetIntersection);
		
		//Union
		//Takes the maximum count between both multisets
		Multiset<String> multisetDifference = HashMultiset.create(MultiSets.difference(SatNightOrder, SunBrunchOrder));
		
		System.out.println("\nDifference - Sat - Sun:");
		System.out.println("Difference subtracts one of the orders from the othe, but doesn't go less than zero");
		System.out.println("This example subtracts The Sunday Brunch from the Saturday Night");
		System.out.println("Order: " + multisetDifference);
		
		//Union
		//Takes the maximum count between both multisets
		Multiset<String> multisetSum = HashMultiset.create(MultiSets.sum(SatNightOrder, SunBrunchOrder));
		
		System.out.println("\nSum - Sat + Sun:");
		System.out.println("Sum adds the two orders together making one giant order");
		System.out.println("Order: " + multisetSum);
	}
}