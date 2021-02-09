
public class TestFormPage {

	private DSL dsl;
	
	public TestFormPage() {
		dsl = new DSL();
		
	}
	
	public void setName(String name) {
		dsl.write("//input[@type='text']", name);
	}
	
	public void setMonth(String month) {
		dsl.selectCombo("//select[@name='month']", month);
	}
	
	public void setYear(String year) {
		dsl.selectCombo("//select[@name='year']", year);
	}
	
	public void setSubmit() {
		dsl.clickSubmit("lfr-ddm-form-submit");
	}
	
	public void setText(String text) {
		dsl.write("//textarea[@type='text']", text);
	}
	
	public void setClickCalendar() {
		dsl.clickButton("//input[@ref='inputElement']");
	}
	
	public void setClickDay() {
		dsl.clickButton("//html/body/div[1]/div/div/div/div/div/div/form/div[3]/div/div/div/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div/div[3]/div[3]/div[7]");
	}
}
