import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

/**
 * @author Devin
 *
 */
public class RecipeDataTest {

	/**
	 * Test Constructor
	 * @throws FileNotFoundException
	 */
	@Test
	 public void constructor() throws FileNotFoundException
	 {
		RecipeData r = new RecipeData("short.arff");
		assertEquals(4, r.getNumberOfSamples());
		assertEquals(8, r.getNumberOfCuisines());
		assertEquals(14, r.getNumberOfIngredients());
		
		r = new RecipeData("short2.arff");
		assertEquals(6, r.getNumberOfSamples());
		assertEquals(7, r.getNumberOfCuisines());
		assertEquals(12, r.getNumberOfIngredients());
	 }
	
	/**
	 * Test Ingredients
	 * @throws FileNotFoundException
	 */
	@Test
	public void testIngredients() throws FileNotFoundException
	{
		RecipeData r = new RecipeData("short.arff");
		assertEquals("lettuce", r.getIngredient(0));
		assertEquals("beans", r.getIngredient(7));
		assertEquals("eggs", r.getIngredient(r.getNumberOfIngredients() - 1));
	}
	
	/**
	 * @throws FileNotFoundException
	 */
	@Test
	public void testCuisineNames() throws FileNotFoundException
	{
		RecipeData r = new RecipeData("short.arff");
		assertEquals("greek", r.getCuisineName(0));
		assertEquals("french", r.getCuisineName(4));
		assertEquals("korean", r.getCuisineName(r.getNumberOfCuisines() - 1));
	}
	
	/**
	 * Test First Recipe
	 * @throws FileNotFoundException
	 */
	@Test
	public void testFirstRecipe() throws FileNotFoundException
	{
		RecipeData r = new RecipeData("short.arff");
		assertTrue(r.getRecipeIngredient(0, 0));
		assertFalse(r.getRecipeIngredient(0, 7));
		assertTrue(r.getRecipeIngredient(0, 13));
		assertEquals("southern_us", r.getRecipeCuisine(0));
		
		RecipeData r2 = new RecipeData("short2.arff");
		assertTrue(r2.getRecipeIngredient(0, 0));
		assertFalse(r2.getRecipeIngredient(0, 6));
		assertTrue(r2.getRecipeIngredient(0, 11));
		assertEquals("southern_us", r.getRecipeCuisine(0));
	}
	
	/**
	 * Test last recipe
	 * @throws FileNotFoundException
	 */
	@Test
	public void testLastRecipe() throws FileNotFoundException
	{
		RecipeData r = new RecipeData("short.arff");
		assertTrue(r.getRecipeIngredient(3, 0));
		assertTrue(r.getRecipeIngredient(3, 6));
		assertFalse(r.getRecipeIngredient(3, 13));
		assertEquals("korean", r.getRecipeCuisine(3));
		
		RecipeData r2 = new RecipeData("short2.arff");
		assertTrue(r2.getRecipeIngredient(5, 0));
		assertFalse(r2.getRecipeIngredient(5, 6));
		assertFalse(r2.getRecipeIngredient(5, 11));
		assertEquals("southern_us", r.getRecipeCuisine(0));
	}
	
	/**
	 * Test overloaded constructor
	 */
	@Test
	public void testRiggedConstructor()
	{
		String[] ingredient = {"salt", "pepper", "thyme", "eggs",};
		String[] cuisines = {"good food", "italian", "korean", "icky food", "homecooking"};
		String[] recipeCuisine = {"good food", "korean", "korean", "italian", "homecooking"};
		boolean[][] recipeIngredients = {{true, false, true, false},
										 {false, true, false, false},
										 {true, true, true, true},
										 {false, false, false, false},
										 {true, false, false, true}};
		
		RecipeData r = new RecipeData(cuisines, ingredient, recipeCuisine, recipeIngredients);
		
		// Verify the big numbers
		assertEquals(5, r.getNumberOfSamples());
		assertEquals(5, r.getNumberOfCuisines());
		assertEquals(4, r.getNumberOfIngredients());
		
		// Spot check some recipe data
		assertFalse(r.getRecipeIngredient(3, 0));
		assertEquals("italian", r.getRecipeCuisine(3));
	}
}
