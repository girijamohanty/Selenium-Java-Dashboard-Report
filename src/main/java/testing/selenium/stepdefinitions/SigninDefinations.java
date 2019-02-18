package testing.selenium.stepdefinitions;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.When;
import net.thucydides.core.annotations.Steps;
import testing.selenium.common.CommonUtils;
import testing.selenium.steps.SigninSteps;

public class SigninDefinations  {
    @Steps
    SigninSteps signinSteps;


	
    
    @Given("user launch bitbucket portal")
    public void open_landing_page(@Named("testCaseName") String testCaseName){
    	CommonUtils utils= new CommonUtils();
    	utils.setStoryName(testCaseName);
    	signinSteps.open_landing_page();
    }
    
    @When("the user login with $username and $password")
    public void signin_portal(
    		@Named("username") String username,
			@Named("password") String password){
    	
    	signinSteps.click_Signin();
    	signinSteps.signin_portal(username,password);
    }
   
    
    
}
