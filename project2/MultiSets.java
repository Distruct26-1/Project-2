package project2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSets {

	public static UniversalSet uniDrinks = new UniversalSet(
			Arrays.asList("Lager", "IPA", "Beer", "Chardonnay", "Pinot Noir", "Rose", "Mimosa", "Margarita",
					"Bloody Mary", "Shirley Temple", "Diet Coke", "Sparkling Water"));

	public static List<String> check = uniDrinks.getIngredients();

	// This method is to convert whatever array that was entered into a Multiset
	public static Multiset<String> createFromOrders(String[] initOrder) {
		List<String> orderList = Arrays.asList(initOrder);
		Multiset<String> order = HashMultiset.create(orderList);
		return order;
	}

	// This method goes through each value in orderA and B and add them
	public static Multiset<String> union(Multiset<?> orderA, Multiset<?> orderB) {
		Multiset<String> maxOrder = HashMultiset.create();

		for (int i = 0; i < 12; i++) {
			if (orderA.contains(check.get(i)) || orderB.contains(check.get(i))) {
				if (orderA.count(check.get(i)) >= orderB.count(check.get(i))) {
					maxOrder.add(check.get(i), orderA.count(check.get(i)));
				} else {
					maxOrder.add(check.get(i), orderB.count(check.get(i)));
				}
			}
		}
		return maxOrder;
	}

	public static Multiset<String> intersection(Multiset<?> orderA, Multiset<?> orderB) {
		Multiset<String> minOrder = HashMultiset.create();

		for (int i = 0; i < 12; i++) {
			if (orderA.contains(check.get(i)) || orderB.contains(check.get(i))) {
				if (orderA.count(check.get(i)) <= orderB.count(check.get(i))) {
					minOrder.add(check.get(i), orderA.count(check.get(i)));
				} else {
					minOrder.add(check.get(i), orderB.count(check.get(i)));
				}
			}
		}

		return minOrder;

	}

	public static Multiset<String> difference(Multiset<?> orderA, Multiset<?> orderB) {
		Multiset<String> diff = HashMultiset.create();
		int sub;

		for (int i = 0; i < 12; i++) {
			if (orderB.contains(check.get(i))) {
				sub = orderA.count(check.get(i)) - orderB.count(check.get(i));
				if (sub < 0) {
					sub = 0;
				}
				diff.add(check.get(i), sub);
			}
		}

		return diff;
	}

	// Adds both of the orders together
	public static Multiset<String> sum(Multiset<String> orderA, Multiset<String> orderB) {
		Multiset<String> added = HashMultiset.create(orderA);
		added.addAll(orderB);
		return added;
	}

	public static void main(String[] args) {
		String[] orderA = { "Beer", "Beer", "Beer", "Beer", "Margarita", "Diet Coke", "Diet Coke", "Sparkling Water",
				"Sparkling Water", "Mimosa", "Mimosa" };

		List<String> orderB = Arrays.asList("Beer", "Beer", "Beer", "Beer", "Margarita", "Diet Coke", "Diet Coke",
				"Sparkling Water", "Sparkling Water", "Mimosa", "Mimosa");
		List<String> orderSC = Arrays.asList("Beer", "Beer", "Beer", "Beer", "Beer", "Beer", "Beer", "Beer", "Beer",
				"Bloody Mary");

		Multiset<String> SatNightOrder = HashMultiset.create(createFromOrders(orderA));
		Multiset<String> SunBrunchOrder = HashMultiset.create(orderB);
		Multiset<String> StoneColdOrder = HashMultiset.create(orderSC);

		// ========== createFromOrders tests ==========
		System.out.println("= = = createFromOrders tests = = =");
		System.out.println("beer_count            | expect: 4 | actual: " + SatNightOrder.count("Beer"));
		System.out.println("margarita_count       | expect: 1 | actual: " + SatNightOrder.count("Margarita"));
		System.out.println("diet_coke_count       | expect: 2 | actual: " + SatNightOrder.count("Diet Coke"));
		System.out.println("not_in_order          | expect: 0 | actual: " + SatNightOrder.count("Lager"));

		System.out.println();

		// ========== union tests ==========
		System.out.println("= = = union tests = = =");
		Multiset<String> unionResult = union(SatNightOrder, StoneColdOrder);
		System.out.println("union_beer            | expect: 9 | actual: " + unionResult.count("Beer"));
		System.out.println("union_bloody_mary     | expect: 1 | actual: " + unionResult.count("Bloody Mary"));
		System.out.println("union_mimosa          | expect: 2 | actual: " + unionResult.count("Mimosa"));
		System.out.println("union_not_in_either   | expect: 0 | actual: " + unionResult.count("Lager"));

		System.out.println();

		// ========== intersection tests ==========
		System.out.println("= = = intersection tests = = =");
		Multiset<String> interResult = intersection(SatNightOrder, StoneColdOrder);
		System.out.println("inter_mimosa_not_in_SC | expect: 0 | actual: " + interResult.count("Mimosa"));
		System.out.println("inter_bloody_not_in_sat| expect: 0 | actual: " + interResult.count("Bloody Mary"));
		System.out.println("inter_beer_sat_SC     | expect: 4 | actual: " + interResult.count("Beer"));

		System.out.println();

		// ========== difference tests ==========
		System.out.println("= = = difference tests = = =");
		Multiset<String> diffResult = difference(SatNightOrder, SunBrunchOrder);
		System.out.println("diff_equal_orders     | expect: 0 | actual: " + diffResult.count("Beer"));
		Multiset<String> diffResult2 = difference(StoneColdOrder, SatNightOrder);
		System.out.println("diff_beer_stonecold   | expect: 5 | actual: " + diffResult2.count("Beer"));
		System.out.println("diff_not_in_b         | expect: 0 | actual: " + diffResult2.count("Lager"));

		System.out.println();

		// ========== sum tests ==========
		System.out.println("= = = sum tests = = =");
		Multiset<String> sumResult = sum(StoneColdOrder, SunBrunchOrder);
		System.out.println("sum_beer              | expect: 13 | actual: " + sumResult.count("Beer"));
		System.out.println("sum_bloody_mary       | expect: 1  | actual: " + sumResult.count("Bloody Mary"));
		System.out.println("sum_mimosa            | expect: 2  | actual: " + sumResult.count("Mimosa"));
		System.out.println("sum_not_in_either     | expect: 0  | actual: " + sumResult.count("Lager"));

	}

}
