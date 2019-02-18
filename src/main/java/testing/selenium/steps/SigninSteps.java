package testing.selenium.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import testing.selenium.page.SigninPage;


public class SigninSteps extends ScenarioSteps {

	SigninPage signinPage;
	
	public SigninSteps(Pages pages) {super(pages);}

	@Step
	public SigninSteps open_landing_page(){
		signinPage.open();
		return this;
	}

	@Step
	public SigninSteps signin_portal(String username, String password)
	{
		signinPage.enterCrendential(username,password);
		
		return this;
	}
	
	@Step
	public SigninSteps click_Signin()
	{
		signinPage.clickSignin();
		
		return this;
	}
	

}
