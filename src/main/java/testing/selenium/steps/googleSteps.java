package testing.selenium.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import testing.selenium.page.goDashboard;
import testing.selenium.page.goLanding;

public class googleSteps extends ScenarioSteps {

	goLanding landingPage;
	goDashboard dashboardPage;

	public googleSteps(Pages pages) {super(pages);}

	@Step
	public googleSteps open_landing_page(){
		landingPage.open();
		return this;
	}

	@Step
	public googleSteps search_for_keyword(String keyword){
		landingPage.search(keyword.toLowerCase());
		return this;
	}

	@Step
	public googleSteps find_in_results(String keyword){
		landingPage.findUrl(keyword.toLowerCase());
		return this;
	}
}
