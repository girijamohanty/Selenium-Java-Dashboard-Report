package testing.selenium.steps;

import java.util.List;
import java.util.Map;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.model.GivenStories;
import org.jbehave.core.model.Lifecycle;
import org.jbehave.core.model.Meta;
import org.jbehave.core.model.Narrative;
import org.jbehave.core.model.OutcomesTable;
import org.jbehave.core.model.Scenario;
import org.jbehave.core.model.Story;
import org.jbehave.core.model.StoryDuration;
import org.jbehave.core.reporters.StoryReporter;

public class NewStoryReporter implements StoryReporter{

	
	private StoryReporter delegate;

	public NewStoryReporter(StoryReporter delegate) {
	    this.delegate = delegate;
	}

	@Override
	public void beforeStory(Story story, boolean givenStory) {
	    delegate.beforeStory(story, givenStory);
	}

	@Override
	public void beforeScenario(String scenarioTitle) {
	    delegate.beforeScenario(scenarioTitle);
	}

	@Override
	public void beforeStep(String step) {
	    if(step.equals("When after each step")){
	        return;
	    }
	    delegate.beforeStep(step);
	}

	@Override
	public void afterExamples() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterScenario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterStory(boolean arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeExamples(List<String> arg0, ExamplesTable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dryRun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void example(Map<String, String> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void failed(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void failedOutcomes(String arg0, OutcomesTable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void givenStories(GivenStories arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void givenStories(List<String> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ignorable(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void lifecyle(Lifecycle arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void narrative(Narrative arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notPerformed(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pending(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pendingMethods(List<String> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restarted(String arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restartedStory(Story arg0, Throwable arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scenarioMeta(Meta arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void scenarioNotAllowed(Scenario arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storyCancelled(Story arg0, StoryDuration arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void storyNotAllowed(Story arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void successful(String arg0) {
		// TODO Auto-generated method stub
		
	}

}


