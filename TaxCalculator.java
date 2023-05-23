/**
 * @author Devin
 *
 */
public class TaxCalculator {
	
	/**
	 * @param income
	 * @return return income at tax rate of 5%
	 */
	public double simpleTax(double income)
	{
		return (income * 0.05);
	}

	/**
	 * @param income
	 * @return taxed amount if income is above $30,000, if below return 0
	 * 
	 */
	public double twoLevelTax(double income)
	{
		if (income >= 30000)
		{
			return (income * 0.05);
		} else {
			return 0;
		}
	}
	
	/**
	 * @param income
	 * @return tax at 7% if income is above $50,000, if less than $50,000
	 * but more than $30,000 return tax at rate of 5%, or if less than
	 * $30,000 return 0
	 */
	public double threeLevelTax(double income)
	{
		if (income >= 50000) 
		{
			return (income * 0.07);
		} else if (income >= 30000) 
		{
			return (income * 0.05);			
		} else 
		{
			return 0;
		}
		
	}
	
	
	/**
	 * @param income
	 * @param dependent
	 * @return Subtract $1,000 for each dependent from income then run
	 * threeLevelIndex with adjusted income
	 */
	public double simpleDependentTax(double income, int dependent)
	{
		double adjustedIncome = income - (dependent * 1000);
		return threeLevelTax(adjustedIncome);
	}
	
	/**
	 * @param income
	 * @param dependent
	 * @return tax rate times adjusted income based on conditions
	 */
	public double twoLevelDeductions(double income, int dependent)
	{
		double taxRate, adjustedIncome;
		
		if (dependent >= 4)
		{
			// If 4 or more dependents
			adjustedIncome = (income - (dependent * 1100));
		} else 
		{
			// If less than 4 dependents
			adjustedIncome = (income - (dependent * 1000));
		}
		
		if (adjustedIncome >= 20000)
		{
			// If adjusted income is above $20,000
			taxRate = 0.15;
		} else 
		{
			// If adjusted income is below $20,000
			taxRate = 0.05;
		}
		
		return (adjustedIncome * taxRate);	
	}
	
	
	/**
	 * @param firstIncome
	 * @param secondIncome
	 * @return 5% tax of sum of both incomes
	 */
	public double spouseSimple(double firstIncome, double secondIncome)
	{
		return ((firstIncome + secondIncome) * 0.05);
	}
	
	/**
	 * @param firstIncome
	 * @param secondIncome
	 * @return if within $10,000 return sum of incomes times 5% tax rate
	 * if out of $10,000 range return tax of larger income time 5% tax rate
	 * plus the smaller income times the tax rate of 3%
	 */
	public double spouseDistance(double firstIncome, double secondIncome)
	{
		double incomeDifference = firstIncome - secondIncome;
		incomeDifference = Math.abs(incomeDifference);
		
		if (incomeDifference <= 10000)
		{
			return ((firstIncome + secondIncome) * 0.05);
		} else 
		{
			if (firstIncome > secondIncome)
			{
				return ((firstIncome * 0.05) + (secondIncome * 0.03));
			} else 
			{
				return ((firstIncome * 0.03) + (secondIncome * 0.05));
			}
		}
	}
	
	/**
	 * @param income
	 * @param dependents
	 * @return 0 if income is less than $30,000, 
	 * 5% tax less than $80,000 but greater than or equal to $30,000
	 * 10% tax if greater than or equal to $80,000 but tax whole
	 * income if 10% of income is equal or less than dependents
	 */ 
	public double alternateMinimum(double income, int dependents)
	{
		double adjustedIncome = income - (dependents * 1000);
		if (adjustedIncome >= 80000)
		{
			if ((income * 0.10) < (dependents * 1000)) 
			{
				return (income * 0.10);
			} else 
			{
			return (adjustedIncome * 0.10);
			}
		} else if (adjustedIncome >= 30000) 
		{
			return (adjustedIncome * 0.05);
		} else 
		{
			return 0;
		}
	}
	
	
	/**
	 * @param income
	 * @param dependents
	 * @param mortgageInterestPaid
	 * @return 0 if in bottom tax group
	 * if middle tax group tax 5% however, if 2% of adjust income is more than mortgage
	 * interest paid deduct mortgage interest paid from adjusted income
	 * if top tax group and 10% of income is more than deductions
	 * tax 10% of whole income else just tax adjusted income.
	 */
	public double specialTaxLaws(double income, int dependents, double mortgageInterestPaid)
	{
		double adjustedIncome, incomeTax;
		// Adjust income for dependents
		adjustedIncome = (income - (dependents * 1000));
		
		// Top tax group
		if (adjustedIncome >= 40000)
		{
			incomeTax = 0.10;
			// If 10% of income is greater than deductions
			// Tax entire income
			if ((income * incomeTax) < (dependents * 1000))
			{
				return (income * incomeTax);
			} else 
			{
				// Tax adjusted income if deductions are 
				// less than 10% of income.
				return (adjustedIncome * incomeTax);
			}
		} 
		// Middle tax group
		else if (adjustedIncome >= 20000)
		{
			incomeTax = 0.05;
			// If mortgage interest paid is greater than 2% of adjusted income
			// deduct from adjusted income
			if (mortgageInterestPaid > (adjustedIncome * 0.02))
			{
				return ((adjustedIncome - mortgageInterestPaid) * incomeTax);
			} else 
			{
				// If mortgage interest paid is less than 2% tax
				// adjusted income by 5%
				return (adjustedIncome * incomeTax);
			}
		} 
		// Bottom tax group
		else 
		{
			return 0;
		}
	}
}
