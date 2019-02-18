package testing.selenium.stepdefinitions;

import java.io.File;
import java.util.List;
import java.util.Map.Entry;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.ScenarioType;
import com.dashboardreport.common.DashboardReportTest;
import com.dashboardreport.common.ReportParams;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import jline.internal.Log;
import testing.selenium.common.CommonUtils;

public class AbstractBaseSteps {

	//final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	String argPass = "Abstract Base Steps::>>>>>>>>>>>>>>>>>>>>>";
	String argFail = "Abstract Base Steps::<<<<<<<<<<<<<<<<<<<<<";
	
	
	static ATUTestRecorder recorder;
	static int count=1;
	static boolean isRecorderStopped = false;
	@BeforeScenario(uponType = ScenarioType.ANY)
	public void clearAndIntialize() {
		ReportParams.clearAndInitializeParams();
		String value= generateMultipleLineOutput("Clear And Initialize Parameters for Report ");
		Log.info(value);
	}
	@BeforeStories
	public void beforeStory()
	{
		try {
			if(recorder == null )
			{
				Log.info(argPass+" Starting Recording");
				System.setProperty("java.awt.headless", "false");
	
				// check first if target exists, if yes then create recording folder
				if (new File(System.getProperty("user.dir")+"\\target").exists())
				{
					// check if recording folder exists, else create new
					if (!new File(System.getProperty("user.dir")+"\\target\\recording").exists())
					{
						// create recording folder
						new File(System.getProperty("user.dir")+"\\target\\recording").mkdir();
					}
					recorder = new ATUTestRecorder(System.getProperty("user.dir")+"\\target\\recording","Record0"+count,false);
					recorder.start(); 
					count ++;
					isRecorderStopped = false;
				}
			}
		} catch (ATUTestRecorderException e) {			
			//Log.error(argFail+"Error in BeforeStory"+e.getMessage());
		}
		catch (Exception e) {			
			//Log.error(argFail+" Error in BeforeStory"+e.getMessage());
		}
	}
	
	@AfterStories
	public void afterStory()
	{
		try {
			if(recorder != null)
			{
				if(!isRecorderStopped)
				{
					//Log.info(argPass+" Stopping Recorder");
					recorder.stop();
					isRecorderStopped = true;
					recorder = null;
				}
			}
		} catch (ATUTestRecorderException e) {
			Log.error(argFail+" Error in AfterStory"+e.getMessage());
		} catch (Exception e) {			
			Log.error(argFail+" Error in AfterStory"+e.getMessage());
		}
		
	}
	
	
	@AfterScenario(uponType = ScenarioType.ANY)
	public void generateReportOperation()
	{
		
			//CommonUtils utils= new CommonUtils();
    	
			String storyName="Demo";
			
			for (String status : ReportParams.childNodesStatusList) {
				Log.info(argPass+"Status:"+status);
			}
			for (String description : ReportParams.childNodesDescriptionList) {
				Log.info(argPass+"Description:"+description);
			}
			String environName= "Stage";
			String browser = "Firefox";
			
			String finalOutput="&#10026"+" Browser :"+browser+"&#10026"+" Environment :" +environName;
			int i = 0;
			for (Entry<String, List<String>> childinfo : ReportParams.childInfoMap.entrySet())
			{
				String key = childinfo.getKey().toString();
				List<String> value = childinfo.getValue();
				Log.info(argPass+"<KEY>: " 
						+ key 
						+ " <VALUE DESCRIPTION> : " 
						+ value.get(i) 
						+ " <VALUE STATUS> : "
						+ value.get(i + 1));
				i = i + 3;

			}
			
			DashboardReportTest dashboardReportObj = new DashboardReportTest(storyName, ReportParams.childInfoMap);
			dashboardReportObj.generateDashboardReport(finalOutput);
			String value= generateMultipleLineOutput("Dashboard Report Generated");
			Log.info(value);
		
}
	
	public String generateMultipleLineOutput(String arg)
	 {
		String output ="\n******************************************************************************************************************************\n"
			         + "******************************************************************************************************************************\n"
			         + "*****************************************"+arg+"*******************************************\n"
			         + "******************************************************************************************************************************\n"
			         + "******************************************************************************************************************************";
				 
		return output;
	 }
	
}
