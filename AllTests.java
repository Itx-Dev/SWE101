import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Runs all of the tests in our game
 * @author Devin
 */

@RunWith(Suite.class)
@Suite.SuiteClasses(
{
	TestZombie.class,
	TestHuman.class
})

public class AllTests 
{
}
