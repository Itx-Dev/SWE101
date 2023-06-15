/**
 * @author Devin
 *
 */
public class FeatureSelector 
{
	RecipeData recipeData;
	
	int numberOfSamples;
	int numberOfIngredients;
	
	/**
	 * @param r
	 */
	public FeatureSelector(RecipeData r)
	{	
		recipeData = r;
		numberOfSamples = r.getNumberOfSamples();
		numberOfIngredients = r.getNumberOfIngredients();
	}
	
	/**
	 * @param cuisineNumber 
	 * @param ingredientNumber 
	 * @return total matches where the cuisine is desired and ingredient is included
	 * or cuisine is not desired and ingredient is absent
	 */
	public int mutualInformation(int cuisineNumber, int ingredientNumber)
	{
		boolean includedIngredient;
		// How many times the activeIngredient is in a recipe of activeCuisine
		int matches = 0;
		
		String ingredient, activeCuisine, wantedIngredientName, wantedCuisineName;
		// Desired cuisine
		wantedCuisineName = recipeData.getCuisineName(cuisineNumber);
		// Desired ingredient
		wantedIngredientName = recipeData.getIngredient(ingredientNumber);
		
		for (int recipeIndex = 0; recipeIndex < numberOfSamples; recipeIndex++)
		{
			// Get current cuisine name
			activeCuisine = recipeData.getRecipeCuisine(recipeIndex);
			
			for (int ingredientIndex = 0; ingredientIndex < numberOfIngredients; ingredientIndex++)
			{
				// Find ingredient name
				ingredient = recipeData.getIngredient(ingredientIndex);
				// Test if ingredient is in activeRecipe
				includedIngredient = recipeData.getRecipeIngredient(recipeIndex, ingredientIndex);
				
				// Match ingredient with index of for loop
				if (wantedIngredientName.equals(ingredient))
				{
					// If recipe is desired cuisine and desired 
					// ingredient is in recipe add 1 to matches
					if (wantedCuisineName.equals(activeCuisine) && includedIngredient)
					{
						matches++;
					}
					
					// If recipe is not desired cuisine and desired 
					// ingredient is absent in recipe add 1 to matches
					if (!wantedCuisineName.equals(activeCuisine) && !includedIngredient)
					{
						matches++;
					}
				}
			}
		}
		// Return all matches
		return matches;
	}
	
	/**
	 * @param ingredientNumber
	 * @return total mutualInformation for given ingredient
	 */
	public int totalMutualInformation(int ingredientNumber)
	{
		int totalMI= 0;
	
		// Loop through each recipe calling mutualInformation and adding return to sum
		for (int recipe = 0; recipe < numberOfSamples; recipe++)
		{
			totalMI = totalMI + mutualInformation(recipe, ingredientNumber);
		}
		
		// Return sum
		return totalMI;
	}
	
	/**
	 * @param numberOfFeatures
	 * @return int array with ingredient numbers sorted by how predictive it is
	 */
	public int[] topXFeatures(int numberOfFeatures)
	{
		// Function builds object array with ingredient number linked to total mutual information value
		MutualInformation[] objectArray = buildTotalMutualInformationPairs();
		
		// Bubble sort for array of objects
		// Sort list greatest to least
		for (int i = 0; i < numberOfFeatures - 1; i++)
		{
			// If first element is less than next element swap them
			if (objectArray[i].getTotalMutualInformation() < objectArray[i + 1].getTotalMutualInformation())
			{
				// Store first element value into temp
				MutualInformation temp = objectArray[i];
				// Set first element to value of second element
				objectArray[i] = objectArray[i + 1];
				// Replace second element with value of first stored in temp
				objectArray[i + 1] = temp;
			}
		}
		
		int[] ingredientNumberArray = new int[numberOfFeatures];
		
		// Put ingredient number from sorted object array into int array to return
		for (int i = 0; i < numberOfFeatures; i++)
		{
			ingredientNumberArray[i] = objectArray[i].getIngredientNumber();
		}
		
		// Return int array
		return ingredientNumberArray;	
	}
	
	/**
	 * Builds object array with ingredient number linked to total mutual information value
	 * @return Object Array
	 */
	public MutualInformation[] buildTotalMutualInformationPairs()
	{
		// Create object array with size of numberOfIngredients
		MutualInformation[] objectArray = new MutualInformation[numberOfIngredients];
		
		// Pair ingredient number with mutual information
				for (int ingredient = 0; ingredient < numberOfIngredients; ingredient++)
				{
					// Find total mutual information for each ingredient
					int tmi = totalMutualInformation(ingredient);
					// Put total mutual information in pair with 
					// ingredient number using mutual information class
					objectArray[ingredient] = new MutualInformation(ingredient, tmi);
				}
				return objectArray;
	}
}
