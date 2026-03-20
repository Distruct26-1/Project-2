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

public class MultiSets {
	public static UniversalSet uniDrinks = new UniversalSet(Arrays.asList(
		"Lager",
		"IPA",
		"Beer",
		"Chardonnay",
		"Pinot Noir",
		"Rose",
		"Mimosa",
		"Margarita",
		"Bloody Mary",
		"Shirley Temple",
		"Diet Coke",
		"Sparkling Water"
	));
	
	public static List<String> check = uniDrinks.getIngredients();
	
	//This method is to convert whatever array that was entered into a Multiset
	public static Multiset<String> createFromOrders(String[] initOrder) {
		List<String> orderList = Arrays.asList(initOrder);
		Multiset<String> order = HashMultiset.create(orderList);
		return order;
	}
	
	//This method goes through each value in orderA and B and add them
	public static Multiset<String> union(Multiset<String> orderA, Multiset<String> orderB) {
		Multiset<String> maxOrder = HashMultiset.create();
		
		for(int i = 0; i < 12; i++) {
			if(orderA.contains(check.get(i)) || orderB.contains(check.get(i))) {
				if(orderA.count(check.get(i)) >= orderB.count(check.get(i))) {
					maxOrder.add(check.get(i), orderA.count(check.get(i)));
				} else {
					maxOrder.add(check.get(i), orderB.count(check.get(i)));
				}
			}
		}
		return maxOrder;
	}
	
	public static Multiset<String> intersection(Multiset<String> orderA, Multiset<String> orderB) {
		Multiset<String> minOrder = HashMultiset.create();
		
		for(int i = 0; i < 12; i++) {
			if(orderA.contains(check.get(i)) || orderB.contains(check.get(i))) {
				if(orderA.count(check.get(i)) <= orderB.count(check.get(i))) {
					minOrder.add(check.get(i), orderA.count(check.get(i)));
				} else {
					minOrder.add(check.get(i), orderB.count(check.get(i)));
				}
			}
		}
		
		return minOrder;
	}
	
	public static Multiset<String> difference(Multiset<String> orderA, Multiset<String> orderB) {
		Multiset<String> diff = HashMultiset.create();
		int sub;
		
		for(int i = 0; i < 12; i++) {
			sub = orderA.count(check.get(i)) - orderB.count(check.get(i));
			if(sub < 0 ) {
				sub = 0;
			}
			diff.add(check.get(i), sub);
		}
		
		return diff;
	}
	
	//Adds both of the orders together
	public static Multiset<String> sum(Multiset<String> orderA, Multiset<String> orderB) {
		Multiset<String> added = HashMultiset.create(orderA);
		added.addAll(orderB);
		return added;
	}

	public static void main(String[] args) {
		// String[] orderA = {
		// 	"Beer",
		// 	"Beer",
		// 	"Beer",
		// 	"Beer",
		// 	"Margarita",
		// 	"Diet Coke",
		// 	"Diet Coke",
		// 	"Sparkling Water",
		// 	"Sparkling Water",
		// 	"Mimosa",
		// 	"Mimosa"
		// };
		
		String[] orderB = {
			"Beer",
			"Beer",
			"Beer",
			"Beer",
			"Margarita",
			"Diet Coke",
			"Diet Coke",
			"Sparkling Water",
			"Sparkling Water",
			"Mimosa",
			"Mimosa"
		};

		String[] orderSC = {
			"Beer",
			"Beer",
			"Beer",
			"Beer",
			"Beer",
			"Beer",
			"Beer",
			"Beer",
			"Beer",
			"Bloody Mary"
		};
		
		// Multiset<String> SatNightOrder  = createFromOrders(orderA);
		Multiset<String> SunBrunchOrder = createFromOrders(orderB);
		Multiset<String> StoneColdOrder = createFromOrders(orderSC);
		
		Multiset<String> tester = HashMultiset.create(difference(StoneColdOrder, SunBrunchOrder));
		
		for(int i=0; i<12; i++) {
			System.out.print(check.get(i) + " " + tester.count(check.get(i)) + " ");
		}
		
	}

}
