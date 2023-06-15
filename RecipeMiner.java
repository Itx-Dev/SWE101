import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Devin
 *
 */
public class RecipeMiner 
{
	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		// Initialize data to null
		RecipeData recipeData = null;
		
		// Define scanner for input
		Scanner keyboard = new Scanner(System.in);
		
		// Get data from function
		recipeData = getFileForUser(recipeData, keyboard);
		
		FeatureSelector fs = new FeatureSelector(recipeData);

		int numberOfFeatures = getNumberOfFeatures(keyboard);
		int[] featureArray = new int[numberOfFeatures];
		
		featureArray = fs.topXFeatures(numberOfFeatures);
		
		try {
			System.out.print("The most predictive feature are: ");
			for (int i = 0; i < numberOfFeatures; i++)
			{
				System.out.print(featureArray[i] + ", ");
			}
			System.out.println();
		}
		catch (Exception e) {
			System.out.println("There was a problem");
		}
			
		// Tell user how many cuisines they have
		System.out.println("Your file has " + recipeData.getNumberOfCuisines() + " cuisines");
	}
	
	private static RecipeData getFileForUser(RecipeData data, Scanner keyboard)
	{
		// Run until valid file is given
				while (data == null)
				{
					// Ask user for file
					System.out.println("Please enter a file title:");
					
					// Read input from user
					String input = keyboard.nextLine();
					
					try {
						// Receive input
						data = new RecipeData(input);
						
					} 
					catch ( FileNotFoundException e)
					{
						// Tell user file is not found
						System.out.println("I couldn't find that file, fool!");
					}
				}
				return data;
	}
	
	private static int getNumberOfFeatures(Scanner keyboard)
	{
		System.out.println("How many features?:");
		
		String numberOfFeatureString = keyboard.nextLine();
		
		int numberOfFeaturesInt = Integer.parseInt(numberOfFeatureString);
		
		return numberOfFeaturesInt;
	}
}
