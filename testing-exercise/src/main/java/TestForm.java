
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import org.junit.Assert;

public class TestForm {

	private WebDriver driver;

	@Before
	public void start() {
		driver = new FirefoxDriver();
		driver.get("https://forms.liferay.com/web/forms/shared/-/form/122548");
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
	}

	@After
	public void end() {
		//driver.quit();
	}

	@Test
	public void ValidateSubmitFormWithValidEntries() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mariane Nat�lia Figueiredo");
		driver.findElement(By.xpath("//input[@ref='inputElement']")).click();
		new Select(driver.findElement(By.xpath("//select[@name='month']"))).selectByVisibleText("August");
		new Select(driver.findElement(By.xpath("//select[@name='year']"))).selectByVisibleText("2018");
		driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div[3]/div[7]")).click();
		driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("To listen to my machine works");
		driver.findElement(By.className("lfr-ddm-form-submit")).click();
		
		Assert.assertEquals("Information sent successfully!", driver.findElement(By.xpath("//*[@id=\"p_p_id_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_\"]/div/div/div/div/h5")).getText());
	}

	@Test
	public void ValidateSubmitFormWithFutureDateOfBirth() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Aline Antonella Castro");
		driver.findElement(By.xpath("//input[@ref='inputElement']")).click();
		new Select(driver.findElement(By.xpath("//select[@name='month']"))).selectByVisibleText("June");
		new Select(driver.findElement(By.xpath("//select[@name='year']"))).selectByVisibleText("2023");
		driver.findElement(By.xpath("//html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div[5]/div[1]")).click();
		driver.findElement(By.xpath("//textarea[@type='text']")).sendKeys("To listen to \"my machine works");
		driver.findElement(By.className("lfr-ddm-form-submit")).click();
		
		Assert.assertEquals("Invalid data, check the information", driver.findElement(By.xpath("//*[@id=\"p_p_id_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_\"]/div/div/div/div/h5")).getText());
	}
}
