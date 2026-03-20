package project2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testing {

    @BeforeEach
    public void setupUniverse() {
        UniversalSet uniIngredients = new UniversalSet(Arrays.asList(
				"lime juice", "simple syrup", "bitters", "olives", 
				"bloody mary mix", "sweet vermouth", "soda water", 
				"tonic water", "lemon juice", "whiskey", "tequila", "vodka"));
    }
    
    @Test
    public void setUnionNormal() {
        
    }
}
