package testing.selenium.page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
/*import org.slf4j.LoggerFactory;*/

import com.dashboardreport.common.ReportParams;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;



@DefaultUrl("https://bitbucket.org/product")
public class SigninPage extends PageObject {
	public SigninPage(WebDriver driver) {
		super(driver);
		
	}
		
	//final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@FindBy(xpath="//a[@class='button blue-dark standard hero-section__cta']")
    WebElementFacade buttongetStarted;
	
	@FindBy(xpath="//a[@class='cms-link cms-link--text']")
    WebElementFacade linkLogin;
	
	
	String stepName="";
	String childPassDetails="";
	String childFailDetails="";
	public void clearReportVariable()
	{
		 stepName="";
		 childPassDetails="";
		 childFailDetails="";
	}
	

	@WhenPageOpens
    public void waitUntilMainElementsAppears() {
		System.out.println("Waiting");
        try {
        	buttongetStarted.waitUntilVisible();
        	linkLogin.waitUntilVisible();
        }catch(Exception e){
            System.out.println("Threw an exception....");
        }
    }
	public void clickSignin(){
		clearReportVariable();
		this.getDriver().manage().window().maximize();
			try {
				stepName="Click on sign in button";
				childPassDetails="sign in link successfully clicked";
				childFailDetails="Not able to click sign in link";
				linkLogin.click();
				captureTestCaseStepsInReport(true, stepName, childPassDetails,childFailDetails);
			} catch (Exception e) {
				captureTestCaseStepsInReport(false, stepName, childPassDetails,childFailDetails+e);
				System.out.println("Not able to click login link....");
				Assert.assertTrue( false);
			}
	 }
	
	public void enterCrendential(String username,String password)
	{
		try {
			stepName="Enter Credential ";
			childPassDetails="Enter into user text box";
			childFailDetails="Not able to enter value in user textbox";
		
			captureTestCaseStepsInReport(false, stepName, childPassDetails,childFailDetails);
			Assert.assertTrue( false);
		} catch (Exception e) {
			captureTestCaseStepsInReport(false, stepName, childPassDetails,childFailDetails+e);
			System.out.println("Not able to click login link....");
			Assert.assertTrue( false);
		}
		// System.out.println("Enter credential..............");
	}
	
	
	
	
	

	public String captureScreenShot(
		String screenShotName) {
		File sourcefile, destinationFile;
		String destinationPath =null;
		String destinationSupportedPath=null;
		String  timeStamp = new SimpleDateFormat("yyyy-MMMM-dd'_'HH-mm-ss'.html'").format(new Date());
		
		try {
				sourcefile = ((TakesScreenshot) this.getDriver()).getScreenshotAs(OutputType.FILE);
				destinationPath = "src\\main\\resources\\reports\\screenshots\\" + screenShotName + "_" + timeStamp+".png";
				destinationSupportedPath = "screenshots/" + screenShotName + "_" + timeStamp+".png";
				destinationFile = new File(destinationPath);
				org.apache.commons.io.FileUtils.copyFile(sourcefile, destinationFile);
							
		} catch (WebDriverException e) {
			//logger.error("Driver issue");
		} catch (IOException e) {
			//logger.error("File issue");
		}

		return destinationSupportedPath;
	}
	
	public void captureTestCaseStepsInReport(
			Boolean reportingFlag,
			String chieldStepName,
			String childPassDetails,
			String childFailDetails
			)
	{
		String screenShotPath = captureScreenShot(chieldStepName);

	if (reportingFlag == null) {
		//logger.info(chieldStepName + "::"+childFailDetails + "Status:: Unknown error");
 	   	 	//Added unknown error result in customized report
 	   		ReportParams.reportChildParams(chieldStepName,"Unknown error, Review required!",ReportParams.UNKNOWN,screenShotPath);

	} else {
		if (reportingFlag.equals(Boolean.TRUE)) {
			//logger.info(chieldStepName + "::"+childPassDetails + "Status:: Pass");
     	   	Assert.assertTrue(chieldStepName + "::"+childPassDetails , true);
     	   	//Added pass result in customized report
			ReportParams.reportChildParams(chieldStepName,childPassDetails,ReportParams.PASS,screenShotPath);
		}
		if (reportingFlag.equals(Boolean.FALSE)) {
			//logger.info(chieldStepName + "::"+childFailDetails + "Status:: Fail");
     	    //Added failed result in customized report
			ReportParams.reportChildParams(chieldStepName, childFailDetails,ReportParams.FAIL,screenShotPath);
		}
	}
}
	

}
