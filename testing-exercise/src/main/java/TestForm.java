import static br.ce.sduarte.core.DriverFactory.getDriver;
import static br.ce.sduarte.core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.sduarte.core.Properties;


public class TestForm {

	private DSL dsl;
	private TestFormPage page;

	@Before
	public void start() {
		getDriver().get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		dsl = new DSL();
		page = new TestFormPage();
	}

	@After
	public void end() {
		if(Properties.CLOSE_BROWSER) {
			killDriver();	
		}
	}

	@Test
	public void ValidateSubmitFormWithValidEntries() throws InterruptedException{
		
		Thread.sleep(500);
		
		page.setName("Mariane Nathalia Figueiredo");
		
		Assert.assertEquals("Mariane Nathalia Figueiredo", dsl.getFieldValue("//input[@type='text']"));
		
		Thread.sleep(500);
		page.setClickCalendar();
		
		
		page.setMonth("August");
		Assert.assertEquals("August", dsl.getComboValue("//select[@name='month']"));
		
		page.setYear("2018");
		Assert.assertEquals("2018", dsl.getComboValue("//select[@name='year']"));

		page.setClickDay();
		
		Thread.sleep(500);
		
		page.setText("To listen to my machine works");
		Assert.assertEquals("To listen to my machine works", dsl.getFieldValue("//textarea[@type='text']"));
		
		Thread.sleep(800);
		page.setSubmit();
		
		Thread.sleep(1500);
		Assert.assertEquals("Invalid data, check the information", dsl.getMessageText()); 
	}
	
	 @Test public void ValidateSubmitFormWithFutureDateOfBirth() throws InterruptedException {
		 
		Thread.sleep(500);

		page.setName("Aline Antonella Castro");
		
		Assert.assertEquals("Aline Antonella Castro", dsl.getFieldValue("//input[@type='text']"));
	  
		Thread.sleep(500);
		page.setClickCalendar();
		
		page.setMonth("June");
		Assert.assertEquals("June", dsl.getComboValue("//select[@name='month']"));
		
		page.setYear("2023");
		Assert.assertEquals("2023", dsl.getComboValue("//select[@name='year']"));
	  
		page.setClickDay();
	  
		Thread.sleep(500);
		page.setText("To listen to my machine works");
		Assert.assertEquals("To listen to my machine works", dsl.getFieldValue("//textarea[@type='text']"));
	  
		Thread.sleep(800);
		
		page.setSubmit();
	  
		Thread.sleep(1500);
		Assert.assertEquals("Invalid data, check the information", dsl.getMessageText()); 
	  }
}
