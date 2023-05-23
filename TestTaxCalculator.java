import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

/**
 * @author Devin
 *
 */
public class TestTaxCalculator {
	/**
	 * Everyone pays 5% in simplest form of tax
	 */
	@Test
	public void testSimpleTax()
	{
		TaxCalculator tc = new TaxCalculator();
		assertEquals(0.05 * 10000, tc.simpleTax(10000.00), 0.001);
		assertEquals(0.05 * 50000, tc.simpleTax(50000.00), 0.001);
	}
	
	/**
	 * In two level taxes, people who make less than $30,000 pay no
	 * tax and everyone else pays 5%. Test the border cases where
	 * the behavior changes and few other values.
	 */
	@Test
	public void testTwoLevelTax()
	{
		TaxCalculator tc = new TaxCalculator();
		
		assertEquals(0,  tc.twoLevelTax(29999.99), 0.001);
		assertEquals(30000 * 0.05, tc.twoLevelTax(30000), 0.001);
		
		assertEquals(0, tc.twoLevelTax(10000), 0.001);
		assertEquals(34567.89 * 0.05, tc.twoLevelTax(34567.89), 0.001);
	}
	
	
	/**
	 * In three level taxes, people who make less than $30,000 pay no 
	 * tax and people making at least $30,000 but not $50,000 pay
	 * 5% and everyone else pays 7%.
	 * */

	@Test
	 public void testThreeLevelTax()
	{
		TaxCalculator ct = new TaxCalculator();
		assertEquals(0, ct.threeLevelTax(29999.99), 0.001);
		assertEquals(30000 * 0.05, ct.threeLevelTax(30000), 0.001);
		assertEquals(49999.99 * 0.05, ct.threeLevelTax(49999.99), 0.001);
		assertEquals(50000 * 0.07, ct.threeLevelTax(50000), 0.001);
	}
	
	/**
	 * This tax gives you a break for every child you have. Your
	 * adjusted income is $1,000 less than your actual income for
	 * every child you have. Then your taxes are computed with the
	 * same three ranges as the three-level tax.
	 */
	
	@Test
	public void testSimpleDependents()
	{
		TaxCalculator ct = new TaxCalculator();
		assertEquals(0, ct.simpleDependentTax(32999.99, 3), 0.001);
		assertEquals(30000 * 0.05, ct.simpleDependentTax(34000, 4), 0.001);
		assertEquals(49999.99 * 0.05, ct.simpleDependentTax(51999.99, 2), 0.001);
		assertEquals(50000 * 0.07, ct.simpleDependentTax(53000, 3), 0.001);
	}
	
	/**
	 * In this tax, the deduction for your dependents depends on the
	 * number of children you have. The first three children result
	 * in a deductions of $1000 each, but if you have four or more 
	 * children, each result in a deduction of $1100. Your tax is
	 * 0 - 19,999.99: 5%
	 * 20,000 - and up: 15%
	 */
	@Test
	public void testTwoLevelDeduction()
	{
		TaxCalculator tc = new TaxCalculator();
		assertEquals(19999.99 * 0.05, tc.twoLevelDeductions(22999.99, 3), 0.001);
		assertEquals(19999.99 * 0.05, tc.twoLevelDeductions((19999.99 + 4400), 4), 0.001);
		assertEquals(20000 * 0.15, tc.twoLevelDeductions(23000, 3), 0.001);
		assertEquals(20000 * 0.15, tc.twoLevelDeductions(24400, 4), 0.001);
	}
	
	/**
	 * This tax is based on the income of two spouses. They pay 5%
	 * of the total of their income.
	 */
	@Test
	public void testSpouseSimple()
	{
		TaxCalculator tc = new TaxCalculator();
		assertEquals(40000.02 * 0.05, tc.spouseSimple(20000.01, 20000.01), 0.001);
		assertEquals(30000 * 0.05, tc.spouseSimple(20000, 10000), 0.001);
	
	}
	
	/**
	 * This tax is for married couples, and the tax depends on how
	 * far apart their salaries are. If the salaries are within
	 * $10,000 of each other, the tax is 5% of the total. If they 
	 * are more than $10,000 apart, the tax is 5% of the larger
	 * income plus 3% of the smaller one
	 */
	
	@Test
	public void testSpouseDistance()
	{
		TaxCalculator tc = new TaxCalculator();
		/* The border case here is when the difference between the
		 * salaries is 10,000 and the value changes at 10,000.01.
		 * Since the order of the parameters shouldn't matter, do
		 * both cases with both parameter orders 
		 */
		assertEquals(40000 * 0.05, tc.spouseDistance(25000,15000), 0.001);
		assertEquals(40000 * 0.05, tc.spouseDistance(15000, 25000), 0.001);
		assertEquals(30000.01 * 0.05 + 20000 * 0.03,
								tc.spouseDistance(20000.00, 30000.01), 0.001);
		assertEquals(30000.01 * 0.05 + 20000 * 0.03,
								tc.spouseDistance(30000.01, 20000.00), 0.001);
	}
	
	/**
	 * This tax includes an alternative minimum tax for people in the
	 * top bracket. Incomes are adjusted by $1000 for each
	 * dependent and the tax levels are:
	 * 0 - 29,999.99: 0%
	 * 30,000 - 79,999.99: 5%
	 * 80,000 and up: 10%
	 * However, if you are in the top tax bracket and your deductions 
	 * are more than 10% of your income, you pay taxes on your entire
	 * income.
	 */
	
	@Test
	public void testAlternateMinumumTax()
	{
		TaxCalculator ct = new TaxCalculator();
		assertEquals(0, ct.alternateMinimum(32999.99, 3), 0.001);
		assertEquals(30000 * 0.05, ct.alternateMinimum(34000.00, 4), 0.001);
		assertEquals(79999.99 * 0.05, ct.alternateMinimum(81999.99, 2), 0.001);
		assertEquals(80000 * 0.10, ct.alternateMinimum(83000, 3), 0.001);
		assertEquals((100000 - 10000) * 0.10,
									ct.alternateMinimum(100000, 10), 0.001);
		assertEquals(99999.99 * 0.10, ct.alternateMinimum(99999.99, 10), 0.001);
	}
	
	/**
	 * This is a single income tax with three tax levels:
	 * 0 - 19,999.99: 0%
	 * 20,000 - 39,999.99: 5%
	 * 40,000 and up: 10%
	 * Everyone gets a $1000 deduction per dependent
	 * However, it also includes these special instructions
	 * - for the middle tax group, if their mortgage interest is 
	 * more than 2% of their adjusted income, they can deduct it 
	 * from that adjusted income
	 * - for the top tax bracket, if their total deductions are
	 * more than 10% of their income, they pay taxes on their
	 * entire income
	 * 
	 * The parameters to specialTaxLaws are
	 * - income
	 * - number of dependents
	 * - mortgage interest paid
	 */
	
	@Test
	public void testSpecialTaxLaws()
	{
		TaxCalculator ct = new TaxCalculator();
		// test the border between the first two brackets
		assertEquals(0, ct.specialTaxLaws(22999.99, 3, 0.0), 0.001);
		assertEquals(20000 * 0.05, ct.specialTaxLaws(24000.00, 4, 0.0), 0.001);

		// test the border between the top two brackets
		assertEquals(39999.99 * 0.05, ct.specialTaxLaws(41999.99, 2, 0.0), 0.001);
		assertEquals(40000 * 0.10, ct.specialTaxLaws(43000, 3, 0.0), 0.001);

		// in the middle bracket, we also need to test the border
		
		//for mortgage interest
		assertEquals(30000 * 0.05, ct.specialTaxLaws(30000, 0, 30000 * 0.02), 0.001);
		assertEquals((30000 - (30000 * 0.02 + 0.01)) * 0.05,
						ct.specialTaxLaws(30000, 0, 30000 * 0.02 + 0.01), 0.001);
		
		// also, do one with dependents to make sure it's comparing
		// with the adjusted income
		assertEquals((30000 - (30000 * 0.02 + 0.01)) * 0.05,
						ct.specialTaxLaws(31000, 1, 30000 * 0.02 + 0.01), 0.001);

		// in the top bracket, we also need to test the border of
		// the alternate minimum tax
		assertEquals((100000 - 10000) * 0.10,
						ct.specialTaxLaws(100000, 10, 0.0), 0.001);
		assertEquals(99999.99 * 0.10, 
						ct.specialTaxLaws(99999.99, 10, 0.0), 0.001);
	}
}