package project2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSets {
	
	public static UniversalSet uniDrinks = new UniversalSet(Arrays.asList("Lager", "IPA", "Beer", "Chardonnay", "Pinot Noir",
			"Rose", "Mimosa", "Margarita","Bloody Mary", "Shirley Temple", "Diet Coke", "Sparkling Water"));
	
	public static List<String> check = uniDrinks.getIngredients();
	
	//This method is to convert whatever array that was entered into a Multiset
	public static Multiset createFromOrders(String[] initOrder) {
		List<String> orderList = Arrays.asList(initOrder);
		Multiset<String> order = HashMultiset.create(orderList);
		return order;
	}
	
	//This method goes through each value in orderA and B and add them
	public static Multiset union(Multiset orderA, Multiset orderB) {
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
	
	
	public static Multiset intersection(Multiset orderA, Multiset orderB) {
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
	
	public static Multiset difference(Multiset orderA, Multiset orderB) {
		Multiset<String> diff = HashMultiset.create();
		int sub;
		
		for(int i = 0; i < 12; i++) {
			if(orderB.contains(check.get(i))) {
				sub = orderA.count(check.get(i)) - orderB.count(check.get(i));
				if(sub < 0 ) {
					sub = 0;
				}
				diff.add(check.get(i), sub);
			}
		}
		
		return diff;
	}
	
	//Adds both of the orders together
	public static Multiset sum(Multiset orderA, Multiset orderB) {
		Multiset<String> added = HashMultiset.create(orderA);
		added.addAll(orderB);
		return added;
	}


	
	public static void main(String[] args) {
		String[] orderA = {"Beer", "Beer", "Beer", "Beer", "Margarita", "Diet Coke", "Diet Coke", "Sparkling Water", "Sparkling Water", "Mimosa", "Mimosa"};
		
		
		List<String> orderB = Arrays.asList("Beer", "Beer", "Beer", "Beer", "Margarita", "Diet Coke", "Diet Coke", "Sparkling Water", "Sparkling Water", "Mimosa", "Mimosa");
		List<String> orderSC = Arrays.asList("Beer", "Beer", "Beer", "Beer", "Beer", "Beer", "Beer", "Beer", "Beer", "Bloody Mary");
		
		Multiset<String> SatNightOrder = HashMultiset.create(createFromOrders(orderA));
		Multiset<String> SunBrunchOrder = HashMultiset.create(orderB);
		Multiset<String> StoneColdOrder = HashMultiset.create(orderSC);
		
		Multiset<String> tester = HashMultiset.create(sum(StoneColdOrder, SunBrunchOrder));
		
		
		
		for(int i =0;i<12;i++) {
			System.out.print(check.get(i) + " " + tester.count(check.get(i)) + " ");
		}
		
	}

}
