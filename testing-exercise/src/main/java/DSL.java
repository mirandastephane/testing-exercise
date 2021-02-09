import static br.ce.sduarte.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DSL {
	
	public void write(String xpath_field, String text) {
		getDriver().findElement(By.xpath(xpath_field)).sendKeys(text);
	}
	
	public String getFieldValue(String xpath_field) {
		return getDriver().findElement(By.xpath(xpath_field)).getAttribute("value");
	}

	public void selectCombo(String xpath_field, String value) {
		WebElement element = getDriver().findElement(By.xpath(xpath_field));
		Select combo = new Select(element);
		combo.selectByVisibleText(value);
	}

	public String getComboValue(String xpath_field) {
		WebElement element = getDriver().findElement(By.xpath(xpath_field));
		Select combo = new Select(element);
		return combo.getFirstSelectedOption().getText();
	}
	
	public void clickButton(String xpath_field) {
		getDriver().findElement(By.xpath(xpath_field)).click();
	}

	public void clickSubmit(String class_field) {
		getDriver().findElement(By.className(class_field)).click();
	}
	
	public String getMessageText() {
		return getDriver().findElement(By.xpath("//*[@id=\"p_p_id_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_\"]/div/div/div/div/h5")).getText();
	}
}
