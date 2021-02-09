import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.sduarte.core.DriverFactory;

@RunWith(Suite.class)
@SuiteClasses({
	TestForm.class
})

public class TestSuite {
	
	@AfterClass
	public static void endAll() {
		DriverFactory.killDriver();
	}

}
