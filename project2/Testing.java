// package project2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class Testing {

    UniversalSet universe;

    @BeforeEach
    public void setupUniverse() {
        universe = new UniversalSet(Arrays.asList(
            "lime juice", "simple syrup", "bitters", "olives", 
            "bloody mary mix", "sweet vermouth", "soda water", 
            "tonic water", "lemon juice", "whiskey", "tequila", "vodka"
        ));
    }

    // @Test
    // public void sanityCheck() {
	// 	OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
	// 		"simple syrup",
	// 		"bitters",
	// 		"whiskey"
	// 	));

	// 	OrdinarySets margarita = OrdinarySets.fromIngredients(universe, Arrays.asList(
	// 		"lime juice",
	// 		"simple syrup",
	// 		"tequila"
	// 	));

    //     OrdinarySets union = oldFashioned.union(margarita);
    //     assertIterableEquals(union.toIngredientsList(), Arrays.asList(
    //         "lime juice", "simple syrup", "bitters", "whiskey", "tequila"
    //     ));
    // }
    
    @Test
    public void setComplementNormal() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

        OrdinarySets complement = oldFashioned.complement();
        assertIterableEquals(complement.toIngredientsList(), Arrays.asList(
            "lime juice", "olives", "bloody mary mix",
            "sweet vermouth", "soda water",
            "tonic water", "lemon juice", "tequila", "vodka"
        ));
    }

    @Test
    public void setUnionNormal() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

		OrdinarySets margarita = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"lime juice",
			"simple syrup",
			"tequila"
		));

        OrdinarySets union = oldFashioned.union(margarita);
        assertIterableEquals(union.toIngredientsList(), Arrays.asList(
            "lime juice", "simple syrup", "bitters", "whiskey", "tequila"
        ));
    }

    @Test
    public void setIntersectionNormal() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

		OrdinarySets margarita = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"lime juice",
			"simple syrup",
			"tequila"
		));

        OrdinarySets intersection = oldFashioned.intersection(margarita);
        assertIterableEquals(intersection.toIngredientsList(), Arrays.asList(
           "simple syrup"
        ));
    }

    @Test
    public void setDifferenceNormal() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

		OrdinarySets margarita = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"lime juice",
			"simple syrup",
			"tequila"
		));

        OrdinarySets difference = oldFashioned.difference(margarita);
        assertIterableEquals(difference.toIngredientsList(), Arrays.asList(
            "bitters", "whiskey"
        ));
    }

    @Test
    public void setExDifferenceNormal() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

		OrdinarySets margarita = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"lime juice",
			"simple syrup",
			"tequila"
		));

        OrdinarySets xor = oldFashioned.symmetricDifference(margarita);
        assertIterableEquals(xor.toIngredientsList(), Arrays.asList(
            "lime juice", "bitters", "whiskey", "tequila"
        ));
    }

    @Test
    public void setComplementEmpty() {
        OrdinarySets empty = OrdinarySets.fromIngredients(universe, Arrays.asList());

        assertIterableEquals(empty.complement().toIngredientsList(), universe.getIngredients());
    }

    @Test
    public void setUnionSingleEmpty() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

		OrdinarySets empty = OrdinarySets.fromIngredients(universe, Arrays.asList());

        OrdinarySets union = oldFashioned.union(empty);
        assertIterableEquals(union.toIngredientsList(), Arrays.asList(
            "simple syrup", "bitters", "whiskey"
        ));
    }

    @Test
    public void setUnionDoubleEmpty() {
		OrdinarySets empty1 = OrdinarySets.fromIngredients(universe, Arrays.asList());

		OrdinarySets empty2 = OrdinarySets.fromIngredients(universe, Arrays.asList());

        OrdinarySets union = empty1.union(empty2);
        assertIterableEquals(union.toIngredientsList(), Arrays.asList());
    }

    @Test
    public void setDifferenceSingleEmpty() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

		OrdinarySets empty = OrdinarySets.fromIngredients(universe, Arrays.asList());

        OrdinarySets difference = oldFashioned.difference(empty);
        assertIterableEquals(difference.toIngredientsList(), Arrays.asList(
            "simple syrup", "bitters", "whiskey"
        ));
    }

    @Test
    public void setDifferenceDoubleEmpty() {
		OrdinarySets empty1 = OrdinarySets.fromIngredients(universe, Arrays.asList());

		OrdinarySets empty2 = OrdinarySets.fromIngredients(universe, Arrays.asList());

        OrdinarySets difference = empty1.difference(empty2);
        assertIterableEquals(difference.toIngredientsList(), Arrays.asList());
    }

    @Test
    public void setIntersectionSingleEmpty() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

		OrdinarySets empty = OrdinarySets.fromIngredients(universe, Arrays.asList());

        OrdinarySets intersection = oldFashioned.intersection(empty);
        assertIterableEquals(intersection.toIngredientsList(), Arrays.asList());
    }

    @Test
    public void setIntersectionDoubleEmpty() {
		OrdinarySets empty1 = OrdinarySets.fromIngredients(universe, Arrays.asList());

		OrdinarySets empty2 = OrdinarySets.fromIngredients(universe, Arrays.asList());

        OrdinarySets intersection = empty1.intersection(empty2);
        assertIterableEquals(intersection.toIngredientsList(), Arrays.asList());
    }

    @Test
    public void setXorSingleEmpty() {
		OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
			"simple syrup",
			"bitters",
			"whiskey"
		));

		OrdinarySets empty = OrdinarySets.fromIngredients(universe, Arrays.asList());

        OrdinarySets xor = oldFashioned.symmetricDifference(empty);
        assertIterableEquals(xor.toIngredientsList(), Arrays.asList(
            "simple syrup", "bitters", "whiskey"
        ));
    }

    @Test
    public void setXorDoubleEmpty() {
		OrdinarySets empty1 = OrdinarySets.fromIngredients(universe, Arrays.asList());

		OrdinarySets empty2 = OrdinarySets.fromIngredients(universe, Arrays.asList());

        OrdinarySets xor = empty1.symmetricDifference(empty2);
        assertIterableEquals(xor.toIngredientsList(), Arrays.asList());
    }

    @Test
    public void setUnionDuplicate() {
        OrdinarySets first = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        OrdinarySets second = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        OrdinarySets union = first.union(second);
        assertIterableEquals(union.toIngredientsList(), first.toIngredientsList());
    }


    @Test
    public void setIntersectionDuplicate() {
        OrdinarySets first = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        OrdinarySets second = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        OrdinarySets intersection = first.intersection(second);
        assertIterableEquals(intersection.toIngredientsList(), first.toIngredientsList());
    }


    @Test
    public void setDifferenceDuplicate() {
        OrdinarySets first = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        OrdinarySets second = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        OrdinarySets difference = first.difference(second);
        assertIterableEquals(difference.toIngredientsList(), Arrays.asList());
    }


    @Test
    public void setXorDuplicate() {
        OrdinarySets first = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        OrdinarySets second = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        OrdinarySets xor = first.symmetricDifference(second);
        assertIterableEquals(xor.toIngredientsList(), Arrays.asList());
    }

    @Test
    public void setBitstring() {
        OrdinarySets oldFashioned = OrdinarySets.fromIngredients(universe, Arrays.asList(
            "simple syrup",
            "bitters",
            "whiskey"
        ));

        assertEquals(oldFashioned.toBitsIngredients(), "011000000100");
    }

    @Test
    public void multisetUnion() {
        Multiset<String> setA = HashMultiset.create(Arrays.asList(
			"Beer", "Beer", "Beer",
			"Beer", "Bloody Mary",
			"IPA", "IPA", "Diet Coke",
			"Margarita", "Margarita",
			"Lager", "Lager",
			"Lager", "Lager"
		));

        Multiset<String> setB = HashMultiset.create(Arrays.asList(
			"Rose", "Rose", "Margarita",
			"Diet Coke", "Diet Coke",
			"Diet Coke", "Diet Coke",
			"Sparkling Water" ,
			"Sparkling Water",
			"Mimosa", "Mimosa",
			"Chardonnay"
        ));

		String union = HashMultiset.create(MultiSets.union(setA, setB)).toString();

        assertTrue(union.contains("Margarita x 2"));
        assertTrue(union.contains("Chardonnay,"));
    }

    @Test
    public void multisetIntersection() {
        Multiset<String> setA = HashMultiset.create(Arrays.asList(
			"Beer", "Beer", "Beer",
			"Beer", "Bloody Mary",
			"IPA", "IPA", "Diet Coke",
			"Margarita", "Margarita",
			"Lager", "Lager",
			"Lager", "Lager"
		));

        Multiset<String> setB = HashMultiset.create(Arrays.asList(
			"Beer", "Beer", "Beer",
			"Beer", "Beer", "Beer",
			"Beer", "Beer", "Beer",
			"Bloody Mary"
        ));

		String intersection = HashMultiset.create(MultiSets.intersection(setA, setB)).toString();
        System.out.println(intersection);

        assertTrue(intersection.contains("Bloody Mary,"));
        assertTrue(intersection.contains("Beer x 4"));
    }

    @Test
    public void multisetDifference() {
        Multiset<String> setA = HashMultiset.create(Arrays.asList(
			"Beer", "Beer", "Beer",
			"Beer", "Bloody Mary",
			"IPA", "IPA", "Diet Coke",
			"Margarita", "Margarita",
			"Lager", "Lager",
			"Lager", "Lager"
		));

        Multiset<String> setB = HashMultiset.create(Arrays.asList(
			"Rose", "Rose", "Margarita",
			"Diet Coke", "Diet Coke",
			"Diet Coke", "Diet Coke",
			"Sparkling Water" ,
			"Sparkling Water",
			"Mimosa", "Mimosa",
			"Chardonnay"
        ));

		String difference = HashMultiset.create(MultiSets.difference(setA, setB)).toString();

        assertTrue(difference.contains("Lager x 4"));
        assertTrue(difference.contains("Margarita,"));
        
        assertFalse(difference.contains("Diet Coke"));
        assertFalse(difference.contains("Mimosa"));
    }

    @Test
    public void multisetSum() {
        Multiset<String> setA = HashMultiset.create(Arrays.asList(
			"Beer", "Beer", "Beer",
			"Beer", "Bloody Mary",
			"IPA", "IPA", "Diet Coke",
			"Margarita", "Margarita",
			"Lager", "Lager",
			"Lager", "Lager"
		));

        Multiset<String> setB = HashMultiset.create(Arrays.asList(
			"Rose", "Rose", "Margarita",
			"Diet Coke", "Diet Coke",
			"Diet Coke", "Diet Coke",
			"Sparkling Water" ,
			"Sparkling Water",
			"Mimosa", "Mimosa",
			"Chardonnay"
        ));

		String sum = HashMultiset.create(MultiSets.sum(setA, setB)).toString();

        assertTrue(sum.contains("Diet Coke x 5"));
        assertTrue(sum.contains("Mimosa x 2"));
    }

}
