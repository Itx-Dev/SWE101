import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author Devin
 */
public class TestFeatureSelector 
{
	private static final String[] ingredients =
		{"salt", "pepper", "thyme", "eggs"};
	private static final String[] cuisines = 
		{"good food", "italian", "korean", "icky food", "homecooking"};
	private static final String[] recipeCuisines =
		{"good food", "korean", "korean", "italian", "homecooking"};
	private static final boolean[][] recipeIngredients =
		{{true, false, true, true},
		 {false, true, true, true},
		 {true, true, true, true},
		 {false, false, false, false},
		 {true, false, true, true}};
	
	/**
	 * Test mutual information
	 */
	@Test
	public void testMutualInformation()
	{
		RecipeData r = new RecipeData(cuisines, ingredients, recipeCuisines, recipeIngredients);
		FeatureSelector fs = new FeatureSelector(r);
		assertEquals(5, fs.mutualInformation(2, 1));
		assertEquals(2, fs.mutualInformation(2, 0));
		assertEquals(2, fs.mutualInformation(4, 3));
	}
	
	/**
	 * Test sum of mutual information
	 */
	@Test
	public void testTotalMutualInformation()
	{
		RecipeData r = new RecipeData(cuisines, ingredients, recipeCuisines, recipeIngredients);
		FeatureSelector fs = new FeatureSelector(r);
		assertEquals(3+1+2+2+3, fs.totalMutualInformation(0));
		assertEquals(2+2+5+3+2, fs.totalMutualInformation(1));
	}
	
	/**
	 * Test top X feature with rigged constructor
	 */
	@Test
	public void testTopXFeaturesRigged()
	{
		RecipeData r = new RecipeData(cuisines, ingredients, recipeCuisines, recipeIngredients);
		FeatureSelector fs = new FeatureSelector(r);
		int[] expected = {1, 0};
		int[] actual = fs.topXFeatures(2);
		for (int i = 0; i < expected.length; i++)
		{
			assertEquals(expected[i], actual[i]);
		}
	}
	
	/**
	 * Test all of total mutual information 
	 */
	@Test
	public void testAllTotalMutualInformation()
	{
		RecipeData r = new RecipeData(cuisines, ingredients, recipeCuisines, recipeIngredients);
		FeatureSelector fs = new FeatureSelector(r);
		MutualInformation[] expected = { new MutualInformation(0, 11), 
				new MutualInformation(1, 14), new MutualInformation(2, 8),
				new MutualInformation(3,  8) };
		MutualInformation[] actual = 
				fs.buildTotalMutualInformationPairs();
		for (int i = 0; i < expected.length; i++)
		{
			assertEquals(expected[i].getIngredientNumber(), 
						 actual[i].getIngredientNumber());
			assertEquals(expected[i].getTotalMutualInformation(), 
						 actual[i].getTotalMutualInformation());
		}
	}

}
