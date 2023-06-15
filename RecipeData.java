import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Devin
 *
 */
public class RecipeData 
{	
	private int numberOfSamples;
	private int numberOfIngredients;
	private String[] ingredients;
	private String[] cuisine;
	private String[] recipeCuisine;
	
	private boolean[][] recipeIngredients;
	
	/**
	 * Class Constructor
	 * @param fileTitle
	 * @throws FileNotFoundException 
	 */
	public RecipeData(String fileTitle) throws FileNotFoundException 
	{
		// Initialize scanner to receive data
		Scanner dataFile = new Scanner(new File(fileTitle));
		
		// Find # typed given in file, placed in index 3 of array from getAttribute func
		numberOfSamples = getAttribute(dataFile);
		getAttribute(dataFile);
		numberOfIngredients = getAttribute(dataFile);
		
		readIngredientsNames(dataFile);
		readCuisineNames(dataFile);
		setRecipeIngredients(dataFile);
	}
	
	/**
	 * @param cuisineName
	 * @param ingredientName
	 * @param recipeCuisineName
	 * @param recipeIngredientActive
	 */
	public RecipeData(String[] cuisineName, String[] ingredientName, 
					String[] recipeCuisineName, boolean[][] recipeIngredientActive)
	{
		ingredients = ingredientName;
		cuisine = cuisineName;
		recipeCuisine = recipeCuisineName;
		recipeIngredients = recipeIngredientActive;	
	}

	/**
	 * @return # of samples
	 */
	public int getNumberOfSamples()
	{
		return (recipeIngredients.length);
	}
	
	/**
	 * @return # of cuisines
	 */
	public int getNumberOfCuisines()
	{
		return (cuisine.length);
	}
	
	/**
	 * @return # of ingredients
	 */
	public int getNumberOfIngredients()
	{
		return(recipeIngredients[0].length);
	}

	/**
	 * @param i
	 * @return name of ingredient at index i
	 */
	public String getIngredient(int i)
	{
		return ingredients[i];
	}
	
	/**
	 * @param i
	 * @return cuisine name
	 */
	public String getCuisineName(int i)
	{
		return cuisine[i];
	}

	// Put each word of single line into an array to parse 
	private int getAttribute(Scanner dataFile) 
	{
		// Initialize String for selected line
		String line;
		
		// Initialize String array to put each word of line as elements of array parts
		String[] parts;
		
		// Read next line of file
		line = dataFile.nextLine();
		
		// Make array of line where each element is distinct by a space
		parts = line.split(" ");
		return Integer.parseInt(parts[3]);
	}
	
	/**
	 * @param recipeNumber
	 * @param ingredientNumber
	 * @return ingredients
	 */
	public boolean getRecipeIngredient(int recipeNumber, int ingredientNumber)
	{
		return (recipeIngredients[recipeNumber][ingredientNumber]);
	}
	
	/**
	 * Create 2D array with recipe # and if ingredient is in recipe
	 * @param dataFile
	 */
	private void setRecipeIngredients(Scanner dataFile)
	{
		// Initialize 2D boolean array with # of recipes as i
		recipeIngredients = new boolean[numberOfSamples][numberOfIngredients];
		recipeCuisine = new String[numberOfSamples];
				
		
		// Initialize String for selected line
		String line;
		
		// Move pointer to beginning of data
		line = dataFile.nextLine();	
		line = dataFile.nextLine();
		
		// Create 2D array that stores boolean on if ingredient is in recipe
		for (int recipeIndex = 0; recipeIndex < numberOfSamples; recipeIndex++)
		{
			// Move on to next data line
			line =  dataFile.nextLine();
			
			// Split 1s and 0s into array for presence of ingredient
			String[] parts = line.split(",");
			
			// Loop through each 1 or 0 if 1 set position to true
			for (int ingredientIndex = 0; ingredientIndex < numberOfIngredients; ingredientIndex++)
			{
				// Put cuisine names which are at end of ingredient list into cuisine array
				if ((ingredientIndex + 1) == numberOfIngredients)
				{
					recipeCuisine[recipeIndex] = parts[ingredientIndex + 1];
				}
				
				if (parts[ingredientIndex].equals("1"))
				{
					recipeIngredients[recipeIndex][ingredientIndex] = true;
				}
					
			}
		}
	}
	
	/**
	 * @param recipeNumber 
	 * @return name of cuisine for recipe
	 */
	public String getRecipeCuisine(int recipeNumber)
	{
		return (recipeCuisine[recipeNumber]);
	}
	
	/**
	 * Find names of ingredients and store in ingredients array
	 * @param dataFile
	 */
	private void readIngredientsNames(Scanner dataFile)
	{
		// Initialize String array for individual ingredients to be put into
		ingredients = new String[numberOfIngredients];
				
		// Move pointer to beginning of @Attributes in file
		dataFile.nextLine();
		dataFile.nextLine();
				
		// Put ingredients into array from file
		for (int i = 0; i < numberOfIngredients; i++)
			{
				String line =  dataFile.nextLine();
				String[] parts = line.split(" ");
				ingredients[i] = parts[1];
			}
	}
	
	/**
	 * Find names of cuisines and store in cuisine array
	 * @param dataFile
	 */
	private void readCuisineNames(Scanner dataFile)
	{
		// Move pointer to beginning of @Attribute class with cuisine names
		String line = dataFile.nextLine();
		
		// Split line of cuisine names into an array by spaces
		String[] parts = line.split(" ");
		
		// Create substring of just cuisine names, excluding everything except cuisine names
		line = parts[2].substring(1, parts[2].length() - 1);
		
		// Split each cuisine name into an array
		cuisine = line.split(",");
	}
	
}
